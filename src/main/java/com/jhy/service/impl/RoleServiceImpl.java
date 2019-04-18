package com.jhy.service.impl;

import com.jhy.dao.RoleMapper;
import com.jhy.pojo.Role;
import com.jhy.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: Raytine
 * @Date: 2018/7/10 00:45
 * @Description:
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role selectById(Long id) {
        return roleMapper.selectByPrimaryKey(1L);
    }
}
