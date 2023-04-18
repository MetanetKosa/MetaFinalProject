package com.example.metawater.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class MyOrderProductVO {
    private Long memNo;
    private String productName;
    private String productModel;
    private String productSize;
    private String productGuide;
    private String productRentalPrice;
    private String umgUrl;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderHopeDate;
    private String OrderAdd;
    private String orderPhone;
    private String orderType;
    private String renTerm;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date renEndDate;

}
