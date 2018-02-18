package com.zc.controller;

import com.zc.domain.SysRole;
import com.zc.service.SysRoleService;
import com.zc.utils.CommonPage;
import com.zc.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    /*
    * 查询所有角色列表
    * @params sysRole
    * @params commonPage
    * */
    @GetMapping(value = "/list")
    public CommonResult findAll(SysRole sysRole, CommonPage commonPage) {

        return sysRoleService.findAll(sysRole, commonPage);
    }
}
