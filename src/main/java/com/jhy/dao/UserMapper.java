package com.jhy.dao;

import com.jhy.pojo.Role;
import com.jhy.pojo.User;
import com.jhy.util.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);

    List<Map<String, Object>> selectRolesByUserIdAndEnabled(@Param("userId") Long userId);

    List<Map<String, Object>> selectPageList(Page<Map<String, Object>> page);

    int selectPageList_count(Page<Map<String, Object>> page);

}