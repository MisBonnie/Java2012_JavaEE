package b_objectListener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Demo04AddSessionServlet")
public class Demo04AddSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Demo04AddSessionServlet进来了");
        req.getSession().setAttribute("user", new User("张三", 18));
        req.getSession().setAttribute("string", "普通字符串");
    }
}
