package com.example.metawater.controller;

import com.example.metawater.domain.OrderVO;
import com.example.metawater.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    public OrderService orderService;

    //구매
    @PostMapping("/{productNo}/{memberNo}/order")
    private ResponseEntity order(@PathVariable("productNo") Long productNo, @PathVariable("memberNo") Long memberNo, @RequestBody OrderVO order){
        order.setProductNo(productNo);
        order.setMemberNo(memberNo);
        orderService.insertOrder(order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //렌탈
    @PostMapping("/{productNo}/{memberNo}/rental")
    private ResponseEntity rental(@PathVariable("productNo") Long productNo, @PathVariable("memberNo") Long memberNo, @RequestBody OrderVO order){
        order.setProductNo(productNo);
        order.setMemberNo(memberNo);
        orderService.insertRental(order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
