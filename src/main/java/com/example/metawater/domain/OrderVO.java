package com.example.metawater.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVO {
    private Long orderNo;
    private Long productNo;
    private Long memberNo;
    private String orderState;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deliveryDate;
    private String deliveryTime;
    private String orderAddNumber;
    private String orderAddress;
    private String orderAddDetail;
    private String orderName;
    private String orderPhone;
    private Long orderPrice;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderDate;
    private String orderPay;
    private Long rentalPrice;
    private Long rentalTerm;
    private String rentalPayDate;
    private MemberVO member;
    private ProductVO product;
}
