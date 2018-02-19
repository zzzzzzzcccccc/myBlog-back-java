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
    * 查询角色名称是否存在
    * @params roleName
    * */
    public Integer checkRoleName(@Param("roleName") String roleName);

    /*
    * 查询所有角色列表 不带分页
    * */
    public List<SysRole> findAllNoPage();

    /*
    * 新增一个角色
    * @params sysRole
    * */
    public void addOne(SysRole sysRole);

    /*
    * 更新权限列表
    * @params id
    * @params authorityList
    * */
    public void updateByAuthorityList(@Param("id") String id,
                                      @Param("authorityList") String authorityList);

    /*
    * 更新角色名称
    * @params id
    * @params roleName
    * */
    public void updateByRoleName(@Param("id") String id,
                                 @Param("roleName") String roleName);

    /*
    * 删除一条角色
    * @params sysRole
    * */
    public void deleteOne(SysRole sysRole);
}
