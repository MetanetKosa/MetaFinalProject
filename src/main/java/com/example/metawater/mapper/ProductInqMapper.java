package com.example.metawater.mapper;

import com.example.metawater.domain.ProductInqVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductInqMapper {
    //모든 문의 조회
    public List<ProductInqVO> getQuestionList();

    //상품 문의 조회
    public List<ProductInqVO> getQuestionListByProductId(Long productNo);

    //문의 상세 조회
    public ProductInqVO getQuestion(Long productNo, Long proqNo);

    //문의 등록
    //public void questionInsert(@Param("productNo")Long productNo, @Param("question")ProductInqVO question);
    public void questionInsert(ProductInqVO question);

    //문의 수정
    public int questionUpdate(ProductInqVO question);

    //문의 삭제
    public int questionDelete(Long proqNo);
}
