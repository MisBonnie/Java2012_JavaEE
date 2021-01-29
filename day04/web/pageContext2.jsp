<%--
  Created by IntelliJ IDEA.
  User: bonnie
  Date: 2021/1/29
  Time: 11:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PageContext对象</title>
</head>
<body>

    <%
        // 从自己域中取数据
        Object name = pageContext.getAttribute("name");
        out.write("pageContext2: name = " + name + "");
    %>
    <br>
    <%
        // 从其他域中取数据
        Object sex = pageContext.getAttribute("sex", PageContext.REQUEST_SCOPE);
        out.write("pageContext2: sex =  " + sex + "");
    %>
    <br>
    <%
        // 从其他域中取数据
        Object age = pageContext.getAttribute("age", PageContext.APPLICATION_SCOPE);
        out.write("pageContext2: age =  " + age + "");
    %>

    <br>
    从四个域中, 由小到大的搜索对应的值, 直到找到为止 <br>
    pageContext2 页面中 username:
    <%=pageContext.findAttribute("username")%>

</body>
</html>
