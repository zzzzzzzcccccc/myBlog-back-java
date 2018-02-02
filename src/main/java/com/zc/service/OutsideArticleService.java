package com.zc.service;

import com.zc.domain.OutsideArticle;
import com.zc.mapper.OutsideArticleMapper;
import com.zc.utils.CommonPage;
import com.zc.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OutsideArticleService {

    @Autowired
    private OutsideArticleMapper outsideArticleMapper;

    /*
    * 查询所有文章列表
    * @params commonPage
    * @params outsideArticle
    * */
    public CommonResult getOutsideArticleList(CommonPage commonPage, OutsideArticle outsideArticle) {

        Map<String, Object> map = new HashMap<String, Object>();

        commonPage.setTotal(outsideArticleMapper.countAll(outsideArticle));

        List<OutsideArticle> all = outsideArticleMapper.findAll(commonPage, outsideArticle);

        map.put("page", commonPage);
        map.put("list", all);


        if (all.size() == 0) {
            return CommonResult.isNull(map);
        } else {
            return CommonResult.success(map);
        }
    }
}
