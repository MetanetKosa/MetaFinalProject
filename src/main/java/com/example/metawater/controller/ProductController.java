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
public class ProductController {

    @Value("${metawater.upload.path}")
    private String uploadDir;

    @Autowired
    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    //상품 상세 조회
    @GetMapping("/product/{productNo}")
    public ResponseEntity productInsert(@PathVariable Long productNo){
        ProductVO productVO = service.getProduct(productNo);

        return new ResponseEntity<>(productVO,HttpStatus.CREATED);
    }

    // 상품 목록 조회
    @GetMapping("/products")
    public List<ProductVO> list(){
        return service.getProductList();
    }






}
