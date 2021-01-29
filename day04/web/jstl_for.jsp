<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.User" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: bonnie
  Date: 2021/1/29
  Time: 3:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>JSTL的forEach标签</title>
</head>
<body>
    <%-- for (int i = 0; i < 10; i++) { sout(i) } --%>
    <%-- begin: 从几开始
         end: 到几结束(包含)
         var: 临时变量, 将现在循环的值 i 存入到了page域中
     --%>
    <c:forEach begin="0" end="9" var="i">
        ${i} --
    </c:forEach>
    <br>
    <%
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
        // Map<String,User>
        // Map<String,List<User>>
        Map<String,List<User>> listMap = new HashMap<>();
        List<User> userList1 = new ArrayList<>();
        userList1.add(new User(1, "张无忌", 23));
        userList1.add(new User(2, "张三丰", 90));
        userList1.add(new User(3, "张翠山", 40));
        userList1.add(new User(4, "谢逊", 50));
        List<User> userList2 = new ArrayList<>();
        userList2.add(new User(1, "郭襄", 16));
        userList2.add(new User(2, "小龙女", 30));
        userList2.add(new User(3, "杨过", 28));
        listMap.put("倚天屠龙记", userList1);
        listMap.put("神雕侠侣", userList2);
        request.setAttribute("listMap", listMap);
    %>
    <%-- for(String str : strList) { sout(str) }  --%>
    <%-- items: 要遍历的集合或者数组
         var: 遍历出来的每一个元素, 将这个元素存入到了page域中 起名为xx
         varStatus: 记录当前遍历状态的对象, index-下标 count-序号
      --%>
    <c:forEach items="${strList}" var="str">
        ${str} --
    </c:forEach>
    <br>
    <c:forEach items="${userList}" var="user">
        ${user.id} -- ${user.name} -- ${user.age} <br>
    </c:forEach>
    <br>
    <%-- map遍历方式: 1.遍历key - keySet()
                     2.遍历value - values()
                     3.遍历entry - entrySet() -- JSTL标签的遍历方式
       --%>
    <c:forEach items="${strMap}" var="entry">
        ${entry.key} -- ${entry.value} <br>
    </c:forEach>
    <br>
    <c:forEach items="${listMap}" var="entry" varStatus="s">
        ${s.index} -- ${s.count} --
        ${entry.key} -- <br>
        ---- <c:forEach items="${entry.value}" var="user">
            ${user.id} -- ${user.name} -- ${user.age} <br>
        </c:forEach>
        <br>
    </c:forEach>
</body>
</html>
