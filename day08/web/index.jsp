<%--
  Created by IntelliJ IDEA.
  User: bonnie
  Date: 2021/2/3
  Time: 9:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
</head>
<body>

<c:if test="${empty user}">
    <a href="${pageContext.request.contextPath}/login.jsp">登录</a>
    <a href="#">注册</a>
</c:if>
<c:if test="${!empty user}">
    ${user.name}
    <a href="#">退出</a>
</c:if>
</body>
</html>
