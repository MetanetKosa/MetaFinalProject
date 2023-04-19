package com.example.metawater.service;

import com.example.metawater.domain.OrderVO;
import com.example.metawater.domain.ReviewVO;
import com.example.metawater.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private ReviewMapper reviewMapper;

    @Override
    public List<ReviewVO> findAll() {
        return reviewMapper.getReviewList();
    }

    @Override
    public List<ReviewVO> findByProduct(Long productNo) {
        return reviewMapper.getReviewListByProductId(productNo);
    }

    @Override
    public ReviewVO getReview(Long productNo, Long reviewNo) {
        return reviewMapper.getReview(productNo, reviewNo);
    }

    @Override
    public Float avgStar(Long productNo) {
        return reviewMapper.avgStarByProductId(productNo);
    }

    @Override
    public List<OrderVO> findAvailableOrder(Long memNo, Long productNo) {
        return reviewMapper.availableReviews(memNo, productNo);
    }

    @Override
    public void insertReview(ReviewVO review) {
        reviewMapper.reviewInsert(review);
    }

    @Override
    public boolean updateReview(ReviewVO review) {
        return reviewMapper.reviewUpdate(review) == 1;
    }

    @Override
    public boolean deleteReview(Long reviewNo) {
        return reviewMapper.reviewDelete(reviewNo) == 1;
    }
}
