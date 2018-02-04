package com.zc.mapper;

import com.zc.domain.GlobalBanner;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GlobalBannerMapper {

    /*
    * 查询所有首页banner列表
    * */
    public List<GlobalBanner> findAll();
}
