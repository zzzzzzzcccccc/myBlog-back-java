package com.zc.service;

import com.zc.domain.ArticleType;
import com.zc.domain.InsideArticle;
import com.zc.mapper.InsideArticleMapper;
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
public class InsideArticleService {

    @Autowired
    private InsideArticleMapper insideArticleMapper;

    @Autowired
    private ArticleTypeService articleTypeService;

    /*
    * 获取所有内部文章
    * @params commonPage
    * @params insideArticle
    * */
    public CommonResult getInsideArticle(CommonPage commonPage, InsideArticle insideArticle) {

        Map<String, Object> map = new HashMap<String, Object>();

        commonPage.setTotal(insideArticleMapper.countAll(insideArticle));

        List<InsideArticle> all = insideArticleMapper.findAll(commonPage, insideArticle);
        List<ArticleType> articleTypeList = articleTypeService.getArticleTypeList();

        map.put("page", commonPage);
        map.put("articleTypeList", articleTypeList);
        map.put("list", all);

        return CommonResult.success(map);
    }

    /*
    * 根据id查询一篇内部文章
    * @params id
    * */
    public CommonResult findById(String id) {
        if (id == null) {
            return CommonResult.paramsError("");
        } else {
            Map<String, Object> map = new HashMap<String, Object>();

            InsideArticle insideArticle = insideArticleMapper.findById(id);
            List<ArticleType> articleTypeList = articleTypeService.getArticleTypeList();

            map.put("insideArticle", insideArticle);
            map.put("articleTypeList", articleTypeList);

            return CommonResult.success(map);
        }
    }

    /*
    * 根据文章类型查询
    * @params articleTypeId
    * */
    public List<InsideArticle> findByArticleTypeId (String articleTypeId) {

        return insideArticleMapper.findByArticleTypeId(articleTypeId);
    }

    /*
    * 新增一个内部文章
    * @params insideArticle
    * */
    @Transactional
    public CommonResult addOne(InsideArticle insideArticle) {
        if (insideArticle.getArticleTypeId() == null || insideArticle.getArticleAuthor() == null || insideArticle.getArticleTitle() == null) {
            return CommonResult.paramsError("");
        } else {
            insideArticle.setCreateTime(new Date());
            insideArticle.setVisitCount(0);
            insideArticleMapper.addOne(insideArticle);

            return CommonResult.success(insideArticle);
        }
    }

    /*
    * 编辑一个内部文章
    * @params id
    * @params articleTitle
    * @params articleAuthor
    * @params articleTypeId
    * */
    @Transactional
    public CommonResult updateOne(String id, String articleTitle, String articleAuthor, String articleTypeId) {
        if (id == null || articleTitle == null || articleAuthor == null || articleTypeId == null) {
            return CommonResult.paramsError("");
        } else {
            insideArticleMapper.updateOne(id, articleTitle, articleAuthor, articleTypeId);

            return CommonResult.success(insideArticleMapper.findById(id));
        }
    }

    /*
    * 编辑一个内部文章的内容
    * @params id
    * @params articleContent
    * */
    @Transactional
    public CommonResult updateByArticleContent(String id, String articleContent) {
        if (id == null || articleContent == null) {
            return CommonResult.paramsError("");
        } else {
            insideArticleMapper.updateByArticleContent(id, articleContent);

            return CommonResult.success(insideArticleMapper.findById(id));
        }
    }

    /*
    * 内部文章访问量加1
    * @params id
    * */
    @Transactional
    public CommonResult updateVisitCount(String id) {
        if (id == null) {
            return CommonResult.paramsError("");
        } else {
            insideArticleMapper.updateVisitCount(id);

            return CommonResult.success("");
        }
    }

    /*
    * 删除一片内部文章
    * @params insideArticle
    * */
    @Transactional
    public CommonResult deleteOne(InsideArticle insideArticle) {
        if (insideArticle.getId() == null) {
            return CommonResult.paramsError("");
        } else {
            insideArticleMapper.deleteOne(insideArticle);

            return CommonResult.success("");
        }
    }
}
