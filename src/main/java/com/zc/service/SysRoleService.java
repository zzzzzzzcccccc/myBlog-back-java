package com.zc.service;

import com.zc.domain.SysRole;
import com.zc.enums.CommonEnums;
import com.zc.mapper.SysRoleMapper;
import com.zc.utils.CommonPage;
import com.zc.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    /*
    * 查询所有角色列表
    * @params sysRole
    * @params commonPage
    * */
    public CommonResult findAll(SysRole sysRole, CommonPage commonPage) {

        Map<String, Object> map = new HashMap<String, Object>();

        commonPage.setTotal(sysRoleMapper.countAll(sysRole));
        List<SysRole> sysRoles = sysRoleMapper.findAll(sysRole, commonPage);

        map.put("list", sysRoles);
        map.put("page", commonPage);

        return CommonResult.success(map);
    }

    /*
    * 新增一个角色
    * @params sysRole
    * */
    @Transactional
    public CommonResult addOne(SysRole sysRole) {
        if (sysRole.getRoleName() == null) {
            return CommonResult.paramsError("");
        } else if (sysRoleMapper.checkRoleName(sysRole.getRoleName()) != 0) {
            return CommonResult.error(CommonEnums.ROLE_NAME_INFO.getCode(), CommonEnums.ROLE_NAME_INFO.getMsg());
        } else {
            sysRole.setCreateTime(new Date());
            sysRoleMapper.addOne(sysRole);

            return CommonResult.success(sysRole);
        }
    }

    /*
    * 编辑一个角色
    * @params id
    * @params roleName
    * */
    @Transactional
    public CommonResult updateByRoleName(String id, String roleName) {
        if (id == null || roleName == null) {
            return CommonResult.paramsError("");
        } else if (sysRoleMapper.checkRoleName(roleName) != 0) {
            return CommonResult.error(CommonEnums.ROLE_NAME_INFO.getCode(), CommonEnums.ROLE_NAME_INFO.getMsg());
        } else {
            sysRoleMapper.updateByRoleName(id, roleName);

            return CommonResult.success(sysRoleMapper.findById(Long.parseLong(id)));
        }
    }

    /*
    * 编辑角色的权限列表
    * @params id
    * @params authorityList
    * */
    @Transactional
    public CommonResult updateByAuthorityList(String id, String authorityList) {
        if (id == null || authorityList == null) {
            return CommonResult.paramsError("");
        } else {
            sysRoleMapper.updateByAuthorityList(id, authorityList);

            return CommonResult.success(sysRoleMapper.findById(Long.parseLong(id)));
        }
    }

    /*
    * 删除一个角色
    * @params sysRole
    * */
    @Transactional
    public CommonResult deleteOne(SysRole sysRole) {
        if (sysRole.getId() == null) {
            return CommonResult.paramsError("");
        } else {
            sysRoleMapper.deleteOne(sysRole);

            return CommonResult.success("");
        }
    }
}
