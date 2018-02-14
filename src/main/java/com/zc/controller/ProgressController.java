package com.zc.controller;

import com.zc.service.ProgressService;
import com.zc.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/progress")
public class ProgressController {

    @Autowired
    private ProgressService progressService;

    /*
    * 查询所有历程列表
    * */
    @GetMapping(value = "/list")
    public CommonResult getList() {

        return progressService.getList();
    }
}
