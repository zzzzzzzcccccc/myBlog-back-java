package com.zc.service;

import com.zc.domain.Progress;
import com.zc.mapper.ProgressMapper;
import com.zc.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class ProgressService {

    @Autowired
    private ProgressMapper progressMapper;

    /*
    * 查询所有历程列表
    * */
    public CommonResult getList() {

        List<Progress> progressList = progressMapper.findAll();

        return CommonResult.success(progressList);
    }

    /*
    * 新增一个历程
    * @params progress
    * */
    @Transactional
    public CommonResult addOne(Progress progress) {

        if (progress.getTitle() == null) {
            return CommonResult.paramsError("");
        } else {
            progress.setCreateTime(new Date());
            progressMapper.addOne(progress);

            return CommonResult.success(progress);
        }
    }

    /*
    * 更新一个历程
    * @params id
    * @params title
    * @params githubHref
    * @params projectHref
    * */
    @Transactional
    public CommonResult updateOne(String id, String title, String githubHref, String projectHref) {
        if (id == null || title == null) {
            return CommonResult.paramsError("");
        } else {
            progressMapper.updateOne(id, title, githubHref, projectHref);

            return CommonResult.success(progressMapper.findById(id));
        }
    }

    /*
    * 删除一个历程
    * */
    @Transactional
    public CommonResult deleteOne(Progress progress) {
        if (progress.getId() == null) {
            return CommonResult.paramsError("");
        } else {
            progressMapper.deleteOne(progress);

            return CommonResult.success("");
        }
    }
}
