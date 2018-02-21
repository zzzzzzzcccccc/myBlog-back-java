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
    * 根据id查询一篇内部文章
    * @params id
    * */
    public InsideArticle findById(@Param("id") String id);

    /*
    * 根据文章类型查询
    * @params articleTypeId
    * */
    public List<InsideArticle> findByArticleTypeId(@Param("articleTypeId") String articleTypeId);

    /*
    * 根据文章标题模糊查询
    * @params articleTitle
    * */
    public List<InsideArticle> findByArticleTitle(@Param("articleTitle") String articleTitle);

    /*
    * 新增一个内部文章
    * @params insideArticle
    * */
    public void addOne(InsideArticle insideArticle);

    /*
    * 更新一个内部文章
    * @params id
    * @params articleTitle
    * @params articleAuthor
    * @params articleTypeId
    * */
    public void updateOne(@Param("id") String id,
                          @Param("articleTitle") String articleTitle,
                          @Param("articleAuthor") String articleAuthor,
                          @Param("articleTypeId") String articleTypeId);

    /*
    * 更新一个内部文章内容
    * @params id
    * @params articleContent
    * */
    public void updateByArticleContent(@Param("id") String id,
                                       @Param("articleContent") String articleContent);

    /*
    * 内部文章访问量加1
    * @params id
    * */
    public void updateVisitCount(@Param("id") String id);

    /*
    * 删除一个内部文章
    * @params insideArticle
    * */
    public void deleteOne(InsideArticle insideArticle);
}
