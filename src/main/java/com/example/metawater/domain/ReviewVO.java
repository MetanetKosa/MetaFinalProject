package com.example.metawater.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewVO {
    private Long reviewNo;
    private Long orderNo;
    private Long productNo;
    private Long memberNo;
    private String reStar;
    private String reImageUrl;
    private String reContent;
    private Date reDate;

    private MemberVO member;
    private ProductVO product;
}
