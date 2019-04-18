package com.jhy.controller.easyUI;

import com.alibaba.fastjson.JSONObject;
import com.jhy.service.PycodeService;
import com.jhy.service.RoleService;
import com.jhy.service.UserService;
import com.jhy.util.Page;
import com.jhy.util.SFTPUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * @Auther: Raytine
 * @Date: 2018/7/11 20:54
 * @Description:
 */
@Controller
@Slf4j
public class EasyUIController {

    private static final String FAR_SERVICE_DIR = "http://106.13.7.126:22/usr/upload";//远程服务器接受文件的路由
    private static final long yourMaxRequestSize = 10000000;



    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Autowired
    private PycodeService pycodeService;


    @RequestMapping("/combobox")
    public String index(Model model){
        return "/combobox_ajax";
    }


    @RequestMapping("/comboboxAjaxa")
    public ModelAndView comboboxAjax(HttpServletRequest req, HttpServletResponse resp)throws Exception{
        ModelAndView view = new ModelAndView();
        view.setViewName("combobox_ajax");  // 指定视图的名称
        return view;
    }

    @RequestMapping("/getPageList")
    public void getPageList(Integer page, Integer rows, HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Page<Map<String, Object>> tmpPage = new Page<Map<String, Object>>();
            tmpPage.setRowNumber(rows);
            tmpPage.setPage(page);
            tmpPage.setParams(WebUtils.getParametersStartingWith(request, "params."));
            tmpPage.setHaveCountSql(true);
            tmpPage.getParams().put("offset", tmpPage.getRowOffset());
            tmpPage.getParams().put("pageSize", tmpPage.getRowNumber());
            userService.getPageList(tmpPage);

            map.put("total", tmpPage.getTotalRecord());
            map.put("rows", tmpPage.getData());
        } catch (Exception e) {
            log.error("FQBOrganizationInfoController.getPageList : error ", e);
            map.put("rows", new ArrayList<Object>());
            map.put("total", 0);
        }
        writeResponse(response, JSONObject.toJSONString(map));
    }

    @RequestMapping("/getCode")
    public void getCode( HttpServletRequest request, HttpServletResponse response){
        List<Map<String, Object>> map = null;
        try {
            map = pycodeService.getCode();

        } catch (Exception e) {
            log.error("FQBOrganizationInfoController.getPageList : error ", e);

        }
        writeResponse(response, JSONObject.toJSONString(map));
    }

    @RequestMapping(value = "/getCodea/{id}")
    public void getCodea( @PathVariable Integer id, HttpServletResponse response){
        List<Map<String, Object>> map = null;
        try {
            map = pycodeService.getCode1(id);

        } catch (Exception e) {
            log.error("FQBOrganizationInfoController.getPageList : error ", e);

        }
        writeResponse(response, JSONObject.toJSONString(map));
    }

    /**
     * 返回数据流
     * @param response
     * @param resp
     * @throws Exception
     */
    public void writeResponse(HttpServletResponse response, String resp){
        PrintWriter writer = null;
        try {
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            writer = response.getWriter();
            writer.write(resp);
            writer.flush();
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error("response error");
        } finally {
            if(writer != null){
                writer.close();
            }
        }
    }
}
