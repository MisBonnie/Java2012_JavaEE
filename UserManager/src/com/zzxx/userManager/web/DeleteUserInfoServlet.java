package com.zzxx.userManager.web;

import com.zzxx.userManager.service.UserInfoService;
import com.zzxx.userManager.service.impl.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteUserInfoServlet")
public class DeleteUserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取参数id
        int id = Integer.valueOf(request.getParameter("id"));
        // 2.调用service删除
        UserInfoService us = new UserInfoServiceImpl();
        us.deleteUserInfoById(id);
        // 3.显示 -> 重新显示列表 -> FindPageUserInfoServlet
        // 重定向
        response.sendRedirect(request.getContextPath() + "/FindPageUserInfoServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
