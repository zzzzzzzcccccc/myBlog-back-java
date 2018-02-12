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
    * 查询所有外部文章总数
    * @params outsideArticle
    * */
    public Integer countAll(@Param("outsideArticle") OutsideArticle outsideArticle);

    /*
    * 外部文章访问量+1
    * @params id
    * */
    public void updateVisitCount(@Param("id") String id);
}
