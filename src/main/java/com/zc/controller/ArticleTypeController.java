package com.zc.controller;

import com.zc.service.ArticleTypeService;
import com.zc.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/articleType")
public class ArticleTypeController {

    @Autowired
    private ArticleTypeService articleTypeService;

    /*
    * 获取所有文章类型列表
    * */
    @GetMapping(value = "/allList")
    public CommonResult allList () {

        return CommonResult.success(articleTypeService.getArticleTypeList());
    }
}
