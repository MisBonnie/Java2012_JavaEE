<%--
  Created by IntelliJ IDEA.
  User: bonnie
  Date: 2021/2/1
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
<%--    <base href="<%=basePath%>"/>--%>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>

    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改联系人</h3>
    <form action="${pageContext.request.contextPath}/UpdateUserInfoServlet" method="post">
        <input type="hidden" name="id" value="${userInfo.id}"/>
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name"
                   value="${userInfo.name}"
                   readonly="readonly" placeholder="请输入姓名" />
        </div>

        <div class="form-group">
            <label>性别：</label>
            <input type="radio" name="gender" value="男" ${userInfo.gender == '男'? 'checked':''} />男
            <input type="radio" name="gender" value="女" ${userInfo.gender == '女'? 'checked':''} />女
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age"  name="age"
                   value="${userInfo.age}"
                   placeholder="请输入年龄" />
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" class="form-control" >
                <option value="广东" ${userInfo.address == '广东'? 'selected':''}>广东</option>
                <option value="浙江" ${userInfo.address == '浙江'? 'selected':''}>浙江</option>
                <option value="山东" ${userInfo.address == '山东'? 'selected':''}>山东</option>
            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" name="qq" placeholder="请输入QQ号码"
                    value="${userInfo.qq}"
            />
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" class="form-control" name="email" placeholder="请输入邮箱地址"
                value="${userInfo.email}"
            />
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回"/>
        </div>
    </form>
</div>
</body>
</html>