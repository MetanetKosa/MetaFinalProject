package com.example.metawater.domain;

import lombok.Data;

import java.util.Date;

@Data
public class ProductQVO {
    private Long proqNo;
    private Long memNo;
    private Long productNo;
    private String proqTitle;
    private String proqContent;
    private Date progDate;
    private String progState;
    //답변
    private Date answerDate;
    private String answerContent;
    //이메일 수신 여부
    private boolean answerTrue;

    public ProductVO product;
    public MemberVO member;
}
