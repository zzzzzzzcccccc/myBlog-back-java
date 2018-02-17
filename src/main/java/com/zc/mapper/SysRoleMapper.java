package com.zc.mapper;

import com.zc.domain.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SysRoleMapper {

    /*
    * 根据id查询
    * @params id
    * */
    public SysRole findById(@Param("id") Long id);
}
