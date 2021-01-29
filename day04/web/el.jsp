<%--
  Created by IntelliJ IDEA.
  User: bonnie
  Date: 2021/1/29
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>EL表达式</title>
</head>
<body>
    <%
        // 模拟向域中存储数据
        application.setAttribute("name", "zhangsan");
    %>
    1+1 = ${1+1 } <br>
    1 > 2 = ${1> 2 } <br>
    <%-- request.getParameter("id") --%>
    id: ${param.id } <br>
    <%-- request.getParameterValues("hobby") --%>
    hobby: ${paramValues.hobby} <br>
    hobby: ${paramValues.hobby[0]}  -- ${paramValues.hobby[1]} <br>
    <%-- request.getHeader("user-agent") --%>
    user-agent: ${header["user-agent"]} <br>
    host: ${header.host} -- ${header["host"]} <br>

    applicationScope: ${applicationScope.name}<br>
    <%-- 取代pageContext.getRequest()   getSession()   getResponse() --%>
    <%-- 取代pageContext.getRequest().getContextPath() --%>
    ${pageContext.request.contextPath} <br>

    <%-- 取代pageContext.findAttribute("name") --%>
    ${name}<br>
</body>
</html>
