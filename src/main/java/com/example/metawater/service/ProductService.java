package com.example.metawater.service;

import com.example.metawater.domain.ProductVO;

import java.util.List;

public interface ProductService {

    public void insertProduct(ProductVO product);
    public boolean updateProduct(ProductVO product);
    public boolean deleteProduct(Long product_no);
    public List<ProductVO> getProductList();
    public List<ProductVO> getBestProductList();
    public ProductVO getProduct(Long product_no);
}
