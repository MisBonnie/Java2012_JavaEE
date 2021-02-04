<%--
  Created by IntelliJ IDEA.
  User: bonnie
  Date: 2021/2/4
  Time: 9:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
    <script>
        function sendRequest() {
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    document.getElementById("myDiv").innerHTML = xmlhttp.responseText;
                }
            }
            xmlhttp.open("GET", "Demo1Servlet", true);
            xmlhttp.send();
        }
        $(function() {
            $("#get").click(function() {
                // 使用get方法发送ajax请求
                $.get("${pageContext.request.contextPath}/Demo1Servlet",
                    //"name=zhangsan&age=18", // 支持String格式, 还支持json格式
                    //"name="+$("#name").val()+"&age=18",
                    {
                        name: $("#name").val(),
                        age: 18
                    },
                    function(data) { // data就是响应内容/响应体
                        $("#myDiv").html(data.username);
                    },
                    //"text" // 响应体类型, text-普通纯文本, json-json格式的字符串
                    "json" // 将响应体按照json格式来解析读取  {username: "张三"}
                );
            });
            $("#post").click(function() {
                // 使用post方法发送ajax请求
                $.post("${pageContext.request.contextPath}/Demo1Servlet",
                    {
                        name: $("#name").val(),
                        age: 18
                    },
                    function(data) { // data就是响应内容/响应体
                        $("#myDiv").html(data.username);
                    },
                    "json" // 将响应体按照json格式来解析读取  {username: "张三"}
                );
            });
            $("#ajax").click(function() {
                // 使用ajax方法发送ajax请求
                $.ajax({
                    url: "${pageContext.request.contextPath}/Demo1Servlet", // 请求地址
                    data: { // 请求参数,发送给服务器的数据
                        name: $("#name").val(),
                        age: 18
                    },
                    dataType: "json",
                    success: function(data) {
                        $("#myDiv").html(data.username); // 局部刷新
                    },
                    async: true, // true-异步, false-同步
                    method: "GET"
                });
            });
            $("#ajax2").click(function() {
                // 使用ajax方法发送ajax请求
                $.ajax({
                    url: "${pageContext.request.contextPath}/Demo1Servlet", // 请求地址
                    data: { // 请求参数,发送给服务器的数据
                        name: $("#name").val(),
                        age: 18
                    },
                    dataType: "json",
                    success: function(data) {
                        $("#myDiv").html(data.username); // 局部刷新
                    },
                    async: false, // true-异步, false-同步
                    method: "GET"
                });
            });
        })
    </script>
</head>
<body>
<input id="name" name="name" type="text"/>
<input type="button" value="使用JS发送ajax请求" onclick="sendRequest();"/>
<input type="button" value="使用get方法发送ajax请求" id="get"/>
<input type="button" value="使用post方法发送ajax请求" id="post"/><br>
<input type="button" value="使用ajax方法发送ajax请求" id="ajax"/>
<input type="button" value="使用ajax方法发送同步请求" id="ajax2"/>
<div id="myDiv"></div>
</body>
</html>
