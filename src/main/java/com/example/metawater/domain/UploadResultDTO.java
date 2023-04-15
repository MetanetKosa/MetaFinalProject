package com.example.metawater.domain;

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
