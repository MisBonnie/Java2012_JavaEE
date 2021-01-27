package demo.a_servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * 自定义Servlet类来接收请求
 * 1.自定义类来实现 Servlet接口
 * 2.重点实现 service 方法
 * 3.配置 web.xml
 * 4.访问
 *    http://localhost:8080/day01_war_exploded/hello
 *    http://localhost:8080/day01_war_exploded/form.html
 */
public class HelloServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("HelloServlet init");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("接收到请求");
        System.out.println("需要返回响应");
    }

    @Override
    public void destroy() {
        System.out.println("HelloServlet destroy");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
}
