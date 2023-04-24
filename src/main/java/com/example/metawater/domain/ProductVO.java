package com.example.metawater.domain;

import com.example.metawater.dto.UploadResultDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductVO {
    private Long productNo;
    private String productName;
    private String productSize;
    private String productWeight;
    private String productDetail;
    private String productGuide;
    private String productType;
    private String productMethod;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date productRdate;
    private String productCompany;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date regDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateDate;
    private String imgUrl;
    private String detailUrl;

    private int productSales;

    private String productFunction;

    private String productModel;

    private int productRentalPrice;

    private int productPrice;

    private String productColor;

    private List<UploadResultDTO> attachList;

}
