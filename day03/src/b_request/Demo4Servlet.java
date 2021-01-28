package b_request;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

//@WebServlet("/Demo4Servlet")
public class Demo4Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 效果等同于 application.getContextPath()
        String contextPath = request.getContextPath();
        System.out.println(contextPath);

        // 读取请求体的输入流
        InputStream is = request.getInputStream();
        ServletConfig config = this.getServletConfig();
        // <servlet-name>Demo4Servlet</servlet-name>
        String servletName = config.getServletName(); // Demo4Servlet

        // 获得初始化参数
        String param = config.getInitParameter("bbb");
        System.out.println(param);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
