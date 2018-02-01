package com.zc.controller;

import com.zc.service.GlobalNavService;
import com.zc.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/index")
public class IndexController {

    @Autowired
    private GlobalNavService globalNavService;

    /*
    * 获取首页导航栏列表
    * */
    @GetMapping(value = "/getAllGlobalNav")
    public CommonResult getAllGlobalNav() {

        return CommonResult.success(globalNavService.getAllGlobalNav());
    }
}
