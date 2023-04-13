package com.example.metawater.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductVO {

    private Long product_no;
    private String product_name;
    private String product_size;
    private String product_weight;
    private String product_detail;
    private String product_guide;
    private String product_type;
    private String product_method;
    private Date product_rdate;
    private String product_company;
    private Date regDate;
    private Date updateDate;
    private String img_url;
    private String detail_url;
    private List<ColorVO> colors;
    private List<FunctionVO> functions;
}
