package com.example.metawater.controller;

import com.example.metawater.domain.OrderVO;
import com.example.metawater.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    public OrderService orderService;

    //구매
    @PostMapping("/{productNo}/{memberNo}")
    private ResponseEntity order(@PathVariable("productNo") Long productNo, @PathVariable("memberNo") Long memberNo, @RequestBody OrderVO order){
        //System.out.println("POST 구매");
        OrderVO o = new OrderVO();

        o.setProductNo(productNo);
        o.setMemberNo(memberNo);
        o.setOrderAddNumber(order.getOrderAddNumber());
        o.setOrderAddress(order.getOrderAddress());
        o.setOrderAddDetail(order.getOrderAddDetail());
        o.setOrderName(order.getOrderName());
        o.setOrderPhone(order.getOrderPhone());
        o.setOrderPay(order.getOrderPay());
        o.setDeliveryDate(order.getDeliveryDate());
        o.setDeliveryTime(order.getDeliveryTime());
        o.setOrderPrice(order.getOrderPrice());

//        order.setProductNo(productNo);
//        order.setMemberNo(memberNo);
//        orderService.insertRental(order);
        orderService.insertOrder(o);
        orderService.updateSales(productNo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //렌탈
    @PostMapping("/rental/{productNo}/{memberNo}")
    private ResponseEntity rental(@PathVariable("productNo") Long productNo, @PathVariable("memberNo") Long memberNo, @RequestBody OrderVO order){
        //System.out.println("POST 렌탈");
        OrderVO r = new OrderVO();

        r.setProductNo(productNo);
        r.setMemberNo(memberNo);
        r.setOrderAddNumber(order.getOrderAddNumber());
        r.setOrderAddress(order.getOrderAddress());
        r.setOrderAddDetail(order.getOrderAddDetail());
        r.setOrderName(order.getOrderName());
        r.setOrderPhone(order.getOrderPhone());
        r.setOrderPay(order.getOrderPay());
        r.setDeliveryDate(order.getDeliveryDate());
        r.setDeliveryTime(order.getDeliveryTime());
        r.setRentalPrice(order.getRentalPrice());
        r.setRentalTerm(order.getRentalTerm());
        r.setRentalPayDate(order.getRentalPayDate());

//        order.setProductNo(productNo);
//        order.setMemberNo(memberNo);
//        orderService.insertRental(order);
        orderService.insertRental(r);
        orderService.updateSales(productNo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //주문번호
    @GetMapping("/getOrderNo")
    private ResponseEntity<Long> orderNo() {
        //System.out.println("GET 주문번호 조회");
        return new ResponseEntity<>(orderService.getOrderNo(), HttpStatus.OK);
    }

    //주문 상세조회
    @GetMapping("/check/{orderNo}")
    public OrderVO orderDetail(@PathVariable Long orderNo) {
        //System.out.println("GET 주문상세 요청");
        return orderService.getOrderDetail(orderNo);
    }

//렌탈주문
//    @PostMapping("/rental/rentalInsert")
//    private void rentalInsert(@RequestBody RentalVO rentalVO){
//        System.out.println(rentalVO.getRenInstallCost());
//        System.out.println(rentalVO.getRenTerm());
//        System.out.println(rentalVO.getRenPayDate());
//        System.out.println(rentalVO.getProductNo());
//        orderService.rentalInsert(rentalVO);
//        System.out.println("insert result confirm !!!!");
//    }
}
