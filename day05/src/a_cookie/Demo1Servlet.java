package a_cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 http://localhost:8080/day05_war_exploded/Demo1Servlet - 设置cookie
 http://localhost:8080/day05_war_exploded/Demo2Servlet - 获得cookie - cookie可以携带过来
 http://localhost:8080/day05_war_exploded/index.jsp - 获得cookie - cookie可以携带过来
 以上三个资源, 在同一个目录下
 http://localhost:8080/day04_war_exploded/Demo1Servlet  和 Demo1Servlet不在同一个应用中 - cookie不可以携带过来
 ------------------------------------------------------
 http://localhost:8080/day05_war_exploded/cookie/Demo1Servlet - 设置cookie
 http://localhost:8080/day05_war_exploded/cookie/Demo2Servlet - 获得cookie - cookie可以携带过来
 http://localhost:8080/day05_war_exploded/index.jsp - 获得cookie - cookie不可以携带过来

 Demo1Servlet和Demo2Servlet在同一个目录下, index.jsp和Demo1Servlet不在同一个目录下

 http://localhost:8080/day04_war_exploded/Demo1Servlet - cookie不可以携带过来

 cookie默认的携带路径: 设置cookie资源的当前目录
 */
@WebServlet("/cookie/Demo1Servlet")
public class Demo1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.模拟数据 key-value  name-zhangsan
        // 2.创建Cookie对象, 直接通过key-value来构造对象
        Cookie cookie = new Cookie("name", "zhangsan");
        Cookie cookie2 = new Cookie("password", "123");
        Cookie cookie3 = new Cookie("age", "18");

        // 设置cookie的携带路径
        // name=zhangsan  -> 当前应用中所有资源可携带
        // password=123 -> 当前目录中资源可携带 (默认)
        // age=18 -> / 当前服务器中所有资源可携带
        // request.getContextPath() -> 当前应用
        cookie.setPath(request.getContextPath());
        cookie3.setPath("/");
        // 设置cookie的持久化事件, 单位:分钟
        cookie2.setMaxAge(10 * 60);

        // 3.将数据保存到客户端 - Cookie    Set-Cookie: name=zhangsan
        response.addCookie(cookie);
        response.addCookie(cookie2);
        response.addCookie(cookie3);

        response.getWriter().write("success");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
