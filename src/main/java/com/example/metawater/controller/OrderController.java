package com.example.metawater.controller;

import com.example.metawater.domain.RentalVO;
import com.example.metawater.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    public OrderService orderService;

//렌탈주문
    @PostMapping("/rental/rentalInsert")
    private void rentalInsert(@RequestBody RentalVO rentalVO){
        System.out.println(rentalVO.getRenInstallCost());
        System.out.println(rentalVO.getRenTerm());
        System.out.println(rentalVO.getRenPayDate());
        System.out.println(rentalVO.getProductNo());
        orderService.rentalInsert(rentalVO);
        System.out.println("insert result confirm !!!!");
    }
}
