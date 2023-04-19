package com.example.metawater.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ProductInqVO {
    private Long proqNo;
    private Long memNo;
    private Long productNo;
    private String proqTitle;
    private String proqContent;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date proqDate;

    private String proqEmail;
    private String proqState;
    //답변
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date answerDate;
    private String answerContent;
    //이메일 수신 여부
    private boolean answerTrue;


    public ProductVO product;
    public MemberVO member;
}
