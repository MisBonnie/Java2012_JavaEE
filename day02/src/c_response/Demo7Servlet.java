package c_response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/Demo7Servlet")
public class Demo7Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收到请求
        String username = request.getParameter("username");
        System.out.println("Demo7: " + username);

        // 向request域中存数据
        request.setAttribute("msg", "一个重定向之前存储的信息");

        // 重定向之前也不建议写响应体
        // 2.重定向响应  URL/URI
        response.sendRedirect("/day02_war_exploded/Demo8Servlet");

        // 3.重定向之后不要再写代码
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
