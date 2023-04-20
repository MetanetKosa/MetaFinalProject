package com.example.metawater.controller;

import com.example.metawater.domain.ProductVO;
import com.example.metawater.domain.UploadResultDTO;
import com.example.metawater.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Value("${metawater.upload.path}")
    private String uploadDir;

    @Autowired
    public ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    //상품 등록
    @PostMapping("/product/productInsert")
    public ResponseEntity insert(@RequestBody ProductVO product){
        service.insertProduct(product);

        if(product.getAttachList() != null) {
            product.getAttachList().forEach(attach -> System.out.println(attach));
        }
        else{
            System.out.println("널입니다.");
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //상품 목록 조회
    @GetMapping("/products")
    public List<ProductVO> list(){
        return service.getProductList();
    }

    //best5
    @GetMapping("/best")
    public List<ProductVO> bestList() { return service.getBestProductList();}

    //상품 검색
    @GetMapping("/search/{searchKeyword}")
    public List<ProductVO> search(@PathVariable String searchKeyword) {
        System.out.println("검색 GET 요청 확인");
        System.out.println(service.getProductListBySearch(searchKeyword));
        return service.getProductListBySearch(searchKeyword);
    }

    @GetMapping("/{productNo}")
    public ProductVO get(@PathVariable Long productNo){
        System.out.println("GET 요청 확인");
        return service.getProduct(productNo);
    }

    //상품 삭제
    @DeleteMapping("/product/products/{productNo}")
    public void delete(@PathVariable Long productNo){

        List<UploadResultDTO> attachList = service.getAttachList(productNo);

        if( service.deleteProduct(productNo)) {
            deleteFiles(attachList);
        }
    }

    //상품 수정
    @PatchMapping("/product/products/{productNo}")
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
