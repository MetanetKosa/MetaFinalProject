package com.example.metawater.mapper;

import com.example.metawater.domain.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    public List<ProductVO> getProductList();
    public List<ProductVO> getBestProductList();
    public List<ProductVO> getProductListBySearch(String searchKeyword);
    //public List<ProductVO> getProductListByCategory();
    public ProductVO getProduct(Long product_no);

    public void productInsert(ProductVO product);

    public int productUpdate(ProductVO product);

    public int productDelete(Long product_no);
}
