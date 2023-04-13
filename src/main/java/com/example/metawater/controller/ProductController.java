package com.example.metawater.controller;

import com.example.metawater.domain.ProductVO;
import com.example.metawater.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    //상품 등록
    @PostMapping("/product/productInsert")
    public ResponseEntity insert(@RequestBody ProductVO product){
        service.insertProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // 상품 목록 조회
    @GetMapping("/product/products")
    public List<ProductVO> list(){
        return service.getProductList();
    }

    //상품 상세조회
    @GetMapping("/product/products/{product_no}")
    public ProductVO get(@PathVariable Long product_no){
        return service.getProduct(product_no);
    }

    //상품 삭제
    @DeleteMapping("/product/products/{product_no}")
    public void delete(@PathVariable Long product_no){
        service.deleteProduct(product_no);
    }

    //상품 수정
    @PatchMapping("/product/products/{product_no}")
    public void update(@PathVariable Long product_no, @RequestBody ProductVO product){
        product.setProduct_no(product_no);
        service.updateProduct(product);
    }
}
