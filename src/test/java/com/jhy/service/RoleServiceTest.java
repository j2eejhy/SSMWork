package com.jhy.service;

import com.jhy.dao.RoleMapper;
import com.jhy.dao.UserMapper;
import com.jhy.pojo.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: Raytine
 * @Date: 2018/7/11 00:38
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
/** 注入相关的配置文件：可以写入多个配置文件 **/
@ContextConfiguration(locations={"classpath:spring-*.xml"})
public class RoleServiceTest {


}