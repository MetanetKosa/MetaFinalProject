package com.example.metawater.mapper;

import com.example.metawater.domain.ProductQVO;
import com.example.metawater.domain.ReviewVO;

import java.util.List;

public interface ProductQMapper {
    //모든 문의 조회
    public List<ProductQVO> getQuestionList();

    //상품 문의 조회
    public List<ProductQVO> getQuestionListByProductId(Long productNo);

    //문의 상세 조회
    public ProductQVO getQuestion(Long productNo, Long proqNo);

    //문의 등록
    public void questionInsert(ProductQVO question);

    //문의 수정
    public int questionUpdate(ProductQVO question);

    //문의 삭제
    public int questionDelete(Long proqNo);
}
