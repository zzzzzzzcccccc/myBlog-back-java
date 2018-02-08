package com.zc.service;

import com.zc.domain.GlobalAccess;
import com.zc.mapper.GlobalAccessMapper;
import com.zc.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GlobalAccessService {

    @Autowired
    private GlobalAccessMapper globalAccessMapper;

    /*
    * 查询所有首页访问量列表
    * */
    public List<GlobalAccess> getGlobalAccessList() {

        // 查询是否有当天
        List<GlobalAccess> searchAll = globalAccessMapper.findAll(Common.getNowDate());

        if (searchAll.size() == 0) { // 每天统计当天的记录新增一个
            // 插入
            globalAccessMapper.addOne();

            return globalAccessMapper.findAll("");
        } else { // 有记录则更新
            // 访问量+1执行
            globalAccessMapper.updateCount(Common.getNowDate());

            return globalAccessMapper.findAll("");
        }
    }
}
