<%--
  Created by IntelliJ IDEA.
  User: cwll
  Date: 2018/1/29
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title></title>
</head>
<body background="images/a0129.jpg">
    管理员登录界面
</body>
</html>
