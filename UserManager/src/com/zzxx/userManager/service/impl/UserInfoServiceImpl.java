package com.zzxx.userManager.service.impl;

import com.zzxx.userManager.beans.PageBean;
import com.zzxx.userManager.beans.UserInfo;
import com.zzxx.userManager.dao.UserInfoDao;
import com.zzxx.userManager.dao.impl.UserInfoDaoImpl;
import com.zzxx.userManager.service.UserInfoService;

import java.util.List;
import java.util.Map;

public class UserInfoServiceImpl implements UserInfoService {
    private UserInfoDao userInfoDao = new UserInfoDaoImpl();
    @Override
    public List<UserInfo> findAllUserInfo() {
        return userInfoDao.findAllUserInfo();
    }

    @Override
    public UserInfo findUserInfoById(int id) {
        return userInfoDao.findById(id);
    }
    public void updateUserInfo(UserInfo userInfo) {
        userInfoDao.update(userInfo);
    }

    @Override
    public PageBean<UserInfo> findPageBean(int currentPage, int pageSize, Map<String, String[]> condition) {
        PageBean<UserInfo> pb = new PageBean<>();
        pb.setCurrentPage(currentPage);
        pb.setPageSize(pageSize);
        // 查询数据库获得List
        List<UserInfo> list = userInfoDao.findUserInfoByPage(currentPage, pageSize, condition);
        // 查询数据库获得totalCount
        int totalCount = userInfoDao.findCount(condition);
        // 计算totalPage
//        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        int totalPage = (totalCount + pageSize - 1) / pageSize;
        pb.setList(list);
        pb.setTotalCount(totalCount);
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public void deleteUserInfoById(int id) {
        userInfoDao.deleteById(id);
    }

    @Override
    public void deleteUserInfos(String[] ids) {
        for (String _id : ids) {
            int id = Integer.parseInt(_id);
            userInfoDao.deleteById(id);
        }
    }

    @Override
    public void addUserInfo(UserInfo userInfo) {
        userInfoDao.add(userInfo);
    }
}
