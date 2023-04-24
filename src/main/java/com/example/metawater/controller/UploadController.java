package com.example.metawater.controller;
import org.springframework.http.MediaType;

import com.example.metawater.dto.UploadResultDTO;
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@Log4j2

public class UploadController {

    @Value("${metawater.upload.path}") //파일 저장 경로
    private String uploadPath;



    //파일 여러개 업로드
    @PostMapping("/upload/files")
    public ResponseEntity<List<UploadResultDTO>> uploadFiles(@RequestParam("files") MultipartFile[] uploadFiles){
        List<UploadResultDTO> resultDTOList = new ArrayList<>();


        for(MultipartFile uploadFile : uploadFiles){

            UploadResultDTO uploadResultDTO = new UploadResultDTO();

            //이미지 파일만 업로드 가능
            if(uploadFile.getContentType().startsWith("image") == false){
                log.warn("이미지 파일이 아닙니다.");
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }

            //파일 이름만 추출
            String originalName = uploadFile.getOriginalFilename();
            String fileName = originalName.substring(originalName.lastIndexOf("\\")+1);
            log.info("fileName: " + fileName);
            uploadResultDTO.setFileName(fileName);


            //날짜 폴더 생성
            String folderPath = makeFolder();

            //UUID
            String uuid = UUID.randomUUID().toString();


            //저장할 파일 이름 중간에 "-"를 이용해서 구분
            String saveName = uploadPath + File.separator + folderPath + File.separator + uuid + "_" + fileName;

            Path savePath = Paths.get(saveName);

            try{
                uploadFile.transferTo(savePath);
                uploadResultDTO.setUuid(uuid);
                uploadResultDTO.setFolderPath(folderPath);

                //섬네일 생성
                String thumbnailSaveName = uploadPath + File.separator + folderPath + File.separator + "s_" + uuid +"_" + fileName;

                //섬네일 파일 이름은 중간에 s_로 시작하도록
                File thumbnailFile = new File(thumbnailSaveName);

                //섬네일 생성
                Thumbnailator.createThumbnail(savePath.toFile(), thumbnailFile, 80, 100);



                resultDTOList.add(uploadResultDTO);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return new ResponseEntity<>(resultDTOList, HttpStatus.OK);
    }

    //사용설명서 업로드
    @PostMapping("/upload/guide")
    public ResponseEntity<UploadResultDTO> uploadGuide(@RequestParam("file") MultipartFile uploadFile){
        UploadResultDTO uploadResult = new UploadResultDTO();
             System.out.println(uploadFile.getContentType());

            //pdf 파일만 업로드 가능 - 설명서
            if(uploadFile.getContentType().startsWith("application/pdf") == false) {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }


            String originalName = uploadFile.getOriginalFilename();
            String fileName = originalName.substring(originalName.lastIndexOf("\\")+1);
            log.info("fileName: " + fileName);

            //날짜 폴더 생성
            String folderPath = makeFolder();

            //UUID
            String uuid = UUID.randomUUID().toString();

            //저장할 파일 이름 중간에 "-"를 이용해서 구분
            String saveName = uploadPath + File.separator + folderPath + File.separator + uuid + "_" + fileName;

            Path savePath = Paths.get(saveName);

            try{
                //지정한 경로에 파일 저장
                uploadFile.transferTo(savePath);
                uploadResult.setFileName(fileName);
                uploadResult.setUuid(uuid);
                uploadResult.setFolderPath(folderPath);
            } catch (IOException e){
                e.printStackTrace();
            }
        return new ResponseEntity<>(uploadResult, HttpStatus.OK);
    }

    //대표이미지, 상세이미지 업로드
    @PostMapping("/upload/file")
    public ResponseEntity<UploadResultDTO> uploadFile(@RequestParam("file") MultipartFile uploadFile){

        UploadResultDTO uploadResult = new UploadResultDTO();

        //이미지만 업로드 가능 - 대표이미지, 상세이미지
        if(uploadFile.getContentType().startsWith("image") == false) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }


        String originalName = uploadFile.getOriginalFilename();
        String fileName = originalName.substring(originalName.lastIndexOf("\\")+1);
        log.info("fileName: " + fileName);

        //날짜 폴더 생성
        String folderPath = makeFolder();

        //UUID - 중복 방지를 위해 uuid 생성
        String uuid = UUID.randomUUID().toString();

        //저장할 파일 이름 중간에 "-"를 이용해서 구분
        String saveName = uploadPath + File.separator + folderPath + File.separator + uuid + "_" + fileName;

        Path savePath = Paths.get(saveName);
        try{
            uploadFile.transferTo(savePath);

            //섬네일 생성
            String thumbnailSaveName = uploadPath + File.separator + folderPath + File.separator + "s_" + uuid +"_" + fileName;

            //섬네일 파일 이름은 중간에 s_로 시작하도록
            File thumbnailFile = new File(thumbnailSaveName);

            //섬네일 생성
            Thumbnailator.createThumbnail(savePath.toFile(), thumbnailFile, 100, 100);
            uploadResult.setFileName(fileName);
            uploadResult.setUuid(uuid);
            uploadResult.setFolderPath(folderPath);
        } catch (IOException e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(uploadResult, HttpStatus.OK);
    }


    private String makeFolder() {

        String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        String folderPath = str.replace("/", File.separator);

        File uploadPathFolder = new File(uploadPath,folderPath);

        if(uploadPathFolder.exists() == false){
            uploadPathFolder.mkdirs();
        }
        return folderPath;
    }


    //섬네일 데이터 전송
    @GetMapping("/upload/display")
    public ResponseEntity<byte[]> getFile(@RequestParam String fileName){

        ResponseEntity<byte[]> result = null;

        try{
            //디코딩하여 일반 문자열로 변환
            String srcFileName = URLDecoder.decode(fileName, "UTF-8");

            log.info("fileName" + srcFileName);

            File file = new File(uploadPath + File.separator + srcFileName);

            log.info("file" + file);

            HttpHeaders header = new HttpHeaders();

            header.add("Content-Type", Files.probeContentType(file.toPath()));

            //파일 데이터 처리
            result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
        }catch (Exception e){
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        System.out.println(result);
        return result;
    }

    //업로드 파일 삭제
    @PostMapping("/upload/removeFile")
    public ResponseEntity<Boolean> removeFile(@RequestParam String fileName){

        String srcFileName = null;

        try{
            srcFileName = URLDecoder.decode(fileName, "UTF-8");

            File file = new File(uploadPath + File.separator + srcFileName);
            System.out.println(srcFileName);
            System.out.println(file);
            System.out.println(file.getParentFile());
            boolean result = file.delete();

            File thumbnail = new File(file.getParentFile(), "s_" + file.getName());

            result = thumbnail.delete();

            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //다운로드
    @GetMapping(value = "/upload/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> downloadFile(@RequestHeader("User-Agent") String userAgent, @RequestParam String fileName) {


        FileSystemResource resource = new FileSystemResource("c:\\upload\\" + fileName);

        if (!resource.exists()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        String resourceName = resource.getFilename();

        // remove UUID
        String resourceOriginalName = resourceName.substring(resourceName.indexOf("_") + 1);

        HttpHeaders headers = new HttpHeaders();
        try {

            boolean checkIE = (userAgent.indexOf("MSIE") > -1 || userAgent.indexOf("Trident") > -1);

            String downloadName = null;

            if (checkIE) {
                downloadName = URLEncoder.encode(resourceOriginalName, "UTF8").replaceAll("\\+", " ");
            } else {
                downloadName = new String(resourceOriginalName.getBytes("UTF-8"), "ISO-8859-1");
            }

            headers.add("Content-Disposition", "attachment; filename=" + downloadName);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try(FileInputStream inputStream = new FileInputStream(resource.getFile());
            BufferedInputStream bis = new BufferedInputStream(inputStream)){

            byte[] fileBytes = new byte[(int) resource.contentLength()];
            bis.read(fileBytes, 0, fileBytes.length);

            headers.setContentLength(fileBytes.length);
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);


            return new ResponseEntity<>(fileBytes, headers, HttpStatus.OK);

        } catch (IOException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
