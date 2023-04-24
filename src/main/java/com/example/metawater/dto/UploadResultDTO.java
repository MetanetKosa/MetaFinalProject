package com.example.metawater.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadResultDTO {
    private String fileName;
    private String uuid;
    private String folderPath;

    private Long product_no;

    public UploadResultDTO(String fileName, String uuid, String folderPath) {
        this.fileName = fileName;
        this.uuid = uuid;
        this.folderPath = folderPath;
    }

    public String getImageURL() {
        try{
            return URLEncoder.encode(folderPath +"/" + uuid + "_" + fileName,"UTF-8");
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();;
        }
        return "";
    }


    //섬네일 처리
    public String getThumbnailURL() {
        try{
            return URLEncoder.encode(folderPath+"/s_" + uuid + "_" + fileName,"UTF-8");
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return "";
    }
}
