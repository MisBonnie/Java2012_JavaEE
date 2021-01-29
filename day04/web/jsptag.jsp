<%--
  Created by IntelliJ IDEA.
  User: bonnie
  Date: 2021/1/29
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp动态标签</title>
</head>
<body>
    <%-- 转发, 取代的request.getRequestDispatcher("jsp1.jsp").forward(req, resp) --%>
    <jsp:forward page="jsp1.jsp"></jsp:forward>
    <%-- 动态包含页面 --%>
<%--    <jsp:include page="jsp1.jsp"></jsp:include>--%>
</body>
</html>
