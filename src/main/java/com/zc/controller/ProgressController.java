package com.zc.controller;

import com.zc.domain.Progress;
import com.zc.service.ProgressService;
import com.zc.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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

    /*
    * 新增一个历程
    * @params progress
    * */
    @PostMapping(value = "/addOne")
    public CommonResult addOne(Progress progress) {

        return progressService.addOne(progress);
    }
     /*
    * 更新一个历程
    * @params id
    * @params title
    * @params githubHref
    * @params projectHref
    * */
    @PostMapping(value = "/updateOne")
    public CommonResult updateOne(HttpServletRequest request) {

        return progressService.updateOne(request.getParameter("id"),
                request.getParameter("title"),
                request.getParameter("githubHref"),
                request.getParameter("projectHref"));
    }

    /*
    * 删除一个历程
    * @params progress
    * */
    @GetMapping(value = "/deleteOne")
    public CommonResult deleteOne(Progress progress) {

        return progressService.deleteOne(progress);
    }
}
