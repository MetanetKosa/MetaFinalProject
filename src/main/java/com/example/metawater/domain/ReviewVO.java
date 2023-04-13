package com.example.metawater.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewVO {
    private Long re_no;
    private Long order_no;
    private Long product_no;
    private Long mem_no;
    private String re_star;
    private String re_image;
    private String re_content;
    private Date re_date;
}
