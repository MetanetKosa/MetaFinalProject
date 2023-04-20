package com.example.metawater.mapper;

import com.example.metawater.domain.MyOrderProductVO;
import com.example.metawater.domain.OrderDTO;
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

    public ProductVO getMyProduct(Long productNo);

    public void returnInsert(ReturnVO returnVO);
    public void deleteOrder(Long orderNo);
    public void deleteReturn(Long orderNo);
    public void deleteReview(Long orderNo);

    public List<MyOrderProductVO> getOrderProductDetailList(Long memNo);
    public MyOrderProductVO getOrderProductDetail(Long orderNo);

}
