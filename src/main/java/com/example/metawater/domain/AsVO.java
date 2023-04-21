package com.example.metawater.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsVO {
    private Long AsNo;
    private String AsSelect;
    private String AsContent;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date AsDate;
    private String AsTime;
    private Long OrderNo;
    private Long MemNo;
}
