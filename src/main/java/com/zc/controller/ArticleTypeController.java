package com.zc.controller;

import com.zc.domain.ArticleType;
import com.zc.service.ArticleTypeService;
import com.zc.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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

    /*
    * 新增一个文章类型
    * @params articleType
    * */
    @PostMapping(value = "/addOne")
    public CommonResult addOne(ArticleType articleType) {

        return articleTypeService.addOne(articleType);
    }

    /*
   * 更新一个文章类型
   * @params id
   * @params name
   * @params href
   * @params labelColor
   * */
    @PostMapping(value = "/updateOne")
    public CommonResult updateOne(HttpServletRequest request) {

        return articleTypeService.updateOne(request.getParameter("id"),
                request.getParameter("name"),
                request.getParameter("href"),
                request.getParameter("labelColor"));
    }

    /*
    * 删除一个文章类型
    * @params articleType
    * */
    @GetMapping(value = "/deleteOne")
    public CommonResult deleteOne(ArticleType articleType) {

        return articleTypeService.deleteOne(articleType);
    }
}
