package com.zc.mapper;

import com.zc.domain.Comment;
import com.zc.utils.CommonPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentMapper {

    /*
    * 查询所有评论列表
    * @params commonPage
    * @params comment
    * */
    public List<Comment> findAll(@Param("commonPage") CommonPage commonPage, @Param("comment") Comment comment);


    /*
    * 统计所有评论总数
    * @params comment
    * */
    public Integer countAll(@Param("comment") Comment comment);
}
