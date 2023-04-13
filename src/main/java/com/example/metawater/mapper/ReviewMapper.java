package com.example.metawater.mapper;

import com.example.metawater.domain.ProductVO;
import com.example.metawater.domain.ReviewVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {
    public List<ReviewVO> getReviewList();

    public ReviewVO getReview(Long re_no);

    public void reviewInsert(ReviewVO review);

    public int reviewUpdate(ReviewVO review);

    public int reviewDelete(Long re_no);
}
