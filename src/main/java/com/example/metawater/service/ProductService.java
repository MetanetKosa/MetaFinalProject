package com.example.metawater.service;

import com.example.metawater.domain.ProductVO;
import com.example.metawater.domain.UploadResultDTO;

import java.util.List;

public interface ProductService {

    public void insertProduct(ProductVO product);
    public boolean updateProduct(ProductVO product);
    public boolean deleteProduct(Long product_no);
    public List<ProductVO> getProductList();
    public List<ProductVO> getBestProductList();
    public ProductVO getProduct(Long product_no);

    public List<UploadResultDTO> getAttachList(Long product_no);
    public void deleteAttach(Long product_no);
}
