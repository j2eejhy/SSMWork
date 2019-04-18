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

<div id="search_div">
    <div id="page-wrapper">
        <div id="page-inner">


            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">
                        HttpURLConnection <small>HttpURLConnection</small>
                    </h1>
                </div>
            </div>
            <!-- /. ROW  -->

            <form class="form-horizontal" name="upform" action="uploadSftp" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="sourceModule" class="col-sm-2 control-label">上传文件:</label>
                    <div class="col-sm-10">
                        <input type="file" name="file"/><br/>
                        <input type="submit" value="提交" /><br/>
                    </div>
                </div>
            </form>
            <!-- /. ROW  -->
        </div>
        <!-- /. PAGE INNER  -->
    </div>

</div>


</body>

<script type="text/javascript">
    $(function(){

    })

</script>
</html>