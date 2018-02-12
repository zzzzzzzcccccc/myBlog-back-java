package com.zc.service;

import com.zc.domain.ArticleType;
import com.zc.domain.OutsideArticle;
import com.zc.mapper.ArticleTypeMapper;
import com.zc.mapper.OutsideArticleMapper;
import com.zc.utils.CommonPage;
import com.zc.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OutsideArticleService {

    @Autowired
    private ArticleTypeService articleTypeService;

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

        List<ArticleType> articleTypeList = articleTypeService.getArticleTypeList();
        List<OutsideArticle> all = outsideArticleMapper.findAll(commonPage, outsideArticle);

        map.put("page", commonPage);
        map.put("articleTypeList", articleTypeList);
        map.put("list", all);


        if (all.size() == 0) {
            return CommonResult.isNull(map);
        } else {
            return CommonResult.success(map);
        }
    }

    /*
    * 外部文章访问量+1
    * @params id
    * */
    @Transactional
    public CommonResult updateVisitCount(String id) {
        if (id == null) {
            return CommonResult.paramsError("");
        } else {
            outsideArticleMapper.updateVisitCount(id);

            return CommonResult.success("");
        }
    }
}
