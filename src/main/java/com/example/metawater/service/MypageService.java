package com.example.metawater.service;

import com.example.metawater.domain.ProductVO;
import com.example.metawater.mapper.MypageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MypageService {
    @Autowired
    private MypageMapper mypageMapper;

    public List<ProductVO> getMyProductList(Long memNo) {
            return mypageMapper.getMyProductList(memNo);
        }

    public List<ProductVO> getMyOrderList(Long memNo) {
        return mypageMapper.getMyOrderList(memNo);
        }

    }
