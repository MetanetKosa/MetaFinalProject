package com.example.metawater.controller;

import com.example.metawater.domain.ProductInqVO;
import com.example.metawater.service.ProductInqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductInqController {

    @Autowired
    private ProductInqService pqService;

    public ProductInqController(ProductInqService pqService) {this.pqService = pqService;}

    //문의 목록 조회
    @GetMapping("/{productNo}/proQna")
    public List<ProductInqVO> list(@PathVariable Long productNo) {
        System.out.println("문의 GET 요청 확인");
        return pqService.findByProduct(productNo);
    }

    //문의 상세 조회
    @GetMapping("/{productNo}/proQna/detail/{proqNo}")
    public ProductInqVO detail(@PathVariable Long productNo, @PathVariable Long proqNo) {
        return pqService.getQuestion(productNo, proqNo);
    }

    //문의 등록
    @PostMapping("/{productNo}/qnaInsert")
    public ResponseEntity insert(@PathVariable Long productNo, @RequestBody ProductInqVO question) {
        question.setProductNo(productNo);
        pqService.insertQuestion(productNo, question);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
