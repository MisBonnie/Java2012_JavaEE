package a_request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/Demo1Servlet")
public class Demo1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 一: 获得请求行信息  请求方式 请求URI(get请求方式的参数)
        // 1.获得请求方式
        String method = request.getMethod();  // POST GET
        System.out.println(method);

        // 2.获得请求URI    不带?后面部分
        String uri = request.getRequestURI();
        String url = request.getRequestURL().toString();
        System.out.println(uri);
        System.out.println(url);

        //  二: 获得请求头信息  Map
        String userAgent = request.getHeader("user-agent"); // 通过user-agent可以解决浏览器差异问题
        System.out.println(userAgent);

        // referer -> 解决盗链问题

        // request.getIntHeader("key") => int
        // request.getDateHeader("key") => Date
        // request.getHeaders("key") => 获得相同key对应的所有value值
        Enumeration<String> names = request.getHeaderNames();// 获得所有请求头的name

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
