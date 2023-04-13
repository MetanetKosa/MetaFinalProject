package com.example.metawater.product;



import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    public List<ProductVO> getProductList();

    public ProductVO getProduct(Long product_no);
    public void productInsert(ProductVO product);

    public int productUpdate(ProductVO product);

    public int productDelete(Long product_no);
}
