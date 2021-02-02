package c_filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Filter使用步骤
 * 1.实现接口 Filter
 * 2.着重实现doFilter方法
 * 3.注册filter  web.xml或者注解
 */
@WebFilter("/Demo04AddSessionServlet")
public class FilterA implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter初始化方法");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 过滤请求, 如果想要继续进入servlet, 需要将请求放行
        System.out.println("过滤方法");

        // 放行
        chain.doFilter(request, response);

        // 放行之后的工作
        System.out.println("放行之后");
    }

    @Override
    public void destroy() {
        System.out.println("Filter销毁方法");
    }
}
