package com.example.metawater.service;

import com.example.metawater.domain.ProductInqVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductInqService {

    public List<ProductInqVO> findAll();

    public List<ProductInqVO> findByProduct(Long productNo);

    public ProductInqVO getQuestion(Long productNo, Long proqNo);

    //public void insertQuestion(Long productNo, ProductInqVO question);
    public void insertQuestion(ProductInqVO question);

    //public boolean updateQuestion(ProductQVO question);

    //public boolean deleteQuestion(ProductQVO proqNo);
}
