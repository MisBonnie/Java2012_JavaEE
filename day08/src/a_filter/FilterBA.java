package a_filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * value: <url-pattern></url-pattern>
 *        完全匹配 /Demo1Servlet, 目录匹配 /xx/*, 后缀匹配 *.xx
 * name: <filter-name></filter-name>
 * initParams: 初始化参数 <init-param></init-param>
 *      name: <param-name></param-name>
 *      value: <param-value></param-value>
 */
@WebFilter(value = "/Demo1Servlet", initParams = @WebInitParam(name="encoding", value="UTF-8"))
public class FilterBA implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FilterA创建了");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("FilterA过滤的操作");
        // 放行: 进入下一个过滤器, 如果没有下一个过滤器, 则进入Servlet资源
        chain.doFilter(request, response);

        System.out.println("响应返回FilterA的操作");
        response.getWriter().write("filterA response");
    }

    @Override
    public void destroy() {
        System.out.println("FilterA销毁了");
    }
}
