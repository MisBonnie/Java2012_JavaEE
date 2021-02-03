package a_filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(value = "/Demo1Servlet")
public class FilterAB implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FilterB创建了");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("FilterB过滤的操作");
        // 放行
        //chain.doFilter(request, response);

        System.out.println("响应返回FilterB的操作");
        response.getWriter().write("filterB response");
    }

    @Override
    public void destroy() {
        System.out.println("FilterB销毁了");
    }
}
