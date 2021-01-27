package b_register;

import org.springframework.jdbc.core.JdbcTemplate;
import utils.DruidUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 注册操作
        request.setCharacterEncoding("UTF-8");
        // 1.获得请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");

        // 2.将参数封装为对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setName(name);
        user.setGender(gender);
        user.setBirthday(birthday);

        // 3.将数据保存在数据库中 -> JDBC Druid连接池 和 JdbcTemplate
        // 调用UsersDao的addUser方法
        UsersDao usersDao = new UsersDao();
        usersDao.addUser(user);

        // 3.给客户端响应 -> 忽略
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
