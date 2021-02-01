package com.zzxx.userManager.test;

import com.zzxx.userManager.beans.UserInfo;
import com.zzxx.userManager.dao.UserInfoDao;
import com.zzxx.userManager.dao.impl.UserInfoDaoImpl;
import org.junit.Test;

public class UserInfoDaoTest {
    @Test
    public void findByIdTest() {
        UserInfoDao userInfoDao = new UserInfoDaoImpl();
        UserInfo userInfo = userInfoDao.findById(4);
        System.out.println(userInfo);
    }
}
