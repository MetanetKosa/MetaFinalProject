package com.example.metawater.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnVO {
    private Long returnNo;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date returnDate;
    private String returnAddNumber;
    private String returnAddress;
    private String returnAddDetail;
    private String returnPrice;
    private String returnMethod;
    private String returnTrue;
    private Long orderNo;
    private Long memNo;
    private Long productNo;
}
