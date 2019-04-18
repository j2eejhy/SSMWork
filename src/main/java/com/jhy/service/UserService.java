package com.jhy.service;

import com.jhy.pojo.Role;
import com.jhy.util.Page;

import java.util.List;
import java.util.Map;

/**
 * @Auther: Raytine
 * @Date: 2018/7/11 01:12
 * @Description:
 */
public interface UserService {

    List<Map<String, Object>>select(Long userId);

    /**
     * 获取分页数据
     *
     * @param page
     */
    void getPageList(Page<Map<String, Object>> page);

}
