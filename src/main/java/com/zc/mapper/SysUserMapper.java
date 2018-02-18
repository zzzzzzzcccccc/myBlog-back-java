package com.zc.mapper;

import com.zc.domain.SysUser;
import com.zc.utils.CommonPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    /*
    * 查询账号列表
    * @params sysUser
    * @params commonPage
    * */
    public List<SysUser> findAll(@Param("sysUser") SysUser sysUser,
                                 @Param("commonPage") CommonPage commonPage);

    /*
    * 根据id查询
    * @params id
    * */
    public SysUser findById(@Param("id") String id);

    /*
    * 查询总数
    * @params sysUser
    * */
    public Integer countAll(@Param("sysUser") SysUser sysUser);

    /*
    * 删除一条
    * @params sysUser
    * */
    public void deleteOne(SysUser sysUser);

    /*
    * 更新一条数据
    * @params id
    * @params username
    * @params password
    * @params roleId
    * @params visible
    * */
    public void updateOne(@Param("id") String id,
                          @Param("password") String password,
                          @Param("roleId") String roleId,
                          @Param("visible") Boolean visible);
}
