package com.example.metawater.service;

import com.example.metawater.domain.RentalVO;
import com.example.metawater.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService{

    @Autowired
    private OrderMapper orderMapper;

    public void rentalInsert(RentalVO rentalVO){
        System.out.println("rental서비스 클래스 실행");
        orderMapper.rentalInsert(rentalVO);
    }

}
