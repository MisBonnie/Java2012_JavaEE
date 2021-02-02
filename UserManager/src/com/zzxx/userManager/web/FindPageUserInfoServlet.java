package com.zzxx.userManager.web;

import com.zzxx.userManager.beans.PageBean;
import com.zzxx.userManager.beans.UserInfo;
import com.zzxx.userManager.service.UserInfoService;
import com.zzxx.userManager.service.impl.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/FindPageUserInfoServlet")
public class FindPageUserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置请求字符集 - Post方式才需要设置
        request.setCharacterEncoding("UTF-8");
        // 1.接收请求, 获得参数 - 分页参数
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        // 2.处理默认值
        if(_currentPage == null || _currentPage.trim().equals("")) {
            _currentPage = "1";
        }
        if(_pageSize == null || _pageSize.trim().equals("")) {
            _pageSize = "4";
        }
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        // 得到条件查询的参数 -> 表单获得的(name, address, email), 分页参数(currentPage, pageSize)
        Map<String, String[]> condition = request.getParameterMap();

        // 3.调用service方法, 获得分页数据 PageBean对象
        UserInfoService userInfoService = new UserInfoServiceImpl();
        PageBean<UserInfo> pb = userInfoService.findPageBean(currentPage, pageSize, condition);
        // 4.指派JSP页面显示
        request.setAttribute("pageBean", pb);
        request.setAttribute("condition", condition);// ${condition.name[0]} -> condition.get("name")[0]
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
