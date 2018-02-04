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
    private ArticleTypeService articleTypeService;

    @Autowired
    private InsideArticleService insideArticleService;

    /*
    * 获取文章分类列表
    * */
    @GetMapping(value = "/type")
    public CommonResult getArticleTypeList() {

        return CommonResult.success(articleTypeService.getArticleTypeList());
    }

    /*
    * 根据id查询当前文章分类
    * */
    @GetMapping(value = "/type/getOne")
    public CommonResult getArticleTypeOne(HttpServletRequest request) {

        return CommonResult.success(articleTypeService.getArticleTypeOne(request.getParameter("id")));
    }

    /*
    * 获取内部文章列表
    * @params commonPage
    * @params insideArticle
    * */
    @PostMapping(value = "/list")
    public CommonResult getInsideArticle(CommonPage commonPage, InsideArticle insideArticle) {

        return insideArticleService.getInsideArticle(commonPage, insideArticle);
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
    * 删除一个内部文章
    * @params insideArticle
    * */
    @GetMapping(value = "/deleteOne")
    public CommonResult deleteOne(InsideArticle insideArticle) {

        return insideArticleService.deleteOne(insideArticle);
    }
}
