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

    <title>combobox_ajax</title>

    <link rel="stylesheet" type="text/css" href="../jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript" src="../jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript" src="../jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="../js/common.js"></script>
</head>
<body>
<h1>级联下拉框combobox_ajax</h1>

<div id="search_div">
    <table class="oilist-search-table">
        <tr>
            <td>机构简称：</td>
            <td><input id="search_abbreviation" style="width: 80px"></td>

            <td class="left">省:</td>
            <td><select class="easyui-combobox" name="contact.province"  id="province" style="width: 80px;" >
                <option value="全部">全部</option>
            </select></td>
            <td class="left">市:</td>
            <td><input  class="easyui-combobox" name="contact.city" id="city" style="width: 80px;"></td>
            <td class="left">县区:</td>
            <td><input  class="easyui-combobox" name="contact.county"  id="county" style="width: 80px;" ></td>

            <td colspan="2" style="text-align: left;"><input type="button" value="查询" class="subbtn" id="search_btn"></td>
        </tr>
    </table>
</div>


</body>

<script type="text/javascript">

    var basePath='<%=basePath%>';

    var provinceSelect = $('#province');
    var province_sign = 0;

    var citySelect = $("#city");
    var city_sign = 0;

    var countySelect = $("#county");
    var county_sign = 0;

    $(function(){
        provinceSelect.combobox({
            valueField : 'id',
            textField : 'name',
            url : basePath + "/getCode.do",
            editable : false,
            onLoadSuccess: function() {//当下拉框加载完毕时触发
                if(province_sign == 0) {//因为需要手动添加一个‘请选择’选项,所以需要调用‘loadData’方法,而此方法也会触发onLoadSuccess
                    // 回调函数,为了防止无限死循环,故使用此变量控制。
                    var data = $(this).combobox('getData');//获取远程加载来的数据
                    data.unshift({'id':'-1','name':'请选择'});//给远程加载的数据前置添加一个‘请选择’,字段id定义为‘-1’用于默认选择
                    province_sign++;
                    provinceSelect.combobox("loadData", data);//重新加载数据
                    provinceSelect.combobox('select','-1');//选中添加的默认选项
                }
            },
            onSelect : function(rec) {//当我们选择一个下拉框数据时应该做以下事情
                //将此下拉框下面所有的级联下拉框的控制变量初始化,否则再次选择时不会触发添加‘请选择’功能
                province_sign = 0;
                city_sign = 0;

                var url = basePath + "getCodea/" + rec.id;
                citySelect.combobox('reload', url);//将于本下拉框直接相关的级联下拉框数据重载data:data1,
            }
        });

        citySelect.combobox({
            valueField : 'id',
            textField : 'name',
            editable : false,
            onLoadSuccess: function() {
                if(city_sign == 0) {
                    var data = $(this).combobox('getData');
                    data.unshift({'id':'-1','name':'请选择'});
                    city_sign++;
                    citySelect.combobox("loadData", data);
                    citySelect.combobox('select','-1');
                }
            },
            onSelect : function(rec) {
                county_sign = 0;
                gradeItem_sign = 0;
                var url = basePath + "getCodea/" + rec.id;
                countySelect.combobox('reload', url);
            }
        });

        countySelect.combobox({
            valueField : 'id',
            textField : 'name',
            editable : false,
            onLoadSuccess: function() {
                if(county_sign == 0) {
                    var data = $(this).combobox('getData');
                    data.unshift({'id':'-1','name':'请选择'});
                    county_sign++;
                    countySelect.combobox("loadData", data);
                    countySelect.combobox('select','-1');
                }
            }
        });



    });
</script>
</html>