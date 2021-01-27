package d_login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 2.数据库查询用户对象
        UsersDao ud = new UsersDao();
        User user = ud.findByUsernameAndPwd(username, password);
        // 3.判断登录成功失败的情况
        if (user==null) { // 登录失败, 跳转回原来的页面
            request.setAttribute("errorMsg", "账号/密码错误!");
            request.getRequestDispatcher("/login.html").forward(request, response);
        } else { // 登录成功跳转 -> 重定向到首页
            response.sendRedirect("/day02_war_exploded/index.html");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
