package demo.b_annotation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name="AnnotationServlet")
// <url-pattern>/AnnotationServlet</url-pattern>
@WebServlet("/AnnotationServlet") // 取代了servlet和servlet-mapping标签
// <load-on-startup>5</load-on-startup>
//@WebServlet(value = "/AnnotationServlet", loadOnStartup = 5) // 取代了servlet和servlet-mapping标签
// 多个url-pattern
//@WebServlet({"/*", "/annotation"})
public class AnnotationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Annotation Servlet 请求接收到");

        // 1.接收到请求参数  账号密码
        // 2.数据库连接, 对比

        // ---- 返回响应 ----
        // 3.登录成功 - 页面跳转
        // 4.登录失败 - 提示信息
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
