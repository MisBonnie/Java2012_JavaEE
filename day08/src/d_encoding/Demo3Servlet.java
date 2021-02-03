package d_encoding;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Demo3Servlet")
public class Demo3Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get请求方式 中文, Post请求方式ISO8859-1
        String hobby = request.getParameter("hobby");
        System.out.println("Demo3Servlet: "+ request.getMethod() + ": " + hobby);
//
//        hobby = new String(hobby.getBytes("ISO8859-1"), "UTF-8");
//        System.out.println("Demo2Servlet: 解决完乱码后"+ request.getMethod() + ": " + hobby);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
