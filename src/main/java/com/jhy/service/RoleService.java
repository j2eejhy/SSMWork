package com.jhy.service;

import com.jhy.pojo.Role;
import org.springframework.stereotype.Service;

/**
 * @Auther: Raytine
 * @Date: 2018/7/10 00:44
 * @Description:
 */
public interface RoleService {

    Role selectById(Long id);
}
