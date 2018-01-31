<%--
  Created by IntelliJ IDEA.
  User: cwll
  Date: 2018/1/30
  Time: 15:11
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
    <title>历史招聘</title>
    <link href="css/touregister.css" rel="stylesheet">
    <script src="js/jquery-3.1.0.js"></script>
</head>
<body >
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
                        <li><a href="salarySet">薪资结算</a></li>
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
                        <li><a href="pages/admin/addTrain.jsp">新增培训班</a></li>
                        <li><a href="employeeToTrain">新增培训安排</a></li>
                        <%--<li><a href="showTrainList">查看员工信息</a></li>--%>
                        <li><a href="showTrains">查看培训</a></li>
                        <%--<li><a href="#">修改招聘</a></li>--%>
                        <%--<li class="divider"></li>--%>
                        <%--<li><a href="#">查看培训历史</a></li>--%>
                        <%--<li class="divider"></li>--%>
                        <%--<li><a href=""></a></li>--%>
                    </ul>
                </li>

                <li><a href="pages/admin/deptAndPost.jsp">部门与岗位</a></li>

                <li>${requestScope.info}</li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <ul>
        <c:forEach items="${sessionScope.recruits}" var="recruit">
            <li>
                <div>
                    <table class="table">
                        <caption>招聘信息</caption>
                        <thead>
                        <tr>
                            <th><a href="#">查看更多(没写)</a></th>
                            <th><a  href="resumeByRecruitId?recruitId=${recruit.id}">查看简历投递信息</a></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>地址</td>
                            <td>${recruit.address}</td>
                        </tr>
                        <tr>
                            <td>职位</td>
                            <td>${recruit.postid.pname}</td>
                        </tr>
                        <tr>
                            <td>名字</td>
                            <td>${recruit.name}</td>
                        </tr>
                        <tr>
                            <td>时间</td>
                            <td>
                                <fmt:formatDate value='${recruit.granttime}'  pattern='yyyy-MM-dd'/>
                            </td>
                        </tr>
                        <tr>
                            <td>招聘介绍</td>
                            <td>${recruit.description}</td>
                        </tr>
                        <tr>
                            <td>状态</td>
                            <td>${recruit.state}</td>
                        </tr>
                        <tr>
                            <td>创建时间</td>
                            <td>
                                <fmt:formatDate value='${recruit.createtime}'  pattern='yyyy-MM-dd'/>
                            </td>
                        </tr>
                        <tr>
                            <td>面试官</td>
                            <td>${recruit.interviewer}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </li>
        </c:forEach>
    </ul>
</div>
</body>
</html>

