package com.example.metawater.controller;

import com.example.metawater.domain.*;
import com.example.metawater.mapper.MypageMapper;
import com.example.metawater.service.MypageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping("/return/{orderNo}/")
//    public void returnInsert(@PathVariable Long orderNo){
//
//    }

    @DeleteMapping("/myorder/{orderNo}")
    public void deleteOrder(@PathVariable Long orderNo){
        mypageService.deleteOrder(orderNo);
    }

    @GetMapping("/myorder/myproducts/{memNo}")
    public List<MyOrderProductVO> getOrderProductDetailList(@PathVariable Long memNo){
        return mypageService.getOrderProductDetailList(memNo);
    }

    @GetMapping("/myorder/myproduct/{orderNo}")
    public MyOrderProductVO getOrderProductDetail(@PathVariable Long orderNo){
        return mypageService.getOrderProductDetail(orderNo);
    }

    // 해지
    @PatchMapping("/myorder/myproduct/cancel/{orderNo}")
    public void changeOrderStatus(@PathVariable Long orderNo){
        mypageService.changeOrderStatus(orderNo);
    }

    @PostMapping("/myorder/cancel")
    public void insertReturn(@RequestBody ReturnVO returnVO){
        mypageService.insertReturn(returnVO);
    }
}
