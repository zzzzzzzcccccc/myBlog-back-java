package com.zc.controller;

import com.zc.domain.GlobalAccess;
import com.zc.domain.GlobalBanner;
import com.zc.domain.GlobalNav;
import com.zc.service.GlobalAccessService;
import com.zc.service.GlobalBannerService;
import com.zc.service.GlobalNavService;
import com.zc.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/index")
public class IndexController {

    @Autowired
    private GlobalNavService globalNavService;

    @Autowired
    private GlobalBannerService globalBannerService;

    @Autowired
    private GlobalAccessService globalAccessService;

    /*
    * 获取首页所有配置信息
    * */
    @GetMapping(value = "/list")
    public CommonResult getGlobalList() {

        Map<String, Object> map = new HashMap<String, Object>();

        List<GlobalNav> navList = globalNavService.getGlobalNavList();
        List<GlobalBanner> bannerList = globalBannerService.getGlobalBannerList();
        List<GlobalAccess> accessesList = globalAccessService.getGlobalAccessList();

        map.put("navList", navList);
        map.put("bannerList", bannerList);
        map.put("accessesList", accessesList);

        return CommonResult.success(map);
    }
}
