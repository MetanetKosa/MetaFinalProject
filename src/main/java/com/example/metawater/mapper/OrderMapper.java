package com.example.metawater.mapper;

import com.example.metawater.domain.RentalVO;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    public void rentalInsert(RentalVO rentalVO);
}
