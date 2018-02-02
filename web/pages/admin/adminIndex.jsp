<%--
  Created by IntelliJ IDEA.
  User: cwll
  Date: 2018/1/30
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>管理员中心</title>
    <link href="css/touregister.css" rel="stylesheet">
    <script src="js/jquery-3.1.0.js"></script>
</head>
<nav  class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="pages/admin/adminIndex.jsp">管理员中心</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="test.jsp">测试</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        招聘中心
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="pages/admin/publishRecruit.jsp">发布招聘</a></li>
                        <li><a href="adminRecruit.show">浏览招聘</a></li>
                        <%--<li><a href="#">修改招聘</a></li>--%>
                        <li class="divider"></li>
                        <li><a href="adminShowInvitationResume">查看面试邀请</a></li>
                        <%--<li class="divider"></li>--%>
                        <%--<li><a href=""></a></li>--%>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        员工中心
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="employee.Show">查看员工信息</a></li>
                        <li><a href="adminShowCheckClocks">查看出勤信息</a></li>
                        <%--<li><a href="#">修改招聘</a></li>--%>
                        <li><a href="addRwandph">添加奖惩</a></li>
                        <li class="divider"></li>
                        <li><a href="showRwandph">查看奖惩</a></li>
                        <li><a href="adminShowDissent">查看回馈信息</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        薪资管理
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="salarySet.show">薪资结算</a></li>
                        <%--<li><a href="">查看惩罚记录</a></li>--%>
                        <%--<li><a href="#">修改招聘</a></li>--%>
                        <%--<li><a href="">查看奖励记录</a></li>--%>
                        <%--<li class="divider"></li>--%>
                        <%--<li><a href="#">查看回馈</a></li>--%>
                        <%--<li class="#"><a href="showRwandph">查看历史薪资</a></li>--%>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        培训中心
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="page/admin/addTrain.jsp">新增培训班</a></li>
                        <li><a href="employeeToTrain.Show">新增培训安排</a></li>
                        <%--<li><a href="showTrainList">查看员工信息</a></li>--%>
                        <li><a href="showTrains">查看培训</a></li>
                        <%--<li><a href="#">修改招聘</a></li>--%>
                        <%--<li class="divider"></li>--%>
                        <%--<li><a href="#">查看培训历史</a></li>--%>
                        <%--<li class="divider"></li>--%>
                        <%--<li><a href=""></a></li>--%>
                    </ul>
                </li>

                <li><a href="page/admin/deptAndPost.jsp">部门与岗位</a></li>

                <li>${requestScope.info}</li>
                <li><a href="loginOut">退出</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div id="myCarousel" class="carousel slide" style="margin: 10px 200px ">
        <!-- 轮播（Carousel）指标 -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <!-- 轮播（Carousel）项目 -->
        <div class="carousel-inner" style="height: 300px" >
            <div class="item active">
                <img src="images/Ti1.png"  alt="First slide">
            </div>
            <div class="item">
                <img src="images/Ti2.png"  alt="Second slide">
            </div>
            <div class="item">
                <img src="images/Ti3.png" alt="Third slide">
            </div>
        </div>
        <!-- 轮播（Carousel）导航 -->
        <a class="carousel-control left" href="#myCarousel"
           data-slide="prev">&lsaquo;</a>
        <a class="carousel-control right" href="#myCarousel"
           data-slide="next">&rsaquo;</a>
    </div>
    <%--<div class="row" >

        <div class="col-xs-6 col-sm-10"
             style="background-color: #dedef8;box-shadow:
         inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
            <p>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do
                eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
                enim ad minim veniam, quis nostrud exercitation ullamco laboris
                nisi ut aliquip ex ea commodo consequat.
            </p>
            <img src="images/Ti4.png">
            <p>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do
                eiusmod tempor incididunt ut.
            </p>
            <img src="images/Ti5.png">
        </div>--%>
        <div class="clearfix visible-xs"></div>
        <div class="col-xs-6 col-sm-2"
             style="background-color: #dedef8;box-shadow:
         inset 1px -1px 1px #444, inset -1px 1px 1px #444;">

            <h1>13</h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do
                eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
                enim ad minim
            </p>
            <img src="images/Ti6.png">
        </div>
    </div>
</div>
</html>
