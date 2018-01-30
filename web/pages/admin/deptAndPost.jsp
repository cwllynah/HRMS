<%--
  Created by IntelliJ IDEA.
  User: cwll
  Date: 2018/1/30
  Time: 13:50
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
    <title>增加部门</title>
    <link href="css/touregister.css" rel="stylesheet">
    <script src="js/jquery-3.1.0.js"></script>
    <script>
        $(
            $.ajax({
                type:"Post",
                url:"listDepts",
                success:function (data) {
                    data=JSON.parse(data);
//                    部门列表
                    var tr="";
                    for (var i = 0; i < data.length; i++) {
                        var dept = data[i];
                        tr=tr+"<tr>";
                        tr=tr+"<td><input name='dept' type='radio' onchange='listPost("+dept.id+")'></td>";
                        tr=tr+"<td>"+dept.id+"</td>";
                        tr=tr+"<td>"+dept.name+"</td>";


                        tr=tr+"<td>"+toDate(dept.createtime,"yyyy-MM-dd")+"</td>";
//                        tr=tr+"<td><button class='btn btn-default'>ajax显示岗位</button></td>";
                        tr=tr+"<td><a href='updateShowDeptById?deptId="+dept.id+"'>修改</a></td>";
                        tr=tr+"<td><a href='deleteDeptById?deptId="+dept.id+"'>删除</a></td>";
                        tr=tr+"</tr>"
                    }
                    $("#dept_body").html(tr);
                    return true;
                }
            })
        );
        Date.prototype.format = function(format) {
            /*
             * format="yyyy-MM-dd hh:mm:ss";
             */
            var o = {
                "M+" : this.getMonth() + 1,
                "d+" : this.getDate(),
                "h+" : this.getHours(),
                "m+" : this.getMinutes(),
                "s+" : this.getSeconds(),
                "q+" : Math.floor((this.getMonth() + 3) / 3),
                "S" : this.getMilliseconds()
            };
            if (/(y+)/.test(format)) {
                format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4- RegExp.$1.length));
            }
            for (var k in o) {
                if (new RegExp("(" + k + ")").test(format)){
                    format = format.replace(RegExp.$1, RegExp.$1.length == 1? o[k]:("00" + o[k]).substr(("" + o[k]).length));
                }
            }
            return format;

        };
        //转化JSON日期格式
        function toDate(objDate, format) {
            var date = new Date();
            date.setTime(objDate.time);
            date.setHours(objDate.hours);
            date.setMinutes(objDate.minutes);
            date.setSeconds(objDate.seconds);
            return date.format(format);

        }


        function listPost(deptId) {
            $("#selectDept").val(deptId);
            $.ajax({
                type:"POST",
                url:"listPostByDeptId",
                data:"deptId="+deptId,
                success:function (data1) {
                    data1=JSON.parse(data1);
                    var tr="";
                    for (var i = 0; i < data1.length; i++) {
                        var post = data1[i];
                        tr=tr+"<tr>";
                        tr=tr+"<td><input name='post' type='radio' onchange='listPost("+post.id+")'/>";
                        tr=tr+"<td>"+post.pid+"</td>";
                        tr=tr+"<td>"+post.pname+"</td>";
                        tr=tr+"<td>"+post.describe+"</td>";
                        tr=tr+"<td>"+toDate(post.createtime,"yyyy-MM-dd")+"</td>";
//                        tr=tr+"<td><button class='btn btn-default'>ajax显示岗位</button></td>";
                        tr=tr+"<td><a href='updateShowPostById?postId="+post.pid+"'>修改</a></td>";
                        tr=tr+"<td><a href='deletePostById?postId="+post.pid+"'>删除</a></td>";
                        tr=tr+"</tr>"
                    }
                    $("#post_body").html(tr);
                }
            })
        }
    </script>
</head>


<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="pages/admin/adminIndex.jsp">管理员中心</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="test.jsp">测试</a></li>
                <%--<li><a href="#">saa</a></li>--%>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        招聘中心
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="page/admin/publishRecruit.jsp">发布招聘</a></li>
                        <li><a href="adminRecruit.show">浏览招聘</a></li>
                        <%--<li><a href="#">修改招聘</a></li>--%>
                        <li class="divider"></li>
                        <li><a href="adminShowInvitationResume">查看面试邀请</a></li>
                        <li class="divider"></li>
                        <li><a href=""></a></li>
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
                        <li class="#"><a href="showRwandph">查看奖惩</a></li>
                        <li><a href="#">查看回馈信息</a></li>
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
                        <li><a href="showTrainList">查看员工信息</a></li>
                        <li><a href="#">查看培训进度</a></li>
                        <%--<li><a href="#">修改招聘</a></li>--%>
                        <li class="divider"></li>
                        <li><a href="#">查看培训历史</a></li>
                        <li class="divider"></li>
                        <li><a href=""></a></li>
                    </ul>
                </li>

                <li><a href="page/admin/deptAndPost.jsp">部门与岗位</a></li>

                <li>${requestScope.info}</li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <table class="table table-hover">
        <caption>
            部门信息表
            ${info}
        </caption>
        <thead>
        <th></th>
        <th>部门编号</th>
        <th>部门名称</th>
        <th>部门创建时间</th>
        <th>修改部门</th>
        <th>删除部门</th>
        </thead>
        <tbody id="dept_body">
        <tr >
            <td><input name="dept" type="radio"> </td>
            <td>1</td>
            <td>名称</td>
            <td>时间</td>
            <%--<td>--%>
            <%--<button>ajax显示岗位</button>--%>
            <%--</td>--%>
            <td>
                <button class="btn btn-info" class="btn btn-info">修改</button>
            </td>
            <td>
                <button   class="btn btn-danger">删除</button>
            </td>
        </tr>
        </tbody>
        <tfoot>
        <tr>
            <td>增加部门</td>
            <td colspan="5">
                <form action="addDept.do">
                    <input type="text" name="name" id="name" placeholder="请输入部门名称">
                    || <button  type="submit" class="btn btn-default">提交</button>
                </form>
            </td>
        </tr>
        </tfoot>
    </table>

    <table class="table table-bordered">
        <caption>
            岗位信息表
        </caption>
        <thead>
        <th></th>
        <th>岗位编号</th>
        <th>岗位名称</th>
        <th>岗位介绍</th>
        <th>岗位创建时间</th>
        <%--<th>显示岗位下的员工</th>--%>
        <th>修改岗位</th>
        <th>删除岗位</th>
        </thead>
        <tbody id="post_body"></tbody>
        <tfoot>
        <tr>
            <td>增加岗位</td>
            <td colspan="5">
                <form action="addPost.do" method="post">
                    <input name="id" id="selectDept" readonly hidden>
                    <input type="text" name="pname" class="form-control" id="pname" placeholder="请输入岗位名称">
                    <div class="form-group">
                        <label for="describe">详情：</label>
                        <input type="text" name="describe" class="form-control" id="describe" placeholder="请输入详情">
                    </div>
                    <button type="submit" class="btn btn-default">提交</button>
                </form>
            </td>
        </tr>
        </tfoot>
    </table>
</div>
</body>
</html>
