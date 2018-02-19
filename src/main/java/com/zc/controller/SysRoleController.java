package com.zc.controller;

import com.zc.domain.SysRole;
import com.zc.service.SysRoleService;
import com.zc.utils.CommonPage;
import com.zc.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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

    /*
    * 新增一个角色
    * @params sysRole
    * */
    @PostMapping(value = "/addOne")
    public CommonResult addOne(SysRole sysRole) {

        return sysRoleService.addOne(sysRole);
    }

    /*
    * 编辑角色名称
    * @params id
    * @params roleName
    * */
    @PostMapping(value = "/updateByRoleName")
    public CommonResult updateByRoleName(HttpServletRequest request) {

        return sysRoleService.updateByRoleName(request.getParameter("id"), request.getParameter("roleName"));
    }

    /*
    * 编辑权限列表
    * @params id
    * @params authorityList
    * */
    @PostMapping(value = "/updateByAuthorityList")
    public CommonResult updateByAuthorityList(HttpServletRequest request) {

        return sysRoleService.updateByAuthorityList(request.getParameter("id"), request.getParameter("authorityList"));
    }

    /*
    * 删除一个角色
    * @params sysRole
    * */
    @GetMapping(value = "/deleteOne")
    public CommonResult deleteOne(SysRole sysRole) {

        return sysRoleService.deleteOne(sysRole);
    }
}
