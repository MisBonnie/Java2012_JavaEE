package com.zzxx.userManager.dao.impl;

import com.zzxx.userManager.beans.UserInfo;
import com.zzxx.userManager.dao.UserInfoDao;
import com.zzxx.userManager.utils.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserInfoDaoImpl implements UserInfoDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
    @Override
    public List<UserInfo> findAllUserInfo() {
        String sql = "select * from user_info";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(UserInfo.class));
    }
}
