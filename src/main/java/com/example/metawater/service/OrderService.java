package com.example.metawater.service;

import com.example.metawater.domain.OrderVO;
import com.example.metawater.domain.RentalVO;
import com.example.metawater.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrderService{

    public void rentalInsert(RentalVO rentalVO);

    public List<OrderVO> orderList();
}
