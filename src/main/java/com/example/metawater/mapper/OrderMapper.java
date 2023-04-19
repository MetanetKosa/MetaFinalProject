package com.example.metawater.mapper;

import com.example.metawater.domain.OrderVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    public void insertOrder(OrderVO order);
    public void insertRental(OrderVO order);
    public Long selectOrderNo();
    public OrderVO getOrderDetail(Long orderNo);
}
