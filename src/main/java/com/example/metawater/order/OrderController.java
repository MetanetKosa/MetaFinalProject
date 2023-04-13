package com.example.metawater.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
        System.out.println(rentalVO.getRen_installcost());
        System.out.println(rentalVO.getRen_term());
        System.out.println(rentalVO.getRen_paydate());
        System.out.println(rentalVO.getProduct_no());
        orderService.rentalInsert(rentalVO);
        System.out.println("insert result confirm !!!!");
    }
}
