package com.example.metawater.controller;

import com.example.metawater.domain.ProductVO;
import com.example.metawater.mapper.MypageMapper;
import com.example.metawater.service.MypageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mypage")
public class MypageController {

    @Autowired
    private MypageService mypageService;

    @GetMapping("/myproduct/{memNo}")
    public List<ProductVO> getMyProductList(@PathVariable Long memNo){
        return mypageService.getMyProductList(memNo);
    }

    @GetMapping("/myorder/{memNo}")
    public List<ProductVO> getMyOrderList(@PathVariable Long memNo){
        return mypageService.getMyOrderList(memNo);
    }

    @GetMapping("/myproduct/detail/{productNo}")
    public ProductVO getMyProduct(@PathVariable Long productNo){
        return mypageService.getMyProduct(productNo);
    }

    @GetMapping("/return/{orderNo}/")
    public void returnInsert(@PathVariable Long orderNo){

    }
}
