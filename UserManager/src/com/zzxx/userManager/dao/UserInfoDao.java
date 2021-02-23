package com.zzxx.userManager.dao;

import com.zzxx.userManager.beans.UserInfo;

import java.util.List;
import java.util.Map;

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
     * @param condition
     * @return
     */
    List<UserInfo> findUserInfoByPage(int currentPage, int pageSize, Map<String, String[]> condition);

    /**
     * 查询总记录条数
     * @return
     * @param condition
     */
    int findCount(Map<String, String[]> condition);

    void deleteById(int id);

    void add(UserInfo userInfo);
}
