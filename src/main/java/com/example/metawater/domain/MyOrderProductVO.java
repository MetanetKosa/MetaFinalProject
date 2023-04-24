package com.example.metawater.domain;

import com.example.metawater.dto.OrderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyOrderProductVO {
    // 마이페이지 상세정보 VO
    private String productName;
    private String productModel;
    private String productSize;
    private String productGuide;
    private String productRentalPrice;
    private String imgUrl;
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
    private OrderDTO order;
    private ProductVO product;
}
