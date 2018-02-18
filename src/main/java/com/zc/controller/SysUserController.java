package com.zc.controller;

import com.zc.domain.SysUser;
import com.zc.service.SysUserService;
import com.zc.utils.CommonPage;
import com.zc.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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

    /*
    * 查询所有账号列表
    * @params sysUser
    * @params commonPage
    * */
    @GetMapping(value = "/list")
    public CommonResult findAll(SysUser sysUser, CommonPage commonPage) {

        return sysUserService.findAll(sysUser, commonPage);
    }

    /*
    * 删除一条账号信息
    * @params sysUser
    * */
    @GetMapping(value = "/deleteOne")
    public CommonResult deleteOne(SysUser sysUser) {

        return sysUserService.deleteOne(sysUser);
    }

    /*
    * 更新一条账号信息
    * @params sysUser
    * */
    @PostMapping(value = "/updateOne")
    public CommonResult updateOne(HttpServletRequest request) {

        return sysUserService.updateOne(request.getParameter("id"),
                request.getParameter("password"),
                request.getParameter("roleId"),
                request.getParameter("visible"));
    }
}
