<%--
  Created by IntelliJ IDEA.
  User: bonnie
  Date: 2021/1/29
  Time: 10:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" buffer="0kb" %>
<html>
<head>
    <title>out对象</title>
</head>
<body>
<%--  几种不同的输出方式  --%>
<%-- out.write(aaaa) --%>
aaaaaaa
<%-- out.print(bbb) --%>
<%="bbbbbbb"%>
<%
    response.getWriter().write("ccccccc");
%>
<%
    out.write("ddddddddd");
%>

</body>
</html>
