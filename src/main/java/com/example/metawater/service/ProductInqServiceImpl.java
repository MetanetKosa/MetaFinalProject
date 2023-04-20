package com.example.metawater.service;

import com.example.metawater.domain.ProductInqVO;
import com.example.metawater.mapper.ProductInqMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInqServiceImpl implements ProductInqService {

    @Autowired
    private ProductInqMapper qMapper;
    @Override
    public List<ProductInqVO> findAll() {
        return qMapper.getQuestionList();
    }

    @Override
    public List<ProductInqVO> findByProduct(Long productNo) {
        return qMapper.getQuestionListByProductId(productNo);
    }

    @Override
    public ProductInqVO getQuestion(Long productNo, Long proqNo) {
        return qMapper.getQuestion(productNo, proqNo);
    }

    @Override
//    public void insertQuestion(Long productNo, ProductInqVO question) {
//        qMapper.questionInsert(productNo, question);
//    }
    public void insertQuestion(ProductInqVO question) {
        qMapper.questionInsert(question);
    }
}
