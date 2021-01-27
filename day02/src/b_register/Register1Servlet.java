package b_register;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/Register1Servlet")
public class Register1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 注册操作
        request.setCharacterEncoding("UTF-8");
        // 1.获得请求参数 + 封装对象  BeanUtils(beanutils.jar + collections.jar)
        // a.创建对象
        User user = new User();
        try {
            // b.封装对象(注入属性)   map格式: {username=张三, password=1234...}
            BeanUtils.populate(user, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // 3.将数据保存在数据库中 -> JDBC Druid连接池 和 JdbcTemplate
        // 调用UsersDao的addUser方法
        UsersDao usersDao = new UsersDao();
        usersDao.addUser(user);

        // 3.给客户端响应 -> 忽略
        // 重定向 -> 登录页面
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
