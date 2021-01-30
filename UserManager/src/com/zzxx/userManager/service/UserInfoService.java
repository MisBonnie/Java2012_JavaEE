package com.zzxx.userManager.service;

import com.zzxx.userManager.beans.UserInfo;

import java.util.List;

public interface UserInfoService {
    /**
     * 查询所有用户信息的业务
     */
    List<UserInfo> findAllUserInfo();
}
