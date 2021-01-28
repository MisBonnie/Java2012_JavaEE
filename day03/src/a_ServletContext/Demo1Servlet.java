package a_ServletContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Demo1Servlet")
public class Demo1Servlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // 方式一: 通过ServletConfig来获得
        config.getServletContext();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获得ServletContext对象
        // 方式二: 通过Servlet对象来获得
        ServletContext application = this.getServletContext();
        // 方式三: 通过request对象来获得
        request.getServletContext();

        // 功能一: 获得应用名 - 虚拟目录 - 动态使用
        String path = application.getContextPath();
        System.out.println("path: " + path); // /day03_war_exploded
        // response.sendRedirect(application.getContextPath()+"/Demo2Servlet");
        // 功能二: 获得全局化参数 - web.xml
        String param = application.getInitParameter("aaa");
        System.out.println("param: " + param);
        // 功能三: 获得应用中资源的绝对路径
        //  day03/src/a.txt -> app/WEB-INF/classes/a.txt
        String patha = application.getRealPath("/WEB-INF/classes/a.txt");
        //  day03/web/b.txt -> app/b.txt
        String pathb = application.getRealPath("/b.txt");
        //  day03/web/WEB-INF/c.txt -> app/WEB-INF/c.txt
        String pathc = application.getRealPath("/WEB-INF/c.txt");
        //  day03/d.txt -> app中不存在
        System.out.println("patha: " + patha);
        System.out.println("pathb: " + pathb);
        System.out.println("pathc: " + pathc);
        // 功能四: 作为域对象使用
        application.setAttribute("name", "zhangsan");
        String name = (String) application.getAttribute("name");
        application.removeAttribute("name");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
