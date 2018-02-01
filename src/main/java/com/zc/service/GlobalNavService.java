package com.zc.service;

import com.zc.domain.GlobalNav;
import com.zc.mapper.GlobalNavMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GlobalNavService {

    @Autowired
    private GlobalNavMapper globalNavMapper;

    /*
    * 查询所有的首页导航栏李列表
    * */
    public List<GlobalNav> getAllGlobalNav() {

        return globalNavMapper.findAll();
    }
}
