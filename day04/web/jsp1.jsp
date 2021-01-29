<%--
  Created by IntelliJ IDEA.
  User: bonnie
  Date: 2021/1/29
  Time: 9:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>支持普通html所包含的元素</h1>
    <!-- html注释 -->
    <%-- JSP注释 --%>
    <%-- <% %>: 普通Java脚本
         <%= %>: 普通输出脚本, 只能填表达式
         <%! %>: Java脚本
         <%@ %>: JSP指令
    --%>
    <%
        // Java注释, 支持Java基础语法 代码
        int a = 1;
        System.out.println(a+1);
    %>
    <br>
    <%=a+10 %>
    <%! int b = 2;
        public void method1() {

        }
    %>
</body>
</html>
