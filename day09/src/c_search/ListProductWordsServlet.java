package c_search;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ListProductWordsServlet")
public class ListProductWordsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.接收请求参数
        String word = req.getParameter("word");
        // 2.根据关键字, 调用service查询对应的商品列表(商品名列表)
        ProductService productService = new ProductServiceImpl();
        List<Product> list = productService.findProductsByWord(word);
        // 将java对象 -> 转换成json格式字符串
        // jsonlib  gson  fastjson  jackson-spring
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
        // 3.将商品列表返回个客户端 -> json
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(json);
    }
}
