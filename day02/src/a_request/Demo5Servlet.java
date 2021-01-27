package a_request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Demo5Servlet")
// 模拟html, jsp...
public class Demo5Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("Demo5: " + username);

        // 1.接收到了Demo4Servlet的转发过来的请求
        System.out.println("Demo5接收到了转发过来的请求");

        // 从域对象中取出数据
        String message = (String) request.getAttribute("msg");

        // 2.给客户端返回响应
        System.out.println(message);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
