package com.example.metawater.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalVO {
    private int renNo;
    private String renInstallCost;
    private Date renEndDate;
    private String renTerm;
    private String renPayDate;
    private int productNo;
}
