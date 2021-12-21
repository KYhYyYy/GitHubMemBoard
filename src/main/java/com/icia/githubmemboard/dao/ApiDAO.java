package com.icia.githubmemboard.dao;

import com.icia.githubmemboard.dto.ApiDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApiDAO {

    int insertMap(ApiDTO api);

    List<ApiDTO> storeList();

    ApiDTO store(String storeName);
}
