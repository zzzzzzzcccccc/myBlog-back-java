package com.zc.mapper;

import com.zc.domain.InsideArticle;
import com.zc.utils.CommonPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface InsideArticleMapper {

    /*
    * 查询所有内部文章列表
    * @params commonPage
    * @params insideArticle
    * */
    public List<InsideArticle> findAll(@Param("commonPage") CommonPage commonPage,
                                       @Param("insideArticle") InsideArticle insideArticle);

    /*
    * 获取内部文章数量
    * @params insideArticle
    * */
    public Integer countAll(@Param("insideArticle") InsideArticle insideArticle);

    /*
    * 新增一个内部文章
    * @params insideArticle
    * */
    public void addOne(InsideArticle insideArticle);

    /*
    * 删除一个内部文章
    * @params insideArticle
    * */
    public void deleteOne(InsideArticle insideArticle);
}
