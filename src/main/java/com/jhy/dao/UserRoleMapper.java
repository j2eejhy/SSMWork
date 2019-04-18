package com.jhy.dao;

import com.jhy.pojo.UserRole;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);
}