package com.zc.mapper;

import com.zc.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SysUserMapper {

    /*
    * 检测账号密码
    * @params sysUser
    * */
    public Integer checkLogin(@Param("sysUser") SysUser sysUser);

    /*
    * 判断账号是否存在
    * @params username
    * */
    public Integer checkAddOne(@Param("username") String username);

    /*
    * 判断账号是否被禁用
    * */
    public SysUser findByUsername(@Param("sysUser") SysUser sysUser);

    /*
    * 新增一个账号
    * @params sysUser
    * */
    public void addOne(SysUser sysUser);
}
