package com.zzxx.userManager.dao;

import com.zzxx.userManager.beans.UserInfo;

import java.util.List;

public interface UserInfoDao {
    /**
     * 查询所有用户信息
     */
    List<UserInfo> findAllUserInfo();
}
