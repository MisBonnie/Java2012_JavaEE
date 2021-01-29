<%--
  Created by IntelliJ IDEA.
  User: bonnie
  Date: 2021/1/29
  Time: 10:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" session="true" isELIgnored="false" errorPage="error.jsp" %>
<%@ page import="java.util.ArrayList, java.util.List" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>JSP指令</title>
</head>
<body>
    <h1>jsp2的内容</h1>
    <%  // 当前页面抛出异常, 会跳转到errorPage中
        //int a  = 1/0;
        List list = new ArrayList();
        if (list.size() > 0) { %>
            <table>
            <%
            for (int i = 0; i < list.size(); i++) {%>
                <tr> <td><%=list.get(i) %> </td></tr>
            <%
            }
            %>

            </table>
    <%
        }
    %>

    <%@ include file="jsp1.jsp"%>
<%--    <%@ taglib prefix="" uri="" %>--%>
</body>
</html>
