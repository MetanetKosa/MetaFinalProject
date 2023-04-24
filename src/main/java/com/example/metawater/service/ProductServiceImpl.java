package com.example.metawater.service;

import com.example.metawater.domain.ProductVO;
import com.example.metawater.dto.UploadResultDTO;
import com.example.metawater.mapper.AttachMapper;
import com.example.metawater.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService
{
   @Autowired
   private ProductMapper mapper;

    @Autowired
    private AttachMapper attachmapper;

    @Override
    public void insertProduct(ProductVO product) {

        mapper.productInsert(product);
        if(product.getAttachList() == null || product.getAttachList().size() <= 0){
            return;
        }
        product.setProductSales(0);
        product.getAttachList().forEach(attach -> {
            attach.setProduct_no(product.getProductNo());
            System.out.println(attach);
            attachmapper.insertFile(attach);
        });
    }

    @Override
    public boolean updateProduct(ProductVO product) {
        return mapper.productUpdate(product) == 1;
    }

    @Override
    public boolean deleteProduct(Long productNo) {
        attachmapper.deleteFileAll(productNo);
        return mapper.productDelete(productNo) == 1;
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

    @Override
    public List<UploadResultDTO> getAttachList(Long productNo) {
        return attachmapper.findByPno(productNo);
    }

    @Override
    public void deleteAttach(Long productNo) {
        attachmapper.deleteFileAll(productNo);
    }
}
