package com.zc.mapper;

import com.zc.domain.GlobalAccess;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Mapper
public interface GlobalAccessMapper {

    /*
    * 查询所有首页访问量
    * @params globalAccess
    * */
    public List<GlobalAccess> findAll(@Param("totalDate") String totalDate);

    /*
    * 新增一个首页统计访问的维度
    * */
    public void addOne();

    /*
    * 访问量+1
    * */
    public void updateCount(@Param("totalDate") String totalDate);
}
