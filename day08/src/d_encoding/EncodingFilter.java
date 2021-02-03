package d_encoding;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebFilter({"/Demo2Servlet", "/Demo3Servlet"})
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //request.setCharacterEncoding("UTF-8"); // 只对POST方式有效
        // 解决乱码问题: 将 request 类型转换成 MyHttpServletRequest 类型
        HttpServletRequest req = (HttpServletRequest) request;

        MyHttpServletRequest myRequest = new MyHttpServletRequest(req);

        chain.doFilter(myRequest, response);
    }

    @Override
    public void destroy() {

    }
}
class MyHttpServletRequest extends HttpServletRequestWrapper {
    private HttpServletRequest request;

    public MyHttpServletRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    @Override
    /**
     * @param name 请求传递过来的参数名
     * @return String 通过name参数名获得到的对应参数值
     * 将返回值变成正常中文
     */
    public String getParameter(String name) {
        // super.getParameter(name); 原始的getParameter方法
        String value = super.getParameter(name);
        try {
            // 解决乱码
            value = new String(value.getBytes("ISO8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }
}



