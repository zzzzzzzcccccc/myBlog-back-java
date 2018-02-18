package com.zc.service;

import com.zc.domain.SysRole;
import com.zc.mapper.SysRoleMapper;
import com.zc.utils.CommonPage;
import com.zc.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
