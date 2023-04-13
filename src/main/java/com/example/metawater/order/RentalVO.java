package com.example.metawater.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalVO {
    private int ren_no;
    private String ren_installcost;
    private Date ren_enddate;
    private String ren_term;
    private String ren_paydate;
    private int product_no;
}
