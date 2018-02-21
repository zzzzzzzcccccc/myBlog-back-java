package com.zc.mapper;

import com.zc.domain.Progress;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProgressMapper {

    public List<Progress> findAll();

    /*
    * 根据id查询
    * @params id
    * */
    public Progress findById(@Param("id") String id);

    /*
    * 新增一个历程
    * @params
    * */
    public void addOne(Progress progress);

    /*
    * 更新一个历程
    * @params id
    * @params title
    * @params githubHref
    * @params projectHref
    * */
    public void updateOne(@Param("id") String id,
                          @Param("title") String title,
                          @Param("githubHref") String githubHref,
                          @Param("projectHref") String projectHref);

    /*
    * 删除一个历程
    * @params
    * */
    public void deleteOne(Progress progress);
}
