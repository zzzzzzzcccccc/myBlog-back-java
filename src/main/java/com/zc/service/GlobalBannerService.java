package com.zc.service;

import com.zc.domain.GlobalBanner;
import com.zc.mapper.GlobalBannerMapper;
import com.zc.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GlobalBannerService {

    @Autowired
    private GlobalBannerMapper globalBannerMapper;

    /*
    * 获取首页banner信息
    * */
    public List<GlobalBanner> getGlobalBannerList() {

        return globalBannerMapper.findAll();
    }

    /*
    * 新增
    * @params globalBanner
    * */
    @Transactional
    public CommonResult addOne(GlobalBanner globalBanner) {
        if (globalBanner.getImgUrl() == null) {
            return CommonResult.paramsError("");
        } else {
            globalBannerMapper.addOne(globalBanner);

            return CommonResult.success(globalBanner);
        }
    }

    /*
    * 更新
    * @params id
    * @params imgUrl
    * @params title
    * */
    @Transactional
    public CommonResult updateOne(String id, String imgUrl, String title) {
        if (id == null || imgUrl == null) {
            return CommonResult.paramsError("");
        } else {
            globalBannerMapper.updateOne(id, imgUrl, title);

            return CommonResult.success(globalBannerMapper.findById(id));
        }
    }

    /*
    * 删除
    * @params
    * */
    @Transactional
    public CommonResult deleteOne(GlobalBanner globalBanner) {
        if (globalBanner.getId() == null) {
            return CommonResult.paramsError("");
        } else {
            globalBannerMapper.deleteOne(globalBanner);

            return CommonResult.success("");
        }
    }
}
