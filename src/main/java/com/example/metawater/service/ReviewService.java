package com.example.metawater.service;

import com.example.metawater.domain.ProductVO;
import com.example.metawater.domain.ReviewVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {

    public List<ReviewVO> findAll();

    public List<ReviewVO> findByProduct(Long productNo);

    public ReviewVO getReview(Long productNo, Long reviewNo);

    public void insertReview(ReviewVO review);

    public boolean updateReview(ReviewVO review);

    public boolean deleteReview(Long reviewNo);
}
