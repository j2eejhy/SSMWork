package com.jhy.controller;

import com.alibaba.fastjson.JSONObject;
import com.jhy.dao.RoleMapper;
import com.jhy.pojo.Role;
import com.jhy.service.RoleService;
import com.jhy.service.UserService;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Raytine
 * @Date: 2018/7/9 22:44
 * @Description:
 */
@Controller
@Slf4j
public class Main {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    //@RequestMapping("/")
    public String index(Model model){
        Role role = roleService.selectById(1L);
        System.out.println(role.toString());
        String atts[] = new String [5];
        atts[0]="hello";
        atts[1]="this";
        atts[2]="is";
        atts[3]="a";
        atts[4]="pen";
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","jim");
        map.put("age","15");
        model.addAttribute("atts", atts);
        model.addAttribute("test", map);
        model.addAttribute("role", JSONObject.toJSONString(userService.select(1l)));
        return "ProductDetails";
    }

    @RequestMapping("/save")
    public String save(Role roles, Model model) throws Exception {
        log.info("inputProduct called");
        Role role = new Role();
        role.setId(roles.getId());
        role.setRoleName(roles.getRoleName());
        role.setEnabled(roles.getEnabled());

        model.addAttribute("role", role);
        return "ProductDetails";
    }

    @RequestMapping("/save/aa")
    public String get( Model model) throws Exception {
        log.info("inputProduct called");
        Role role = roleService.selectById(1L);
        model.addAttribute("role", role);
        return "ProductDetails";
    }
}
