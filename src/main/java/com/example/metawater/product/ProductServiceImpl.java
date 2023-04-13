package com.example.metawater.product;

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
    public ProductVO getProduct(Long product_no) {
        return mapper.getProduct(product_no);
    }
}
