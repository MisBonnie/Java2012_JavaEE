package b_session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Demo4Servlet")
public class Demo4Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Session空间的创建 是服务器自己完成
        // 1.获得session空间 - 向服务器申请session空间
        // 如果服务器已经为客户端创建好了session空间, 就返回之前创建好的空间session
        // 如果客户端是第一次申请session空间, 服务器就会先创建一个session空间, 并返回
        HttpSession session = request.getSession();
        // 2.向session中存数据 - 域对象
        Object name = session.getAttribute("name");

        response.getWriter().write(name + "\n");
        response.getWriter().write(session.getId());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
