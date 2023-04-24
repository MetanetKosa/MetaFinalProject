package com.example.metawater.service;

import com.example.metawater.domain.OrderVO;
import com.example.metawater.mapper.OrderMapper;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void insertOrder(OrderVO order) {

        orderMapper.insertOrder(order);
        //orderMapper.updateProductSales();
    }

    public List<OrderVO> orderList() {
        return orderMapper.orderList();
    }

    @Override
    public List<OrderVO> orderRentalList() {
        return orderMapper.orderRentalList();
    }

    //주문 상태 변경
    @Override
    public boolean orderStateUpdate(OrderVO orderVO) {
        return orderMapper.updateOrderState(orderVO) == 1;
    }

    @Override
    public void insertRental(OrderVO order) {

        orderMapper.insertRental(order);
        //orderMapper.updateProductSales();
    }

    @Override
    public void updateSales(Long productNo) {
        orderMapper.updateProductSales(productNo);
    }

    @Override
    public Long getOrderNo() { return orderMapper.selectOrderNo(); }

    @Override
    public OrderVO getOrderDetail(Long orderNo) { return orderMapper.getOrderDetail(orderNo); }

    @Override
    public OrderVO orderDetail(Long orderNo) {
        return orderMapper.orderDetail(orderNo);
    }
}
