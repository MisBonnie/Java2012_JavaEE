package com.zzxx.userManager.web;

import com.zzxx.userManager.beans.UserInfo;
import com.zzxx.userManager.service.UserInfoService;
import com.zzxx.userManager.service.impl.UserInfoServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/AddUserInfoServlet")
public class AddUserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // 1.接收请求参数, 封装对象
        UserInfo userInfo = new UserInfo();
        try {
            BeanUtils.populate(userInfo, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // 2.调用service保存
        UserInfoService us = new UserInfoServiceImpl();
        us.addUserInfo(userInfo);
        // 3.页面显示 -> list列表
        // 重定向
        response.sendRedirect(request.getContextPath() + "/FindPageUserInfoServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
