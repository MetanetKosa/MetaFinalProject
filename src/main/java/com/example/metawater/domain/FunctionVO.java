package com.example.metawater.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FunctionVO {
    private Long functionNo;
    private String functionName;
    private String functionModel;
    private String functionRentalPrice;
    private String functionPrice;
    private Long productNo;
}
