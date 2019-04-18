package com.jhy.service.impl;

import com.jhy.dao.UserMapper;
import com.jhy.pojo.Role;
import com.jhy.service.UserService;
import com.jhy.util.Page;
import lombok.experimental.PackagePrivate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Auther: Raytine
 * @Date: 2018/7/11 01:13
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public  List<Map<String, Object>> select( Long userId) {
        List<Map<String, Object>> list = userMapper.selectRolesByUserIdAndEnabled(userId);
        for (Map<String, Object> role : list) {
            System.out.println(role.toString());
        }
        return list;
    }

    @Override
    public void getPageList(Page<Map<String, Object>> page) {
        page.setData(userMapper.selectPageList(page));
        page.setTotalRecord(userMapper.selectPageList_count(page));
    }
}
