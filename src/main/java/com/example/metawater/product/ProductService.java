package com.example.metawater.product;

import java.util.List;

public interface ProductService {

    public void insertProduct(ProductVO product);
    public boolean updateProduct(ProductVO product);
    public boolean deleteProduct(Long product_no);
    public List<ProductVO> getProductList();
    public ProductVO getProduct(Long product_no);
}
