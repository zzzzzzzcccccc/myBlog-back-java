package com.zc.mapper;

import com.zc.domain.ArticleType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ArticleTypeMapper {

    /*
    * 查询所有文章分类列表
    * */
    public List<ArticleType> findAll();

    /*
    * 根据id查询当前文章分类的信息
    * @params Id
    * */
    public ArticleType findById(@Param("id") String id);
}
