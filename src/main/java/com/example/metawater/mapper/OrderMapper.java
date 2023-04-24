package com.example.metawater.mapper;

import com.example.metawater.domain.OrderVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    public void insertOrder(OrderVO order);
    public void insertRental(OrderVO order);
    public Long selectOrderNo();
    public OrderVO getOrderDetail(Long orderNo);
    public void updateProductSales(Long productNo);


    //구매 목록 조회
    public List<OrderVO> orderList();

    //렌탈 목록 조회
    public List<OrderVO> orderRentalList();

    //주문 상태 변경
    public int updateOrderState(OrderVO order);

    //주문 상세 조회
    public OrderVO orderDetail(Long orderNo);

}
