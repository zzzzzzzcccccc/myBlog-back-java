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

    /*
    * 根据id增加一个统计数值
    * @params id
    * */
    public void addArticleCount(@Param("id") String id);

    /*
    * 根据id减少一个统计数值
    * @params id
    * */
    public void minusArticleCount(@Param("id") String id);

    /*
    * 新增一个文章类型
    * @params articleType
    * */
    public void addOne(ArticleType articleType);

    /*
    * 更新一个文章类型
    * @params id
    * @params name
    * @params href
    * @params labelColor
    * */
    public void updateOne(@Param("id") String id,
                          @Param("name") String name,
                          @Param("href") String href,
                          @Param("labelColor") String labelColor);

    /*
    * 删除一个文章类型
    * @params articleType
    * */
    public void deleteOne(ArticleType articleType);
}
