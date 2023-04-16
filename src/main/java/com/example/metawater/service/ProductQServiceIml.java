package com.example.metawater.service;

import com.example.metawater.domain.ProductQVO;
import com.example.metawater.mapper.ProductQMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductQServiceIml implements ProductQService{

    @Autowired
    private ProductQMapper qMapper;
    @Override
    public List<ProductQVO> findAll() {
        return qMapper.getQuestionList();
    }

    @Override
    public List<ProductQVO> findByProduct(Long productNo) {
        return qMapper.getQuestionListByProductId(productNo);
    }

    @Override
    public ProductQVO getQuestion(Long productNo, Long proqNo) {
        return qMapper.getQuestion(productNo, proqNo);
    }

    @Override
    public void insertQuestion(ProductQVO question) {
        qMapper.questionInsert(question);
    }
}
