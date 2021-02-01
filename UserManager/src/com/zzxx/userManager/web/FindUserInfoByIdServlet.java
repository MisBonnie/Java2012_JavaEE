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

@WebServlet("/FindUserInfoByIdServlet")
public class FindUserInfoByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1, 获得参数
        int id = Integer.valueOf(request.getParameter("id"));
        // 2.调用service获得结果
        UserInfoService userInfoService = new UserInfoServiceImpl();
        UserInfo userInfo = userInfoService.findUserInfoById(id);
        // 3.转发到update.jsp页面
        request.setAttribute("userInfo", userInfo);
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
