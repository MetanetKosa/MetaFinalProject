package com.example.metawater.mapper;

import com.example.metawater.domain.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MypageMapper {

    // 내가 사용중인 제품 조회
    public List<ProductVO> getMyProductList(Long memNo);

    // 나의 주문목록 조회
    public List<ProductVO> getMyOrderList();
}