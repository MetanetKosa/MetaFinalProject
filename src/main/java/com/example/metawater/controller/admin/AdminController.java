package com.example.metawater.controller.admin;

import com.example.metawater.domain.ProductVO;
import com.example.metawater.domain.UploadResultDTO;
import com.example.metawater.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Value("${metawater.upload.path}")
    private String uploadDir;

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

    // 상품 목록 조회
    @GetMapping("products")
    public List<ProductVO> list(){
        return service.getProductList();
    }

    //상품 삭제
    @DeleteMapping("/product/{product_no}")
    public void delete(@PathVariable Long product_no){
        List<UploadResultDTO> attachList = service.getAttachList(product_no);

        if( service.deleteProduct(product_no)) {
            deleteFiles(attachList);
        }
    }

    //상품 수정
    @PatchMapping("/product/{product_no}")
    public void update(@PathVariable Long product_no, @RequestBody ProductVO product){
        product.setProduct_no(product_no);
        service.updateProduct(product);
    }


    //파일 삭제
    private void deleteFiles(List<UploadResultDTO> attachList) {

        if(attachList == null || attachList.size() == 0) {
            return;
        }

        attachList.forEach(attach -> {
            try {
                Path file  = Paths.get(uploadDir+attach.getFolderPath()+"\\" + attach.getUuid()+"_"+ attach.getFileName());

                Files.deleteIfExists(file);

                if(Files.probeContentType(file).startsWith("image")) {

                    Path thumbNail = Paths.get(uploadDir+attach.getFolderPath()+"\\s_" + attach.getUuid()+"_"+ attach.getFileName());

                    Files.delete(thumbNail);
                }

            }catch(Exception e) {
                System.out.println(e.getMessage());
            }
        });
    }



}
