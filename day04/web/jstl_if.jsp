<%--
  Created by IntelliJ IDEA.
  User: bonnie
  Date: 2021/1/29
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>JSTL标签</title>
</head>
<body>
    <%-- 域中有没有user对象
         if标签 test: 判断条件
         没有对应的else标签

         ${empty 'haha'} 判断值是否为空, 如果是空,返回true, 不是空,返回false
         ${empty ''} 字符串长度是0的时候, 也会返回true, 认为是空
     --%>
    <%
        request.setAttribute("user", "");
    %>
    <c:if test="${empty user}">
        user 现在是空
    </c:if>
    <c:if test="${! empty user}">
        user 现在不是空
    </c:if>
    <br>
    <c:if test="${param.id == 1}">
        id 是 1
    </c:if>

    <c:if test="${param.id == null}">
        id 是null
    </c:if>
    <c:if test="${empty param.id}">
        id 是空
    </c:if>
</body>
</html>
