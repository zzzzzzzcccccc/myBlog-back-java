package com.zc.service;

import com.zc.domain.GlobalBanner;
import com.zc.mapper.GlobalBannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
