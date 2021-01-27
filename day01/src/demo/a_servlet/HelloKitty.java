package demo.a_servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义Servlet类来接收请求
 * 1.自定义类来 继承 HttpServlet 类
 * 2.重点实现 doGet/doPost 方法
 * 3.配置 web.xml
 *     <servlet>
 *         <servlet-name>Kitty</servlet-name>
 *         <!-- 自定义Servlet的全限定类名 -->
 *         <servlet-class>demo.a_servlet.HelloKitty</servlet-class>
 *     </servlet>
 *     <servlet-mapping>
 *         <servlet-name>Kitty</servlet-name>
 *         <url-pattern>/kitty</url-pattern>
 *     </servlet-mapping>
 * 4.访问
 *    http://localhost:8080/day01_war_exploded/kitty
 */
public class HelloKitty extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get请求接收到了");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post请求接收到了");
    }
}
