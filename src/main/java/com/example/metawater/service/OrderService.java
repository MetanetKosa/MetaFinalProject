package com.example.metawater.service;

import com.example.metawater.domain.OrderVO;
import com.example.metawater.domain.RentalVO;
import com.example.metawater.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface OrderService{

    public void insertOrder(OrderVO order);

    public void insertRental(OrderVO order);

    public Long getOrderNo();

    public OrderVO getOrderDetail(Long orderNo);

}
