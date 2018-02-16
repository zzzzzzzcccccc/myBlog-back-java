package com.zc.controller;

import com.zc.domain.InsideArticle;
import com.zc.service.ArticleTypeService;
import com.zc.service.InsideArticleService;
import com.zc.utils.CommonPage;
import com.zc.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/inside/article")
public class InsideArticleController {

    @Autowired
    private InsideArticleService insideArticleService;

    /*
    * 获取内部文章列表
    * @params commonPage
    * @params insideArticle
    * */
    @GetMapping(value = "/list")
    public CommonResult getInsideArticle(CommonPage commonPage, InsideArticle insideArticle) {

        return insideArticleService.getInsideArticle(commonPage, insideArticle);
    }

    @PostMapping(value = "/findById")
    public CommonResult findById(HttpServletRequest request) {

        return insideArticleService.findById(request.getParameter("id"));
    }

    /*
    * 新增一个内部文章
    * @params insideArticle
    * */
    @PostMapping(value = "/addOne")
    public CommonResult addOne(InsideArticle insideArticle) {

        return insideArticleService.addOne(insideArticle);
    }

    /*
    * 编辑一个内部文章
    * @params insideArticle
    * */
    @PostMapping(value = "/updateOne")
    public CommonResult updateOne(InsideArticle insideArticle) {

        return insideArticleService.updateOne(insideArticle);
    }

    /*
    * 内部文章访问量加1
    * @params id
    * */
    @GetMapping(value = "/updateVisitCount")
    public CommonResult updateVisitCount(HttpServletRequest request) {

        return insideArticleService.updateVisitCount(request.getParameter("id"));
    }

    /*
    * 删除一个内部文章
    * @params insideArticle
    * */
    @GetMapping(value = "/deleteOne")
    public CommonResult deleteOne(InsideArticle insideArticle) {

        return insideArticleService.deleteOne(insideArticle);
    }
}
