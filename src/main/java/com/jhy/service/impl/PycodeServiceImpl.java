package com.jhy.service.impl;

import com.jhy.dao.PycodeMapper;
import com.jhy.service.PycodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Auther: Raytine
 * @Date: 2018/7/15 19:29
 * @Description:
 */
@Service
public class PycodeServiceImpl implements PycodeService{

    @Autowired
    private PycodeMapper pycodeMapper;


    @Override
    public List<Map<String, Object>> getCode() {
        return pycodeMapper.getCode();
    }

    @Override
    public List<Map<String, Object>> getCode1(int code) {
        return pycodeMapper.getCode1(code);
    }
}
