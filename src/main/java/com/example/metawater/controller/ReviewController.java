package com.example.metawater.controller;

import com.example.metawater.domain.ReviewVO;
import com.example.metawater.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {this.reviewService = reviewService;}

    @GetMapping("/product/{productNo}/reviews")
    public List<ReviewVO> list(@PathVariable Long productNo) {
        System.out.println("리뷰 GET 요청 확인");
        return reviewService.findByProduct(productNo);
    }

    @GetMapping("/product/{productNo}/reviewStar")
    public Float avg(@PathVariable Long productNo) {
        System.out.println("리뷰 평점 GET 요청 확인");
        return reviewService.avgStar(productNo);
    }

    @GetMapping("/product/{productNo}/review/detail/{reviewNo}")
    public ReviewVO detail(@PathVariable Long productNo, @PathVariable Long reviewNo) {
        return reviewService.getReview(productNo, reviewNo);
    }
}
