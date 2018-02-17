package com.zc.mapper;

import com.zc.domain.SysModule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SysModuleMapper {

    /*
    * 根据idList查询
    * @params ids
    * */
    public List<SysModule> findByIds(String[] ids);
}
