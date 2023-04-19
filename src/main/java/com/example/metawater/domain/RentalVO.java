package com.example.metawater.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalVO {
    private int rentalNo;
    private String installPrice;
    private Date rentalEndDate;
    private String rentalTerm;
    private String rentalPayDate;
    private int product_no;
}
