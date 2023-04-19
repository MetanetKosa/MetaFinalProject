package com.example.metawater.mapper;

import com.example.metawater.domain.OrderVO;
import com.example.metawater.domain.ReviewVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {
    //모든 리뷰 조회
    public List<ReviewVO> getReviewList();

    //상품 리뷰 조회
    public List<ReviewVO> getReviewListByProductId(Long productNo);

    //리뷰 상세 조회
    public ReviewVO getReview(Long productNo, Long reviewNo);

    public float avgStarByProductId(Long productNo);

    //회원별 작성가능한 상품 조회
    public List<OrderVO> availableReviews(Long memNo, Long productNo);

    //리뷰 등록
    public void reviewInsert(ReviewVO review);

    //리뷰 수정
    public int reviewUpdate(ReviewVO review);

    //리뷰 삭제
    public int reviewDelete(Long reviewNo);
}
