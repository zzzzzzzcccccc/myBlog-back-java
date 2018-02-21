package com.zc.service;

import com.zc.domain.InsideArticle;
import com.zc.domain.OutsideArticle;
import com.zc.mapper.InsideArticleMapper;
import com.zc.mapper.OutsideArticleMapper;
import com.zc.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IndexService {

    @Autowired
    private OutsideArticleMapper outsideArticleMapper;

    @Autowired
    private InsideArticleMapper insideArticleMapper;

    /*
    * 根据文章类型id查询所有该类型的所有文章列表
    * @params articleTypeId
    * */
    public CommonResult findByArticleTypeId(String articleTypeId) {
        Map<String, Object> map = new HashMap<String, Object>();

        if (articleTypeId == null) {
            return CommonResult.paramsError("");
        }

        List<OutsideArticle> outsideArticles = outsideArticleMapper.findByArticleTypeId(articleTypeId);
        List<InsideArticle> insideArticles = insideArticleMapper.findByArticleTypeId(articleTypeId);

        map.put("outsideArticles", outsideArticles);
        map.put("insideArticles", insideArticles);

        return CommonResult.success(map);
    }

     /*
    * 根据文章标题模糊查询
    * @params articleTitle
    * */
    public CommonResult findByArticleTitle (String articleTitle) {
        if (articleTitle == null) {
            return CommonResult.paramsError("");
        } else {

            Map<String, Object> map = new HashMap<String, Object>();

            List<InsideArticle> insideArticles = insideArticleMapper.findByArticleTitle(articleTitle);
            List<OutsideArticle> outsideArticles = outsideArticleMapper.findByArticleTitle(articleTitle);

            map.put("insideArticles", insideArticles);
            map.put("outsideArticles", outsideArticles);

            return CommonResult.success(map);
        }
    }
}
