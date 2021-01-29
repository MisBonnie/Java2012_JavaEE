package a_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Demo1Servlet")
public class Demo1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 返回给客户端一个动态页面
        // 1.去数据库查询数据
        List<String> list = new ArrayList<>();
        list.add("haha");
        list.add("hehe");
        list.add("heihei");
        list.add("xixi");
        // 2.将数据显示到页面中
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("<table>");
        for (int i = 0; i < list.size(); i++) {
            response.getWriter().write("<tr class='t'>");
            response.getWriter().write("<td>");
            response.getWriter().write(list.get(0));
            response.getWriter().write("</td>");
            response.getWriter().write("<td>");
            response.getWriter().write(list.get(0));
            response.getWriter().write("</td>");
            response.getWriter().write("<td>");
            response.getWriter().write(list.get(0));
            response.getWriter().write("</td>");
            response.getWriter().write("<td>");
            response.getWriter().write(list.get(0));
            response.getWriter().write("</td>");
            response.getWriter().write("</tr>");
        }
        response.getWriter().write("</table>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
