<%--
  Created by IntelliJ IDEA.
  User: cwll
  Date: 2018/1/26
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>人力资源管理系统</title>
    <base href="http://localhost:8080/HRMS/">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="../js/jquery-3.1.0.js"></script>
    <script src="jquery/bootstrap.min.js"></script>
</head>
<body background="image/index.jpg" style="background-size: 100% auto">

<form action="login.do" method="post" style="margin:200px  0px 0px 400px;border-radius:10px;border: 1px solid #3e8f3e;width: 400px;padding: 10px;background-color: #31b0d5"  class="form-horizontal" role="form">
    <div class="form-group">
        <label for="firstname" class="col-sm-3 control-label"> 用户名：</label>
        <div class="col-sm-9">
            <input name="name" type="text"  class="form-control" id="firstname" placeholder="请输入名字">
        </div>
    </div>
    <div class="form-group">
        <label for="password" class="col-sm-3 control-label"> 密码：</label>
        <div class="col-sm-9">
            <input name="password" type="password" class="form-control" id="password" placeholder="请输入密码">
        </div>
    </div>


    <div class="form-group">
        <label for="one" class="col-sm-3 control-label"> </label>
        <div class="col-sm-9" id="one">
            <input type="radio" name="identity" value="0" checked>游客登录&nbsp;
            <input type="radio" name="identity" value="1">员工登录&nbsp;
            <input type="radio" name="identity" value="3">管理员
        </div>
    </div>
    <div class="form-group">
        <label for="two" class="col-sm-2 control-label"> </label>
        <div class="col-sm-10">
            ${requestScope.info}<br>
            <input id="two" class="btn btn-default col-sm-10" type="submit" value="登录">
        </div>
    </div>
    <div class="form-group">
        <label for="eee" class="col-sm-1 control-label"> </label>
        <div class="col-sm-11">
            <a style="color: red">忘记密码?</a><a id="eee" style="color:red;margin-left: 140px" href="page/tourist/register.jsp">注册</a>
        </div>
    </div>
</form>
</body>
</html>
