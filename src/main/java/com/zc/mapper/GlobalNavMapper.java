package com.zc.mapper;

import com.zc.domain.GlobalNav;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GlobalNavMapper {

    /*
    * 查询所有首页导航列表
    * */
    public List<GlobalNav> findAll();

    /*
    * 根据id查询
    * @params id
    * */
    public GlobalNav findById(@Param("id") String id);

    /*
    * 新增
    * @params globalNav
    * */
    public void addOne(GlobalNav globalNav);

    /*
    * 编辑
    * @params id
    * @params name
    * @params enName
    * @params href
    * @params iconClassName
    * */
    public void updateOne(@Param("id") String id,
                          @Param("name") String name,
                          @Param("enName") String enName,
                          @Param("href") String href,
                          @Param("iconClassName") String iconClassName);

    /*
    * 删除
    * @params globalNav
    * */
    public void deleteOne(GlobalNav globalNav);
}
