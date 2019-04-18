<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    out.print(basePath);
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>bookInfo</title>

    <link rel="stylesheet" type="text/css"
          href="../jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="../jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript" src="../jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript"
            src="../jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="../jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript"
            src="../js/common.js"></script>
</head>
<body>
<h1>hello world</h1>
<div id="oilist_tabs" class="easyui-tabs" data-options="fit:true">
    <div title="个人基本信息"  >
        <!-- 显示列表 -->
        <table id="datagridTable" toolbar="#toolbar" style="width:600px;height:250px" pagination="true">
        </table>
    </div>
</div>


<div id="toolbar">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-add" onclick="newuser()"
       plain="true">添加</a> <a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-edit"
                              onclick="edituser()" plain="true">修改</a> <a href="javascript:void(0)" class="easyui-linkbutton"
                                                                          iconcls="icon-remove" plain="true">删除</a>
</div>

</body>

<script type="text/javascript">

    var basePath='<%=basePath%>';

    $(function(){
        $('#datagridTable').datagrid({
            fit		  : false,												// 填充整个页面
            url 	  : basePath + "/getPageList.do",	// 数据源
            fitColumns: true,												// 自动控制单元格宽度
            idFiled   : 'id',												// 主键字段
            pageSize  : 5,													// 初始分页数
            pageList  : [5,10,20,30],										// 设置页面数集合
            rownumbers: true,												// 行号
            singleSelect: true,												// 单选
            striped:true,
            pageNumber:1,
            columns   : [[													// 列数据

                {title:'机构简称',field:'user_name',align:'center'},
                {title:'机构名称',field:'role_name',align:'center'},
                {title:'机构类型',field:'user_password',align:'center'},
                {title:'登录用户名',field:'user_email',align:'center'},
                {title:'代理人姓名',field:'user_info',align:'center'},
                {title:'手机号码',field:'create_time',align:'center'},

            ]],
            toolbar : '#toolbar',
            // 对应放置查询DIV的ID
        });

        $('#datagridTable').datagrid('getPager').pagination({
            beforePageText: '第',//页数文本框前显示的汉字
            afterPageText: '页    共 {pages} 页',
            displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',
        });
    });
</script>
</html>