
package com.example.metawater.controller.admin;

import com.example.metawater.domain.OrderVO;
import com.example.metawater.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminOrderController {

    @Autowired
    private OrderService service;

    //구매 목록 조회
    @GetMapping("/orders")
    public ResponseEntity getOrders(){
        List<OrderVO> orderList = new ArrayList<>();
        orderList = service.orderList();

        return new ResponseEntity(orderList, HttpStatus.OK);
    }

    //렌탈 목록 조회
    @GetMapping("/orders/rental")
    public ResponseEntity getRentalOrders(){
        List<OrderVO> orderRentalList = new ArrayList<>();
        orderRentalList=service.orderRentalList();

        return new ResponseEntity(orderRentalList, HttpStatus.OK);
    }



    //주문 상태 수정
    @PatchMapping("/orders/{orderNo}")
    public ResponseEntity updateOrderState(@PathVariable Long orderNo, @RequestBody OrderVO order){
        order.setOrderNo(orderNo);
        service.orderStateUpdate(order);

      return new ResponseEntity(HttpStatus.OK);
    }

    //주문 상세 조회
    @GetMapping("/orders/{orderNo}")
    public ResponseEntity getOrder(@PathVariable Long orderNo){
        OrderVO order = service.orderDetail(orderNo);

        return new ResponseEntity(order, HttpStatus.OK);

    }
}

