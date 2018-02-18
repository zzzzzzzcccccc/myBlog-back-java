package com.zc.mapper;

import com.zc.domain.SysRole;
import com.zc.utils.CommonPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SysRoleMapper {

    /*
    * 查询角色列表
    * @params sysRole
    * @params commonPage
    * */
    public List<SysRole> findAll(@Param("sysRole") SysRole sysRole,
                                 @Param("commonPage")CommonPage commonPage);

    /*
    * 统计总数
    * @params sysRole
    * */
    public Integer countAll(@Param("sysRole") SysRole sysRole);

    /*
    * 根据id查询
    * @params id
    * */
    public SysRole findById(@Param("id") Long id);

    /*
    * 查询所有角色列表 不带分页
    * */
    public List<SysRole> findAllNoPage();
}
