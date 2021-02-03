package b_autoLogin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收请求, 获得请求参数 (username password auto_login)
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String auto_login = request.getParameter("auto_login");

        // 2.调用service登录, 得到结果(可以登录的用户)
        UserService userService = new UserServiceImpl();
        User user = userService.login(username, password);

        // 3.auto_login -> 勾选了
        //   将账号密码保存在cookie中
        if ("on".equals(auto_login)) {
            Cookie username_cookie = new Cookie("username", username);
            Cookie password_cookie = new Cookie("password", password);
            username_cookie.setPath(request.getContextPath());
            password_cookie.setPath(request.getContextPath());
            username_cookie.setMaxAge(10 * 24 * 60 * 60);
            password_cookie.setMaxAge(10 * 24 * 60 * 60);
            response.addCookie(username_cookie);
            response.addCookie(password_cookie);
        }
        // 4.将登录的对象保存在session域中
        request.getSession().setAttribute("user", user);
        // 5.页面显示 -> index(重定向)
        response.sendRedirect(request.getContextPath());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
