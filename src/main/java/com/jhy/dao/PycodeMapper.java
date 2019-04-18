package com.jhy.dao;

import com.jhy.pojo.Pycode;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PycodeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Pycode record);

    int insertSelective(Pycode record);

    Pycode selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Pycode record);

    int updateByPrimaryKey(Pycode record);

    List<Map<String, Object>> getCode();

    List<Map<String, Object>> getCode1(@Param(value = "code") int code);
}