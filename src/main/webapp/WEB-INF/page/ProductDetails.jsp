<%--
  Created by IntelliJ IDEA.
  User: Raytine
  Date: 2018/7/10
  Time: 0:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
alert("${atts}");
    <h5>Details</h5>
    <c:forEach items="${atts}" var="item" >
        ${item}</br>
    </c:forEach>

    <c:forEach var="role" items="${role}" >
        <tr>
            <td> <c:out value="${role['user_info']}"/>
            </td>
        </tr>
    </c:forEach>

    <c:forEach var="role" items="${test}" >
    <tr>
        <td> <c:out value="${role.name}"/>
        </td>
    </tr>
    </c:forEach>

</body>

</html>
