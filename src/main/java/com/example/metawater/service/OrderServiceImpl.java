package com.example.metawater.service;

import com.example.metawater.domain.OrderVO;
import com.example.metawater.mapper.OrderMapper;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void insertOrder(OrderVO order) {
        orderMapper.insertOrder(order);
    }

    @Override
    public void insertRental(OrderVO order) {
        orderMapper.insertRental(order);
    }

    @Override
    public Long getOrderNo() { return orderMapper.selectOrderNo(); }

    @Override
    public OrderVO getOrderDetail(Long orderNo) { return orderMapper.getOrderDetail(orderNo); }
}
