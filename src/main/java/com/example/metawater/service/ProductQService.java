package com.example.metawater.service;

import com.example.metawater.domain.ProductQVO;
import com.example.metawater.domain.ReviewVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductQService {

    public List<ProductQVO> findAll();

    public List<ProductQVO> findByProduct(Long productNo);

    public ProductQVO getQuestion(Long productNo, Long proqNo);

    public void insertQuestion(ProductQVO question);

    //public boolean updateQuestion(ProductQVO question);

    //public boolean deleteQuestion(ProductQVO proqNo);
}
