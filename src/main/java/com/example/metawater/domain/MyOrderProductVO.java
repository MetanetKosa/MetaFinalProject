package com.example.metawater.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyOrderProductVO {
    private String productName;
    private String productModel;
    private String productSize;
    private String productGuide;
    private String productRentalPrice;
    private String imgUrl;
    private Long orderNo;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderHopeDate;
    private String OrderAdd;
    private String orderPhone;
    private String orderType;
    private String ren_term;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ren_enddate;
    public OrderVO order;
    public RentalVO rental;
    public ProductVO product;
}
