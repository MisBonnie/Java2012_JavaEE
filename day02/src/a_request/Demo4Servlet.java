package a_request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Demo4Servlet")
public class Demo4Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收到了客户端的请求 request
        String username = request.getParameter("username");
        System.out.println("Demo4:" + username);

        // 1.5 在当前资源中产生了新的数据, 例如错误提示信息(账号未激活, 账号密码错误, 账号被冻结...)
        String message = "账号未激活";
        // 使用request域来传递数据
        request.setAttribute("msg", message);

        // 2.进行请求的转发 (服务器内部资源的跳转)
        // a.获得请求转发器
        /*RequestDispatcher dispatcher = request.getRequestDispatcher("/Demo5Servlet");
        // b.开始转发
        dispatcher.forward(request, response);*/

        request.getRequestDispatcher("/Demo5Servlet").forward(request, response);

        // 转发后, 这个Servlet就不要再写代码了
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
