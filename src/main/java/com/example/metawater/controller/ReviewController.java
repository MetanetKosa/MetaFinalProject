package com.example.metawater.controller;

import com.example.metawater.domain.OrderVO;
import com.example.metawater.domain.ReviewVO;
import com.example.metawater.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {this.reviewService = reviewService;}

    //상품별 리뷰 목록 조회
    @GetMapping("/{productNo}/reviews")
    public List<ReviewVO> list(@PathVariable Long productNo) {
        //System.out.println("리뷰 GET 요청 확인");
        return reviewService.findByProduct(productNo);
    }

    //상품별 리뷰 평점 조회
    @GetMapping("/{productNo}/reviewStar")
    public Float avg(@PathVariable Long productNo) {
        //System.out.println("리뷰 평점 GET 요청 확인");

        Float avgStar = reviewService.avgStar(productNo);
        return avgStar != null ? avgStar : 0.0f;
    }

    //리뷰 상세 조회
    @GetMapping("/{productNo}/review/detail/{reviewNo}")
    public ReviewVO detail(@PathVariable Long productNo, @PathVariable Long reviewNo) {
        return reviewService.getReview(productNo, reviewNo);
    }

    //상품,회원별 리뷰작성 가능한 주문 조회
    @GetMapping("/{productNo}/{memNo}/reviewOrders")
    public List<OrderVO> orderList(@PathVariable Long memNo, @PathVariable Long productNo) {
        return reviewService.findAvailableOrder(memNo, productNo);
    }
}
