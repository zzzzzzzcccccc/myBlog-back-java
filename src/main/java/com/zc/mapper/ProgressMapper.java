package com.zc.mapper;

import com.zc.domain.Progress;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProgressMapper {

    public List<Progress> findAll();
}
