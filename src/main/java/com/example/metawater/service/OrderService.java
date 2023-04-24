package com.example.metawater.service;

import com.example.metawater.domain.OrderVO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrderService{

    public void insertOrder(OrderVO order);

    public void insertRental(OrderVO order);

    public void updateSales(Long productNo);

    public Long getOrderNo();
    //구매 목록 조회
    public List<OrderVO> orderList();

    public List<OrderVO> orderRentalList();

    public boolean orderStateUpdate(OrderVO orderVO);


    public OrderVO getOrderDetail(Long orderNo);
        public OrderVO orderDetail(Long orderNo);


}
