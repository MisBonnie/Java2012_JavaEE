package com.zzxx.userManager.service.impl;

import com.zzxx.userManager.beans.UserInfo;
import com.zzxx.userManager.dao.UserDao;
import com.zzxx.userManager.dao.UserInfoDao;
import com.zzxx.userManager.dao.impl.UserInfoDaoImpl;
import com.zzxx.userManager.service.UserInfoService;

import java.util.List;

public class UserInfoServiceImpl implements UserInfoService {
    private UserInfoDao userInfoDao = new UserInfoDaoImpl();
    @Override
    public List<UserInfo> findAllUserInfo() {
        return userInfoDao.findAllUserInfo();
    }
}
