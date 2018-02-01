package com.zc.service;

import com.zc.domain.ArticleType;
import com.zc.mapper.ArticleTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
