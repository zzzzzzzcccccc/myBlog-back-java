package com.zc.controller;

import com.zc.domain.SysUser;
import com.zc.service.SysUserService;
import com.zc.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /*
    * 登录
    * */
    @PostMapping(value = "/accountLogin")
    public CommonResult accountLogin(SysUser sysUser) {

        return sysUserService.accountLogin(sysUser);
    }

    /*
    * 新增一个账号
    * @params
    * */
    @PostMapping(value = "/addOne")
    public CommonResult addOne(SysUser sysUser) {

        return sysUserService.addOne(sysUser);
    }
}
