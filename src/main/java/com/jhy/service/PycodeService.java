package com.jhy.service;

import java.util.List;
import java.util.Map;

/**
 * @Auther: Raytine
 * @Date: 2018/7/15 19:29
 * @Description:
 */
public interface PycodeService {

    List<Map<String, Object>> getCode();

    List<Map<String, Object>> getCode1(int code);
}
