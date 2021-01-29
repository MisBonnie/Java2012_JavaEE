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
        pageContext.getRequest();
        pageContext.getResponse();

    %>

    <%  // 向自己的域中存数据
        pageContext.setAttribute("name", "zhangsan");

        String name = (String) pageContext.getAttribute("name");
        out.write(name);

        // 向其他域中存数据  PageContext.APPLICATION_SCOPE  PageContext.SESSION_SCOPE  PageContext.REQUEST_SCOPE
        pageContext.setAttribute("age", 18, PageContext.APPLICATION_SCOPE);

        pageContext.setAttribute("sex", '男', PageContext.REQUEST_SCOPE);


        pageContext.setAttribute("username", "张三", PageContext.PAGE_SCOPE);
        pageContext.setAttribute("username", "李四", PageContext.REQUEST_SCOPE);
        pageContext.setAttribute("username", "王五", PageContext.APPLICATION_SCOPE);

        // 转发
        request.getRequestDispatcher("/pageContext2.jsp").forward(request, response);
    %><br>
<%--    当前页面username :--%>
<%--    <%= pageContext.findAttribute("username")%>--%>
</body>
</html>
