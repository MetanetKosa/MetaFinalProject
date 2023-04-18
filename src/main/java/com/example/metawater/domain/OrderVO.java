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
    private String orderNo;
    private String productNo;
    private String memNo;
    private String renNo;
    private String orderState;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderHopedate;
    private String orderAdd;
    private String orderName;
    private String orderPhone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderDate;
    private String orderPay;
    private String orderType;
}
