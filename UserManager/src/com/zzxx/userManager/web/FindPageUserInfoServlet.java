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

@WebServlet("/FindPageUserInfoServlet")
public class FindPageUserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收请求, 获得参数
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
        // 3.调用service方法, 获得分页数据 PageBean对象
        UserInfoService userInfoService = new UserInfoServiceImpl();
        PageBean<UserInfo> pb = userInfoService.findPageBean(currentPage, pageSize);
        // 4.指派JSP页面显示
        request.setAttribute("pageBean", pb);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
