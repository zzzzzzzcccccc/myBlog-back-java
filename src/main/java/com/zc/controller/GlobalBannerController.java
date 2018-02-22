package com.zc.controller;

import com.zc.domain.GlobalBanner;
import com.zc.service.GlobalBannerService;
import com.zc.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/globalBanner")
public class GlobalBannerController {

    @Autowired
    private GlobalBannerService globalBannerService;

    /*
    * 查询所有
    * */
    @GetMapping(value = "/list")
    public CommonResult getList () {

        return CommonResult.success(globalBannerService.getGlobalBannerList());
    }

    /*
    * 新增
    * @params globalBanner
    * */
    @PostMapping(value = "/addOne")
    public CommonResult addOne(GlobalBanner globalBanner) {

        return globalBannerService.addOne(globalBanner);
    }

      /*
    * 更新
    * @params id
    * @params imgUrl
    * @params title
    * */
    @PostMapping(value = "/updateOne")
    public CommonResult updateOne(HttpServletRequest request) {

        return globalBannerService.updateOne(request.getParameter("id"),
                request.getParameter("imgUrl"),
                request.getParameter("title"));
    }

    /*
    * 删除
    * @params globalBanner
    * */
    @GetMapping(value = "/deleteOne")
    public CommonResult deleteOne (GlobalBanner globalBanner) {

        return globalBannerService.deleteOne(globalBanner);
    }
}
