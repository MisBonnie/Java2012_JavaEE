package b_autoLogin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*") // 进入网站所有站点之前都会先自动登录
public class AutoLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 自动登录
        HttpServletRequest req = (HttpServletRequest) request;
        // 1.获得cookie中的账号密码   username, password
        Cookie[] cookies = req.getCookies();
        String username = null;
        String password = null;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("username")) {
                    username = c.getValue();
                } else if (c.getName().equals("password")) {
                    password = c.getValue();
                }
            }
        }
        // 2.根据账号密码登录
        if (username !=null && password != null) {
            UserService userService = new UserServiceImpl();
            User user = userService.login(username, password);
            req.getSession().setAttribute("user", user);
        }
        // 3.放行
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
