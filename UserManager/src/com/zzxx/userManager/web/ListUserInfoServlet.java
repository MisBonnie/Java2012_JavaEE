package com.zzxx.userManager.web;

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

@WebServlet("/ListUserInfoServlet")
public class ListUserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收请求, 获得参数
        // 2.封装对象
        // 3.调用service方法
        UserInfoService userInfoService = new UserInfoServiceImpl();
        List<UserInfo> list = userInfoService.findAllUserInfo();
        // 4.指派JSP页面显示
        request.setAttribute("list", list);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
