<%--
  Created by IntelliJ IDEA.
  User: bonnie
  Date: 2021/1/30
  Time: 4:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <div style="float: left;">
    <form class="form-inline" action="${pageContext.request.contextPath}/FindPageUserInfoServlet">
        <div class="form-group">
            <label for="exampleInputName2">姓名</label>
            <input type="text" class="form-control" id="exampleInputName2" name="name" value="${param.name}">
        </div>
        <div class="form-group">
            <label for="exampleInputAddress2">籍贯</label>
            <input type="text" class="form-control" id="exampleInputAddress2" name="address" value="${param.address}" >
        </div>
        <div class="form-group">
            <label for="exampleInputEmail2">邮箱</label>
            <input type="text" class="form-control" id="exampleInputEmail2" name="email" value="${param.email}">
        </div>
        <button type="submit" class="btn btn-default">查询</button>
    </form>
    </div>
    <form action="${pageContext.request.contextPath}/DeleteSelectedServlet">
    <div style="float: right; margin-bottom: 10px">
        <a class="btn btn-primary" href="add.jsp">添加联系人</a>
        <button type="submit" class="btn btn-primary">删除选中</button>
    </div>
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox"/> </th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${pageBean.list}" var="userInfo" varStatus="s">
        <tr>
            <td><input type="checkbox" name="id" value="${userInfo.id}"/> </td>
            <td>${s.count}</td>
            <td>${userInfo.name}</td>
            <td>${userInfo.gender}</td>
            <td>${userInfo.age}</td>
            <td>${userInfo.address}</td>
            <td>${userInfo.qq}</td>
            <td>${userInfo.email}</td>
            <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/FindUserInfoByIdServlet?id=${userInfo.id}">修改</a>&nbsp;
                <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/DeleteUserInfoServlet?id=${userInfo.id}">删除</a></td>
        </tr>
        </c:forEach>
    </table>
    </form>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <c:if test="${pageBean.currentPage == 1}">
            <li class="disabled">
                <a href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            </c:if>
            <c:if test="${pageBean.currentPage != 1}">
                <li>
                    <a href="${pageContext.request.contextPath}/FindPageUserInfoServlet?currentPage=${pageBean.currentPage-1}&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
            </c:if>
            <c:forEach begin="1" end="${pageBean.totalPage}" var="i">
                <c:if test="${pageBean.currentPage == i}">
                    <li class="active"><a href="#">${i} <span class="sr-only">(current)</span></a></li>
                </c:if>
                <c:if test="${pageBean.currentPage != i}">
                    <li><a href="${pageContext.request.contextPath}/FindPageUserInfoServlet?currentPage=${i}&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a></li>
                </c:if>

            </c:forEach>
            <c:if test="${pageBean.currentPage == pageBean.totalPage}">
                <li class="disabled">
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </c:if>
            <c:if test="${pageBean.currentPage != pageBean.totalPage}">
                <li>
                    <a href="${pageContext.request.contextPath}/FindPageUserInfoServlet?currentPage=${pageBean.currentPage+1}&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </c:if>

            <span style="font-size: 20pt; margin-left: 5px;">共${pageBean.totalCount}条数据, 共${pageBean.totalPage}页</span>
        </ul>

    </nav>


</div>
</body>
</html>
