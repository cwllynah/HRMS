<%--
  Created by IntelliJ IDEA.
  User: cwll
  Date: 2018/1/29
  Time: 10:01
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
    <title>注册</title>
    <link href="css/touregister.css" rel="stylesheet">
    <script src="js/jquery-3.1.0.js"></script>
    <script>
        function nameExit() {
            var flag=true;
            $.ajax({
                type:"post",
                url:"nameExit",
                data:"name="+$("#name").val(),
                success:function (data) {

                    if(data.trim()=='OK'){
                        $("#span_name").html("");
                        return true;
                    }else {
                        $("#span_name").html("用户名已经被使用");
                    }
                    flag=false;
                    return false;
                }
            });
            return flag;
        }

        function check_name() {
            var name=$("#name").val();
            var sp_check_name=$("#span_name");
            var reg=new RegExp(/^[a-z0-9_-]{3,16}$/);
            if(reg.test(name)){
                sp_check_name.html("");
                return nameExit();
            }
            sp_check_name.html("用户名输入不正确");
            return false;
        }

        function check_phone() {
            var phone= $("#phone").val();
            var sp_check_phone= $("#span_phone");
            var reg=new RegExp(/^[0-9]{11}$/);
            if(reg.test(phone)){
                sp_check_phone.html("");
                return true;
            }
            sp_check_phone.html("用户名输入不正确");
            return false;
        }
        function check_age() {
//            年龄必须有1-9组成
            var  reg=/^([1-9])+([0-9])$/;
            var  age= $("#age").val();
            var num= age.search(reg);
            var check_age=$("#span_age");
            if(num==-1){
                check_age.html("请输入正确的年龄");
                return  false;
            }
            check_age.html("");
            return  true;

        }
        function check_email() {
            var email= $("#email").val();
            var sp_check_email=$("#span_email");
            var reg=new RegExp(/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/);
            if(reg.test(email)){
                sp_check_email.html("");
                return true;
            }
            sp_check_email.html("用户名输入不正确");
            return false;
        }
        function check_password() {
            var reg=/^[a-z0-9_-]{6,18}$/;
            var  password=$("#password").val();

            var  reg1=new RegExp("[a-z0-9_-]{6,18}");
            var flag=reg1.test(password);
            if(flag){

                $("#span_password").html("");
                return flag;
            }
            $("#span_password").html("密码格式不正确");
            return flag;
        }
        function check_next_password(){
            var  password=$("#password").val();
            var  next_password=$("#password1").val();
            if (!(password.length!=0&&next_password==password)){
                $("#span_password1").html("两次输入密码不一致");
                return false;
            }else{
                $("#span_password1").html("");
                return true;
            }
        }
        function check() {
            return check_name()&&check_phone()&&check_age()&&check_email()&&check_password()&&check_next_password();

        }
    </script>
</head>
<body background="images/a0129.jpg">
<div class="container">
    <form style="padding: 40px 10px" action="register" onsubmit="return check()" method="post"  class="form-horizontal" role="form">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">姓名：</label>
            <div class="col-sm-10">
                <input name="name" id="name" onblur="check_name()">
                <span id="span_name" style="color: red"></span>
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">密码：</label>
            <div class="col-sm-10">
                <input name="password" id="password" onblur="check_password()">
                <span id="span_password" style="color: red"></span>
            </div>
        </div>

        <div class="form-group">
            <label for="password1" class="col-sm-2 control-label">确认密码：</label>
            <div class="col-sm-10">
                <input name="password1" id="password1" onblur="check_next_password()">
                <span id="span_password1" style="color: red"></span>
            </div>
        </div>

        <div class="form-group">
            <label for="sex" class="col-sm-2 control-label">性别：</label>
            <div class="col-sm-10">
                <select name="sex" id="sex">
                    <option value="man">男</option>
                    <option value="woman">女</option>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label for="age" class="col-sm-2 control-label">年龄：</label>
            <div class="col-sm-10">
                <input type="text" name="age" id="age" onblur="check_age()">
                <span id="span_age" style="color: red"></span>
            </div>
        </div>

        <div class="form-group">
            <label for="phone" class="col-sm-2 control-label">电话：</label>
            <div class="col-sm-10">
                <input type="text" name="phone" id="phone" onblur="check_phone()">
                <span id="span_phone" style="color: red"></span>
            </div>
        </div>

        <div class="form-group">
            <label for="phone" class="col-sm-2 control-label">邮箱：</label>
            <div class="col-sm-10">
                <input type="text" name="email" id="email" onblur="check_email()">
                <span id="span_email" style="color: red"></span>
            </div>
        </div>
        <div class="form-group">
            <label for="submit" class="col-sm-2 control-label"></label>
            <div class="col-sm-10">
                <input type="reset" class="btn btn-danger" value="重置">
                <input type="submit" class="btn btn-success" id="submit" value="注册">
            </div>
        </div>
    </form>
</div>
</body>
</html>
