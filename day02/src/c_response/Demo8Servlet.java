package c_response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/Demo8Servlet")
public class Demo8Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Demo8接收到重定向过来的请求");

        String username = request.getParameter("username");
        System.out.println("Demo8: " + username);

        // 从域对象中取出数据
        String message = (String) request.getAttribute("msg");
        System.out.println("Demo8: " + message);
        response.getWriter().write("Demo8 success!");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
