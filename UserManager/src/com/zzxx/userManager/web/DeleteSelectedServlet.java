package com.zzxx.userManager.web;

import com.zzxx.userManager.service.UserInfoService;
import com.zzxx.userManager.service.impl.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteSelectedServlet")
public class DeleteSelectedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收很多个id
        String[] ids = request.getParameterValues("id");
        // 2.调用service删除
        UserInfoService us = new UserInfoServiceImpl();
        us.deleteUserInfos(ids);
        // 3.显示
        // 重定向
        response.sendRedirect(request.getContextPath() + "/FindPageUserInfoServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
