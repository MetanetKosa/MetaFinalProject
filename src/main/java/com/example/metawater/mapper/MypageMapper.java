package com.example.metawater.mapper;

import com.example.metawater.domain.MyOrderProductVO;
import com.example.metawater.domain.ProductVO;
import com.example.metawater.domain.ReturnVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MypageMapper {

    // 내가 사용중인 제품 조회
    public List<ProductVO> getMyProductList(Long memNo);

    // 나의 주문목록 조회
    public List<ProductVO> getMyOrderList(Long memNo);
    public List<ProductVO> getMyCancelList(Long memNo);

    public ProductVO getMyProduct(Long productNo);

    public void deleteOrder(Long orderNo);
    public void deleteReturn(Long orderNo);
    public void deleteReview(Long orderNo);

    // 주문 상태 해지 완료로 변경
    public void changeOrderStatus(Long orderNo);
    // 해지 내역 추가
    public void insertReturn(ReturnVO returnVO);
    // 계약 연장
    public void contractExtend(Long orderNo);

    public List<MyOrderProductVO> getOrderProductDetailList(Long memNo);
    public MyOrderProductVO getOrderProductDetail(Long orderNo);

}