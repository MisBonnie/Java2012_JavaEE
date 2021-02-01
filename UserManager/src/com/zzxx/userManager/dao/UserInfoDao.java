package com.zzxx.userManager.dao;

import com.zzxx.userManager.beans.UserInfo;

import java.util.List;

public interface UserInfoDao {
    /**
     * 查询所有用户信息
     */
    List<UserInfo> findAllUserInfo();

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    UserInfo findById(int id);

    /**
     * 根据id修改用户信息
     * @param userInfo
     */
    void update(UserInfo userInfo);

    /**
     * 分页查询用户列表
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<UserInfo> findUserInfoByPage(int currentPage, int pageSize);

    /**
     * 查询总记录条数
     * @return
     */
    int findCount();
}
