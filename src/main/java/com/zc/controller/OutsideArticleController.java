package com.zc.controller;

import com.zc.domain.OutsideArticle;
import com.zc.service.OutsideArticleService;
import com.zc.utils.CommonPage;
import com.zc.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/outside/article")
public class OutsideArticleController {

    @Autowired
    private OutsideArticleService outsideArticleService;

    /*
    * 查询所有外部文章列表
    * @params
    * @params
    * */
    @GetMapping(value = "/list")
    public CommonResult getOutsideArticleList(CommonPage commonPage, OutsideArticle outsideArticle) {

        return outsideArticleService.getOutsideArticleList(commonPage, outsideArticle);
    }
}
