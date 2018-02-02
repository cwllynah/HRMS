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
    <title>招聘发布</title>
    <link href="css/touregister.css" rel="stylesheet">
    <script src="js/jquery-3.1.0.js"></script>
    <script>
        var parserDate = function parserDate (date) {
            var t = Date.parse(date);
            if (!isNaN(t)) {
                return new Date(Date.parse(date.replace(/-/g, "/")));
            } else {
                return new Date();
            }
        };

        function  DateUp() {
            $("#granttime").val(parserDate($("#granttime").val()));
            return test();
        }



    </script>
    <script>
        $(
//            加载部门列表
            $.ajax({
                type:"Post",
                url:"listDepts",
                success:function (data) {
                    data=JSON.parse(data);
                    var dept=$("#dept").html();
                    for (var i = 0; i < data.length; i++) {
                        var obj = data[i];
                        dept+="<option value="+obj.id+">"+obj.name+"</option>"
                    }
                    $("#dept").html(dept);
//                    二级联动 加载部门对应岗位
                    $("#dept").change(function () {
//                        alert("ok");
                        $.ajax({
                            type:"POST",
                            url:"listPostByDeptId",
                            data:"deptId="+$("#dept").val(),
                            success:function (data1) {
                                data1=JSON.parse(data1);
                                var job="<option value='-1'>--请选择--</option>";
                                for (var i = 0; i < data1.length; i++) {
                                    var obj = data1[i];
                                    job=job+"<option value="+obj.pid+">"+obj.pname+"</option>"
                                }
                                $("#post").html(job);
                            }
                        });
                    })
                }
            })
        )
    </script>
    <script>
        function test() {
            if($("#address").val()==null||$("#post").val()==null||$("#post").val()<1||$("#name").val()==null
                ||$("#granttime").val()==null||$("#description").val()==null){
                alert("请填写完整！");
                return false;
            }else return true;
        }
    </script>
</head>

<body background="images/touregister.jpg">
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
                        <li><a href="pages/admin/addTrain.jsp">新增培训班</a></li>
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

                <li><a href="pages/admin/deptAndPost.jsp">部门与岗位</a></li>

                <li>${requestScope.info}</li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <jsp:useBean id="time" type="java.io.Serializable" beanName="java.util.Date"/>
    ${info}
    <form role="form" action="punishRecruit.do" method="post" onsubmit="return DateUp()">
        <div class="form-group">
            <label for="address">地址</label>
            <input type="text" name="address" class="form-control" id="address" placeholder="请输入地址">
        </div>
        <div class="form-group">
            <label for="dept">选择部门：</label>
            <select id="dept">
                <option value="-1">--请选择--</option>
            </select>
        </div>
        <div class="form-group">
            <label for="post">选择职位：</label>
            <select name="pid" id="post">
                <option value="-1">--请选择--</option>
            </select>
        </div>
        <div class="form-group">
            <label for="name">名字</label>
            <input type="text" name="name" class="form-control" id="name" placeholder="请输入名字">
        </div>
        <div class="form-group">
            <label for="granttime">招聘时间：</label>
            <input type="date"  name="granttime"  class="form-control" id="granttime" >
        </div>
        <div class="form-group">
            <label for="description">面试介绍：</label>
            <input type="text" name="description" class="form-control" id="description" placeholder="请输入名字">
        </div>
        <div class="form-group">
            <input name="state" value="0" hidden>
            发布时间： <fmt:formatDate value='${time}'  pattern='yyyy-MM-dd'/>
            <input name="createtime"   type="date" hidden value="${time}">

            <br>
            <button class="btn btn-info" type="submit" >发布</button>
        </div>
    </form>

</div>
</body>
</html>

