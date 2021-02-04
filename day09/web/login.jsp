<%--
  Created by IntelliJ IDEA.
  User: bonnie
  Date: 2021/2/4
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>管理员登录</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.validate.min.js"></script>
    <script type="text/javascript">
        function refreshCode() {
            $("#vcode").prop("src", "${pageContext.request.contextPath}/CheckImgServlet?random"+Math.random());
        }
        // 自定义校验规则
        $.validator.addMethod("checkCode",function(value,element,params){
            var isSuccess = false;
            // 需求: 获得到输入的验证码内容, 和真正的验证码对比, 对比成功返回true, 对比失败返回false
            $.ajax({
                url: "${pageContext.request.contextPath}/CheckCodeServlet",
                data: {
                    code: value
                },
                success: function(data) { // {"isSuccess": true}
                    // data.isSuccess -> true -> 校验通过, 整体校验通过
                    // data.isSuccess -> false -> 验证码不对, 整体校验不通过
                    isSuccess = data.isSuccess;
                },
                dataType: "json",
                async: false, // 必须用同步
                method: "GET"
            });
            return isSuccess;
        })
        $(function() {
            // 添加表单的验证
            $("#loginForm").validate({
                rules: {
                    verifycode: {
                        required: true,
                        checkCode: true
                    }
                },
                messages: {
                    verifycode: {
                        required: "请输入验证码",
                        checkCode: "验证码错误"
                    }
                }
            });
        })
    </script>
</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">管理员登录</h3>
    <form id="loginForm" action="login" method="post">
        <div class="form-group">
            <label for="user">用户名：</label>
            <input type="text" name="user" class="form-control" id="user" placeholder="请输入用户名"/>
        </div>

        <div class="form-group">
            <label for="password">密码：</label>
            <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
        </div>

        <div class="form-inline">
            <label for="vcode">验证码：</label>
            <input type="text" name="verifycode" class="form-control" id="verifycode" placeholder="请输入验证码" style="width: 120px;"/>
            <a href="javascript:refreshCode()"><img src="${pageContext.request.contextPath}/CheckImgServlet" title="看不清点击刷新" id="vcode"/></a>
        </div>
        <div>
            <label for="verifycode" class="error"></label>
        </div>
        <hr/>
        <div class="form-group" style="text-align: center;">
            <input class="btn btn btn-primary" type="submit" value="登录">
        </div>
    </form>

    <!-- 出错显示的信息框 -->
    <div class="alert alert-warning alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" >
            <span>&times;</span></button>
        <strong>登录失败!</strong>
    </div>
</div>
</body>
</html>
