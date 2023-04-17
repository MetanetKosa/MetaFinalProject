package com.example.metawater.service;

import com.example.metawater.domain.ProductVO;
import com.example.metawater.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService
{
   @Autowired
   private ProductMapper mapper;

    @Override
    public void insertProduct(ProductVO product) {
        mapper.productInsert(product);
    }

    @Override
    public boolean updateProduct(ProductVO product) {
        return mapper.productUpdate(product) == 1;
    }

    @Override
    public boolean deleteProduct(Long product_no) {
        return mapper.productDelete(product_no) == 1;
    }

    @Override
    public List<ProductVO> getProductList() {
        return mapper.getProductList();
    }

    @Override
    public List<ProductVO> getBestProductList() {
        return mapper.getBestProductList();
    }

    @Override
    public List<ProductVO> getProductListBySearch(String searchKeyword) {
        return mapper.getProductListBySearch(searchKeyword);
    }

    @Override
    public ProductVO getProduct(Long product_no) {
        return mapper.getProduct(product_no);
    }
}
