package com.zzxx.userManager.service;

import com.zzxx.userManager.beans.PageBean;
import com.zzxx.userManager.beans.UserInfo;

import java.util.List;

public interface UserInfoService {
    /**
     * 查询所有用户信息的业务
     */
    List<UserInfo> findAllUserInfo();

    /**
     * 根据id查询一个用户信息的业务
     */
    UserInfo findUserInfoById(int id);

    /**
     * 修改用户信息
     * @param userInfo
     */
    void updateUserInfo(UserInfo userInfo);

    /**
     * 查询用户信息的分页数据
     * @return
     * @param currentPage
     * @param pageSize
     */
    PageBean<UserInfo> findPageBean(int currentPage, int pageSize);
}
