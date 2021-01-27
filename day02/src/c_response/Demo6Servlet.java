package c_response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/Demo6Servlet")
public class Demo6Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            注意: 一次只能使用一种输出流
                 通过response获得的输出流不能手动关闭
         */
        // 0.设置response缓冲区的字符集 - 还需要设置客户端编码才能正常显示
//        response.setCharacterEncoding("UTF-8");
        // 0.推荐使用设置响应类型来规定客户端解析的字符集 <meta charset="UTF-8">
        response.setContentType("text/html;charset=utf-8");
        // 1.获得字节输出流
//        OutputStream os = response.getOutputStream();
        // 2.获得字符输出流 => 默认以普通文本格式解析内容
        PrintWriter writer = response.getWriter();
        writer.print("输出流输出内容: " + new Date() + "<br>");
        writer.print("<font color='red'>红色字体</font>");
        //writer.close(); // 运行异常
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
