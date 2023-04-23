package com.example.metawater.mapper;

import com.example.metawater.domain.UploadResultDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AttachMapper {

    public void insertFile(UploadResultDTO attach);

    public void deleteFile(String uuid);

    public List<UploadResultDTO> getOldFiles();

    public List<UploadResultDTO> getFiles();

    public void deleteFileAll(Long productNo);
    public List<UploadResultDTO> findByPno(Long productNo);
}
