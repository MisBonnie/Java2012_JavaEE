package b_checkCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收请求参数
        String code = request.getParameter("code");
        // 2.获得正确的验证码
        String checkCode = (String) request.getSession().getAttribute("checkcode_session");
        // 3.对比验证码是否正确
        response.setContentType("application/json;charset=utf-8");
        if (checkCode.equals(code.trim())) {
            // 4.给响应 {"isSuccess": true}
            response.getWriter().write("{\"isSuccess\": true}");
        } else {
            response.getWriter().write("{\"isSuccess\": false}");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
