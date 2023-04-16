package com.example.metawater.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVO {
    private String orderNo;
    private String productNo;
    private String memNo;
    private String renNo;
    private String orderState;
    private String orderHopedate;
    private String orderAdd;
    private String orderName;
    private String orderPhone;
    private String orderDate;
    private String orderPay;
    private String orderType;
}
