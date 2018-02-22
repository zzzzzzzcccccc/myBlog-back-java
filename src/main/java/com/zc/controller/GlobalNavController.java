package com.zc.controller;

import com.zc.domain.GlobalNav;
import com.zc.service.GlobalNavService;
import com.zc.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/globalNav")
public class GlobalNavController {

    @Autowired
    private GlobalNavService globalNavService;

    /*
    * 查询列表
    * */
    @GetMapping(value = "/list")
    public CommonResult getList () {

        return CommonResult.success(globalNavService.getGlobalNavList());
    }

    /*
    * 新增
    * @params globalNav
    * */
    @PostMapping(value = "/addOne")
    public CommonResult addOne(GlobalNav globalNav) {

        return globalNavService.addOne(globalNav);
    }

    /*
  * 编辑
  * @params id
  * @params name
  * @params enName
  * @params href
  * @params iconClassName
  * */
    @PostMapping(value = "/updateOne")
    public CommonResult updateOne(HttpServletRequest request) {

        return globalNavService.updateOne(request.getParameter("id"),
                request.getParameter("name"),
                request.getParameter("enName"),
                request.getParameter("href"),
                request.getParameter("iconClassName"));
    }

    /*
    * 删除
    * @params globalNav
    * */
    @GetMapping(value = "/deleteOne")
    public CommonResult deleteOne(GlobalNav globalNav) {

        return globalNavService.deleteOne(globalNav);
    }
}
