package com.zc.service;

import com.zc.domain.InsideArticle;
import com.zc.mapper.InsideArticleMapper;
import com.zc.utils.CommonPage;
import com.zc.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

        map.put("page", commonPage);
        map.put("list", all);

        if (all.size() == 0) {
            return CommonResult.isNull(map);
        } else {
            return CommonResult.success(map);
        }
    }

    /*
    * 新增一个内部文章
    * @params insideArticle
    * */
    public CommonResult addOne(InsideArticle insideArticle) {
        if (insideArticle.getArticleTypeId() == null || insideArticle.getArticleContent() == null || insideArticle.getArticleAuthor() == null) {
            return CommonResult.paramsError("");
        } else {
            insideArticle.setCreateTime(new Date());

            insideArticleMapper.addOne(insideArticle);

            return CommonResult.success(insideArticle);
        }
    }

    /*
    * 删除一片内部文章
    * @params insideArticle
    * */
    public CommonResult deleteOne(InsideArticle insideArticle) {
        if (insideArticle.getId() == null) {
            return CommonResult.paramsError("");
        } else {
            insideArticleMapper.deleteOne(insideArticle);

            return CommonResult.success("");
        }
    }
}
