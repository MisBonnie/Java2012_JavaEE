<%--
  Created by IntelliJ IDEA.
  User: bonnie
  Date: 2021/1/29
  Time: 2:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="bean.User"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<html>
<head>
    <title>EL从域中取值</title>
</head>
<body>
    <% // 准备工作 - 向域中存值
        // 1.普通字符串
        request.setAttribute("str", "zhangsan");
        // 2.User对象
        User user1 = new User(1, "lucy", 24);
        request.setAttribute("user", user1);
        // 3.字符串集合
        List<String> strList = new ArrayList();
        strList.add("tom");
        strList.add("lucy");
        strList.add("jack");
        strList.add("rose");
        request.setAttribute("strList", strList);
        // 4.User集合
        List<User> userList = new ArrayList();
        userList.add(new User(1, "张无忌", 23));
        userList.add(new User(2, "张三丰", 90));
        userList.add(new User(3, "张翠山", 40));
        userList.add(new User(4, "谢逊", 50));
        request.setAttribute("userList", userList);

        // 5.String类型的Map集合
        Map<String, String> strMap = new HashMap();
        strMap.put("name", "张三");
        strMap.put("age", "18");
        strMap.put("sex", "gender");
        request.setAttribute("strMap", strMap);

    %>

    <%-- 使用EL从域中取值, 并操作 --%>
    ${str} <br>
    ${user } -- ${user.age } -- ${user.name} <br>
    ${strList } -- ${strList[0]} -- ${strList[1]} <br>
    ${userList} -- ${userList[2]} -- ${userList[2].name} <br>
    ${strMap} -- ${strMap.name } -- ${strMap.age } -- ${strMap.sex } <br>

</body>
</html>
