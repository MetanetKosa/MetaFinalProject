package com.example.metawater.controller;

import com.example.metawater.domain.ProductInqVO;
import com.example.metawater.dto.ProductInqDTO;
import com.example.metawater.service.ProductInqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductInqController {

    @Autowired
    public ProductInqService pqService;

    public ProductInqController(ProductInqService pqService) {
        this.pqService = pqService;}

    //문의 목록 조회
    @GetMapping("/{productNo}/proQna")
//    public List<ProductInqVO> list(@PathVariable Long productNo) {
//        System.out.println("문의 GET 요청 확인");
//        return pqService.findByProduct(productNo);
//    }

//    public ResponseEntity<List<ProductInqVO>> list(@PathVariable Long productNo) {

//        public List<ProductInqVO> list(@PathVariable Long productNo) {
//        System.out.println("문의 GET 요청 확인");
//        System.out.println("productNon데이터 확인" + productNo);
//
//        System.out.println("-----문의 GET 요청을 이렇게 보내도 되나요?-----" + pqService.findByProduct(productNo));
//        List<ProductInqVO> productList = pqService.findByProduct(productNo);
//        return productList;
//        return new ResponseEntity<>(pqService.findByProduct(productNo), HttpStatus.OK);

    public ResponseEntity<List<ProductInqVO>> list(@PathVariable Long productNo) {
        //System.out.println("문의 GET 요청 확인");
        return new ResponseEntity<>(pqService.findByProduct(productNo), HttpStatus.OK);
    }

    //문의 상세 조회
    @GetMapping("/{productNo}/proQna/detail/{proqNo}")
    public ResponseEntity<ProductInqVO> detail(@PathVariable Long productNo, @PathVariable Long proqNo) {
        pqService.getQuestion(productNo, proqNo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //문의 등록
//    @PostMapping("/{productNo}/qnaInsert")
//    public ResponseEntity insert(@PathVariable("productNo") Long productNo, @RequestBody ProductInqVO question) {
//        System.out.println("Post 요청 확인");
//        System.out.println(question.getProqTitle());
//        System.out.println(question.getProqContent());
//
//        question.setProductNo(productNo);
//        pqService.insertQuestion(question);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }

    //문의 등록
    @PostMapping("/{productNo}/{memNo}/qnaInsert")
    public ResponseEntity insert(@PathVariable("productNo") Long productNo, @PathVariable("memNo") Long memNo, @RequestBody ProductInqDTO question) {
        //System.out.println("POST 문의 확인");

        ProductInqVO q = new ProductInqVO();
        q.setProductNo(productNo);
        q.setMemNo(memNo);
        q.setProqTitle(question.getProqTitle());
        q.setProqContent(question.getProqContent());
        pqService.insertQuestion(q);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
