package com.example.metawater.controller.admin;

import com.example.metawater.domain.ProductVO;
import com.example.metawater.domain.UploadResultDTO;
import com.example.metawater.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Value("${metawater.upload.path}")
    private String uploadPath;

    @Autowired
    private ProductService service;

    public AdminController(ProductService service) {
        this.service = service;
    }

    //상품 등록
    @PostMapping("/product")
    public ResponseEntity productInsert(@RequestBody ProductVO product){
        service.insertProduct(product);

        if(product.getAttachList() != null) {
            product.getAttachList().forEach(attach -> System.out.println(attach));
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    //상품 상세 조회
    @GetMapping("/product/{productNo}")
    public ResponseEntity productInsert(@PathVariable Long productNo){
        ProductVO productVO = service.getProduct(productNo);

        return new ResponseEntity<>(productVO,HttpStatus.CREATED);
    }

    //상품별 첨부파일 조회
    @GetMapping(value ="/product/getAttachList/{productNo}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<UploadResultDTO>> getAttachList( @PathVariable Long productNo) {
        return new ResponseEntity<>(service.getAttachList(productNo), HttpStatus.OK);
    }

    // 상품 목록 조회
    @GetMapping("/products")
    public List<ProductVO> list(){
        return service.getProductList();
    }

    //상품 삭제
    @DeleteMapping("/product/{productNo}")
    public void delete(@PathVariable Long productNo){
        List<UploadResultDTO> attachList = service.getAttachList(productNo);
        ProductVO product = service.getProduct(productNo);
        String imgUrl = product.getImgUrl();
        String detailUrl = product.getDetailUrl();
        String productGuide = product.getProductGuide();

        if( service.deleteProduct(productNo)) {
            deleteFiles(attachList);
            deleteFile(imgUrl);
            deleteFile(detailUrl);
            deleteFile(productGuide);
        }
    }

    private void deleteFile(String imgUrl) {


        try{

            File file = new File(uploadPath + File.separator + imgUrl);
            System.out.println(file);
            System.out.println(file.getParentFile());
            boolean result = file.delete();

            File thumbnail = new File(file.getParentFile(), "s_" + file.getName());

            result = thumbnail.delete();

        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //상품 수정
    @PatchMapping("/product/{productNo}")
    public void update(@PathVariable Long productNo, @RequestBody ProductVO product){
        product.setProductNo(productNo);
        service.updateProduct(product);
    }


    //파일 삭제
    private void deleteFiles(List<UploadResultDTO> attachList) {

        if(attachList == null || attachList.size() == 0) {
            return;
        }

        attachList.forEach(attach -> {
            try {
                Path file  = Paths.get(uploadPath+attach.getFolderPath()+"\\" + attach.getUuid()+"_"+ attach.getFileName());

                Files.deleteIfExists(file);

                if(Files.probeContentType(file).startsWith("image")) {

                    Path thumbNail = Paths.get(uploadPath+attach.getFolderPath()+"\\s_" + attach.getUuid()+"_"+ attach.getFileName());

                    Files.delete(thumbNail);
                }

            }catch(Exception e) {
                System.out.println(e.getMessage());
            }
        });
    }



}
