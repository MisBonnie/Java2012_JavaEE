package b_session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/Demo3Servlet")
public class Demo3Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Session空间的创建 是服务器自己完成
        // 1.获得session空间 - 向服务器申请session空间
        // 如果服务器已经为客户端创建好了session空间, 就返回之前创建好的空间session
        // 如果客户端是第一次申请session空间, 服务器就会先创建一个session空间, 并返回

        HttpSession session = request.getSession();
        // 2.向session中存数据 - 域对象
        session.setAttribute("name", "zhangsan");

        // JSESSIONID 持久化
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setPath(request.getContextPath());
        cookie.setMaxAge(100 * 60);

        response.addCookie(cookie);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
