package com.example.metawater.order;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    public void rentalInsert(RentalVO rentalVO);
}
