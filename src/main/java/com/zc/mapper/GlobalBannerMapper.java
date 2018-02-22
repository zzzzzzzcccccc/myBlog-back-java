package com.zc.mapper;

import com.zc.domain.GlobalBanner;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GlobalBannerMapper {

    /*
    * 查询所有首页banner列表
    * */
    public List<GlobalBanner> findAll();

    /*
    * 根据id查询
    * @params id
    * */
    public GlobalBanner findById(@Param("id") String id);

    /*
    * 新增
    * @params globalBanner
    * */
    public void addOne(GlobalBanner globalBanner);

    /*
    * 更新
    * @params id
    * @params imgUrl
    * @params title
    * */
    public void updateOne(@Param("id") String id,
                          @Param("imgUrl") String imgUrl,
                          @Param("title") String title);
    /*
    * 删除
    * @params globalBanner
    * */
    public void deleteOne(GlobalBanner globalBanner);
}
