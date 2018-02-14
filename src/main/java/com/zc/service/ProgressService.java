package com.zc.service;

import com.zc.domain.Progress;
import com.zc.mapper.ProgressMapper;
import com.zc.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressService {

    @Autowired
    private ProgressMapper progressMapper;

    /*
    * 查询所有历程列表
    * */
    public CommonResult getList() {

        List<Progress> all = progressMapper.findAll();

        if (all.size() == 0) {
            return CommonResult.isNull("");
        } else {
            return CommonResult.success(all);
        }
    }
}
