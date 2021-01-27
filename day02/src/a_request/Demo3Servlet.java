package a_request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/Demo3Servlet")
public class Demo3Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获得参数之前, 先设置请求的字符集
        request.setCharacterEncoding("UTF-8"); // 这句话只对post请求有效

        // 获得请求参数  user=eeee
        // 1.普通文本输入框  = value
        String user = request.getParameter("username");
        System.out.println(user);

        // 2.密码输入框  = value password
        String password = request.getParameter("password");
        System.out.println(password);
        // 3.date输入框
        String birthday = request.getParameter("birthday"); // 2021-01-05  yyyy-MM-dd
        System.out.println(birthday);
        // 4.checkbox 多选框
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobbies));

        // 获得所有的参数名字 {username, password, birthday, hobby}
        Enumeration<String> parameterNames = request.getParameterNames();

        // 获得的是所有参数的 key-value=> username={张三}
        Map<String, String[]> parameterMap = request.getParameterMap();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
