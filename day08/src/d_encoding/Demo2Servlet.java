package d_encoding;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Demo2Servlet")
public class Demo2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get请求方式跟随Tomcat编码,改成了ISO8859-1, Post请求方式ISO8859-1
        String name = request.getParameter("name");
        System.out.println("Demo2Servlet: "+ request.getMethod() + ": " + name);
//
//        name = new String(name.getBytes("ISO8859-1"), "UTF-8");
//        System.out.println("Demo2Servlet: 解决完乱码后"+ request.getMethod() + ": " + name);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
