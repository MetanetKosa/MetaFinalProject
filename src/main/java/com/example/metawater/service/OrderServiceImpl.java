package com.example.metawater.service;

import com.example.metawater.domain.OrderVO;
import com.example.metawater.domain.RentalVO;
import com.example.metawater.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    public void rentalInsert(RentalVO rentalVO){
        System.out.println("rental서비스 클래스 실행");
        orderMapper.rentalInsert(rentalVO);
    }

    //주문 목록 조회
    @Override
    public List<OrderVO> orderList() {
        return orderMapper.orderList();
    }





}
