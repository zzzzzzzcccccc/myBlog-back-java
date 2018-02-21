package com.zc.service;

import com.zc.domain.ArticleType;
import com.zc.mapper.ArticleTypeMapper;
import com.zc.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleTypeService {

    @Autowired
    private ArticleTypeMapper articleTypeMapper;

    /*
    * 获取所有文章分类列表
    * */
    public List<ArticleType> getArticleTypeList() {

        return articleTypeMapper.findAll();
    }

    /*
    * 根据id查询所有分类信息
    * @params id
    * */
    public ArticleType getArticleTypeOne(String id) {

        return articleTypeMapper.findById(id);
    }

    /*
    * 新增一个文章类型
    * @params articleType
    * */
    public CommonResult addOne(ArticleType articleType) {

        if (articleType.getName() == null || articleType.getHref() == null || articleType.getLabelColor() == null) {
            return CommonResult.paramsError("");
        } else {
            articleType.setArticleCount(0);
            articleType.setVisible(true);
            articleType.setCreateTime(new Date());
            articleTypeMapper.addOne(articleType);

            return CommonResult.success(articleType);
        }
    }

    /*
    * 更新一个文章类型
    * @params id
    * @params name
    * @params href
    * @params labelColor
    * */
    public CommonResult updateOne(String id, String name, String href, String labelColor) {
        if (id == null || name == null || href == null || labelColor == null) {
            return CommonResult.paramsError("");
        } else {
            articleTypeMapper.updateOne(id, name, href, labelColor);

            return CommonResult.success(articleTypeMapper.findById(id));
        }
    }

    /*
    * 删除一个文章类型
    * @params articleType
    * */
    public CommonResult deleteOne(ArticleType articleType) {
        if (articleType.getId() == null) {
            return CommonResult.paramsError("");
        } else {
            articleTypeMapper.deleteOne(articleType);

            return CommonResult.success("");
        }
    }
}
