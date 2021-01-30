package a_cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie/Demo2Servlet")
public class Demo2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收这个cookie数据
        // 接收这个客户端携带过来的所有的cookie, 如果客户端没有cookie携带过来, 返回值是null
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                // 获得cookie对应的name和value, value是关键   name=zhangsan password=123
                response.getWriter().write(cookie.getName() + ":" + cookie.getValue() + "\n");
                // 操作/使用cookie
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}