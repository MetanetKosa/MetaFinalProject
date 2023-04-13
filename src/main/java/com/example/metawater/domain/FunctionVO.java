package com.example.metawater.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FunctionVO {
    private Long function_no;
    private String function_name;
    private String function_model;
    private String function_rentalPrice;
    private String function_price;
    private Long product_no;
}
