package com.example.metawater.task;


import ch.qos.logback.core.db.ConnectionSource;
import com.example.metawater.domain.UploadResultDTO;
import com.example.metawater.mapper.AttachMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Async;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class FileCheckTask {

    @Value("${metawater.upload.path}") //파일 저장 경로
    private String uploadPath;

   @Autowired
    private AttachMapper attachMapper;



    private String getFolderYesterDay(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        String str = sdf.format(cal.getTime());
        return str.replace("-", File.separator);
    }

    //매일 12시에 동작
    @Scheduled(cron = "10 25 15 * * *")
    public void checkFiles() throws Exception {
        log.info("File Check Task run ......");
        log.warn(LocalDateTime.now().toString());

        //file list in database
      List<UploadResultDTO> fileList = attachMapper.getOldFiles();
//        List<UploadResultDTO> fileList = attachMapper.getFiles();
        System.out.println(fileList);

        //ready for check file in directory with database file list
        List<Path> fileListPaths = fileList.stream()
                .map(vo -> Paths.get(uploadPath, vo.getFolderPath(), vo.getUuid() + "_" + vo.getFileName()))
                .collect(Collectors.toList());

        //image file has thumbnail file
        fileList.stream().map(vo -> Paths.get(uploadPath, vo.getFolderPath(), "s_" + vo.getUuid() + "_" +"_"
        +vo.getFileName()))
                .forEach(p -> fileListPaths.add(p));

        log.info("----------------------------------------");

//        fileListPaths.forEach(p -> log.warn(p));

        //files in yesterday directory
        File targetDir = Paths.get(uploadPath, getFolderYesterDay()).toFile();

        File[] removeFiles = targetDir.listFiles(file -> fileListPaths.contains(file.toPath()) == false);

        log.warn("----------------------------------------");
        for(File file : removeFiles) {
            log.warn(file.getAbsolutePath());
            file.delete();
        }
    }

}
