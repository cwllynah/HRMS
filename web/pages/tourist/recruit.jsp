<%--
  Created by IntelliJ IDEA.
  User: cwll
  Date: 2018/1/30
  Time: 15:07
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
    <title>招聘中心</title>
    <link href="css/touregister.css" rel="stylesheet">
    <script src="js/jquery-3.1.0.js"></script>
    <script>
        function test(recruit) {
            if(document.getElementById(recruit).value>0){
                return true;
            }
            alert("请选择简历");
            return false;
        }
    </script>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="pages/tourist/touristIndex.jsp">首页</a>
        </div>
        <div>
            <!--向左对齐-->
            <ul class="nav navbar-nav navbar-left">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        招聘中心
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="recruit">招聘</a></li>
                        <%--<li><a href="#">asdad</a></li>--%>
                        <%--<li><a href="#">Jasper Report</a></li>--%>
                        <%--<li class="divider"></li>--%>
                        <%--<li><a href="#">分离的链接</a></li>--%>
                        <%--<li class="divider"></li>--%>
                        <%--<li><a href="#">另一个分离的链接</a></li>--%>
                    </ul>
                </li>
            </ul>
            <%--<p class="navbar-text navbar-text">向左对齐-文本</p>--%>
            <%--<button type="button" class="btn btn-default navbar-btn">--%>
            <%--导航栏按钮--%>
            <%--</button>--%>

            <!--向右对齐-->
            <form class="navbar-form navbar-right" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">提交按钮</button>
            </form>

            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        欢迎你，${sessionScope.user.name} <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="resume">我的简历</a></li>
                        <li><a href="showResumeState">查看投递状态</a></li>
                        <%--<li><a href="#">Jasper Report</a></li>--%>
                        <%--<li class="divider"></li>--%>
                        <%--<li><a href="#">分离的链接</a></li>--%>
                        <li class="divider"></li>
                        <li><a href="loginOut">退出</a></li>
                    </ul>
                </li>
            </ul>
            <%--<form class="navbar-form navbar-right" role="search">--%>
            <%--<button type="submit" class="btn btn-default">--%>
            <%--向右对齐-提交按钮--%>
            <%--</button>--%>
            <%--</form>--%>
            <%--<p class="navbar-text navbar-right">向右对齐-文本</p>--%>
        </div>
    </div>
</nav>
<div class="container">
    ${sessionScope.info}
    <ul>
        <c:forEach items="${sessionScope.recruits}" var="recruit">
            <li>
                <div>
                    <table class="table">
                        <caption>基本的表格布局</caption>
                        <thead>
                        <tr>
                            <th colspan="2">
                                <form action="addRecruitToResume" method="get" onsubmit="return test(${recruit.id})">
                                    <input id="recruitId" hidden="hidden" name="recruitId" value="${recruit.id}">
                                    选择你的简历：
                                    <select name="resumeId" id="${recruit.id}">
                                        <option>--请选择--</option>
                                        <c:forEach items="${requestScope.resumes}" var="resume">
                                            <option value="${resume.id}"> ${resume.id}:${resume.createtime}</option>
                                        </c:forEach>
                                    </select>

                                    <input value="投递简历" type="submit">

                                </form>
                            </th>
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
                            <td> <fmt:formatDate value='${recruit.granttime}'  pattern='yyyy-MM-dd'/>
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
                            <td><fmt:formatDate value='${recruit.createtime}'  pattern='yyyy-MM-dd'/>
                            </td>
                        </tr>
                        <tr>
                                <%--<td>面试官</td>--%>
                                <%--<td>${recruit.interviewer}</td>--%>
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

