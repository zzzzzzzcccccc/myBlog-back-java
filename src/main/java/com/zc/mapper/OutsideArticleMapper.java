package com.zc.mapper;

import com.zc.domain.OutsideArticle;
import com.zc.utils.CommonPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OutsideArticleMapper {

    /*
    * 查询所有外部文章列表
    * @params commonPage
    * @params outsideArticle
    * */
    public List<OutsideArticle> findAll(@Param("commonPage") CommonPage commonPage,
                                        @Param("outsideArticle") OutsideArticle outsideArticle);

    /*
    * 根据id查询
    * @params id
    * */
    public OutsideArticle findById(@Param("id") String id);

    /*
    * 根据文章类型id查询
    * @params articleTypeId
    * */
    public List<OutsideArticle> findByArticleTypeId(@Param("articleTypeId") String articleTypeId);

    /*
    * 查询所有外部文章总数
    * @params outsideArticle
    * */
    public Integer countAll(@Param("outsideArticle") OutsideArticle outsideArticle);

    /*
    * 外部文章访问量+1
    * @params id
    * */
    public void updateVisitCount(@Param("id") String id);

    /*
    * 新增一个外部文章
    * @params outsideArticle
    * */
    public void addOne(OutsideArticle outsideArticle);

    /*
    * 编辑一个外部文章
    * @params id
    * @params articleTitle
    * @params articleHref
    * @params articleAuthor
    * @params articleTypeId
    * */
    public void updateOne(@Param("id") String id,
                          @Param("articleTitle") String articleTitle,
                          @Param("articleHref") String articleHref,
                          @Param("articleAuthor") String articleAuthor,
                          @Param("articleTypeId") String articleTypeId);

    /*
    * 删除一个外部文章
    * @params outsideArticle
    * */
    public void deleteOne(OutsideArticle outsideArticle);
}
