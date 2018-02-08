package com.zc.service;

import com.zc.domain.GlobalAccess;
import com.zc.mapper.GlobalAccessMapper;
import com.zc.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GlobalAccessService {

    @Autowired
    private GlobalAccessMapper globalAccessMapper;

    /*
    * 执行访问量+1
    * */
    private List<GlobalAccess> doVisitCount() {

        // 查询是否有当天
        List<GlobalAccess> searchAll = globalAccessMapper.findAll(Common.getNowDate(), Common.getNowDate());

        if (searchAll.size() == 0) { // 每天统计当天的记录新增一个
            // 插入
            globalAccessMapper.addOne();

            return globalAccessMapper.findAll("", "");
        } else { // 有记录则更新
            // +1执行
            globalAccessMapper.updateCount(Common.getNowDate());

            return globalAccessMapper.findAll("", "");
        }
    }

    /*
    * 获取总访问量
    * */
    @Transactional
    public Integer getAllVisitCount() {
        List<GlobalAccess> all = this.doVisitCount();
        int count = 0;
        // 遍历list算合计
        for (GlobalAccess anAll : all) {
            count += anAll.getVisitCount();
        }

        return count;
    }

    /*
    * 获取放量列表
    * @params startTime
    * @params endTime
    * */
    public List<GlobalAccess> getGlobalAccessList(String startTime, String endTime) {

        return globalAccessMapper.findAll(startTime, endTime);
    }
}
