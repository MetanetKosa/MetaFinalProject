package com.example.metawater.service;

import com.example.metawater.domain.MyOrderProductVO;
import com.example.metawater.domain.ProductVO;
import com.example.metawater.domain.ReturnVO;
import com.example.metawater.mapper.MypageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MypageService {
    @Autowired
    private MypageMapper mypageMapper;

    public List<ProductVO> getMyProductList(Long memNo) {
        return mypageMapper.getMyProductList(memNo);
    }

    public List<ProductVO> getMyOrderList(Long memNo) {
        return mypageMapper.getMyOrderList(memNo);
    }
    public List<ProductVO> getMyCancelList(Long memNo) {
        return mypageMapper.getMyCancelList(memNo);
    }

    public ProductVO getMyProduct(Long productNo){
        return mypageMapper.getMyProduct(productNo);
    }


    // 해지
    public void changeOrderStatus(Long orderNo){
        mypageMapper.changeOrderStatus(orderNo);
    }
    public void insertReturn(ReturnVO returnVO){
        mypageMapper.insertReturn(returnVO);
    }

    // 계약 연장
    public void contractExtend(Long orderNo){
        mypageMapper.contractExtend(orderNo);
    }
    public void deleteOrder(Long orderNo){
        mypageMapper.deleteReturn(orderNo);
        mypageMapper.deleteReview(orderNo);
        mypageMapper.deleteOrder(orderNo);
    }

    public List<MyOrderProductVO> getOrderProductDetailList(Long memNo){
        return mypageMapper.getOrderProductDetailList(memNo);
    }

    public MyOrderProductVO getOrderProductDetail(Long orderNo){
        return mypageMapper.getOrderProductDetail(orderNo);
    }


}