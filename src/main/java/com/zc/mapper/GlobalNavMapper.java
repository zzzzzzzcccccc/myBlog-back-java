package com.zc.mapper;

import com.zc.domain.GlobalNav;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GlobalNavMapper {

    /*
    * 查询所有全局导航列表
    * */
    public List<GlobalNav> findAll();
}
