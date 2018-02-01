package com.zc.service;

import com.zc.domain.InsideArticle;
import com.zc.mapper.InsideArticleMapper;
import com.zc.utils.CommonPage;
import com.zc.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InsideArticleService {

    @Autowired
    private InsideArticleMapper insideArticleMapper;

    /*
    * 获取所有内部文章
    * @params commonPage
    * @params insideArticle
    * */
    public CommonResult getInsideArticle(CommonPage commonPage, InsideArticle insideArticle) {

        Map<String, Object> map = new HashMap<String, Object>();

        commonPage.setTotal(insideArticleMapper.countAll(insideArticle));

        List<InsideArticle> all = insideArticleMapper.findAll(commonPage, insideArticle);

        map.put("list", commonPage);
        map.put("data", all);

        if (all.size() == 0) {
            return CommonResult.isNull(map);
        } else {
            return CommonResult.success(map);
        }
    }
}
