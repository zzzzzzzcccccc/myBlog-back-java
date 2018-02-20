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
import java.util.Date;
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

        return CommonResult.success(map);
    }

    /*
    * 根据文章类型查询
    * @params articleTypeId
    * */
    public List<OutsideArticle> findByArticleTypeId (String articleTypeId) {

        return outsideArticleMapper.findByArticleTypeId(articleTypeId);
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

    /*
    * 新增一个外部文章
    * @params
    * */
    @Transactional
    public CommonResult addOne(OutsideArticle outsideArticle) {
        if (outsideArticle.getArticleTitle() == null ||
                outsideArticle.getArticleHref() == null ||
                outsideArticle.getArticleTypeId() == null) {
            return CommonResult.paramsError("");
        } else {
            outsideArticle.setVisitCount(0);
            outsideArticle.setArticleLikeCount(0);
            outsideArticle.setCreateTime(new Date());
            outsideArticleMapper.addOne(outsideArticle);

            return CommonResult.success(outsideArticle);
        }
    }

    /*
    * 编辑一个外部文章
    * @params id
    * @params articleTitle
    * @params articleHref
    * @params articleAuthor
    * @params articleTypeId
    * */
    @Transactional
    public CommonResult updateOne(String id,
                                  String articleTitle,
                                  String articleHref,
                                  String articleAuthor,
                                  String articleTypeId) {
        if (id == null || articleTitle == null || articleHref == null ||articleTypeId == null) {
            return CommonResult.paramsError("");
        } else {
            outsideArticleMapper.updateOne(id, articleTitle, articleHref, articleAuthor, articleTypeId);

            return CommonResult.success(outsideArticleMapper.findById(id));
        }
    }

    /*
    * 删除一个内部文章
    * @params outsideArticle
    * */
    @Transactional
    public CommonResult deleteOne(OutsideArticle outsideArticle) {
        if (outsideArticle.getId() == null) {
            return CommonResult.paramsError("");
        } else {
            outsideArticleMapper.deleteOne(outsideArticle);

            return CommonResult.success("");
        }
    }
}
