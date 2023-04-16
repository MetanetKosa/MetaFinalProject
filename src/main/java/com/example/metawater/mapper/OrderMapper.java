package com.example.metawater.mapper;

import com.example.metawater.domain.OrderVO;
import com.example.metawater.domain.RentalVO;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    public void rentalInsert(RentalVO rentalVO);

    //주문 목록 조회
    public List<OrderVO> orderList();

    //주문 상태 변경
    public int updateOrderState(OrderVO order);
}
