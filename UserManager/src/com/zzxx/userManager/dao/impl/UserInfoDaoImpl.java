package com.zzxx.userManager.dao.impl;

import com.zzxx.userManager.beans.UserInfo;
import com.zzxx.userManager.dao.UserInfoDao;
import com.zzxx.userManager.utils.DruidUtils;
import org.springframework.dao.EmptyResultDataAccessException;
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

    @Override
    public UserInfo findById(int id) {
        String sql = "select * from user_info where id = ?";
        // list 永远不会是null值
        /*List<UserInfo> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(UserInfo.class), id);
        return list.size() == 0 ? null : list.get(0);*/

        // queryForObject 如果查不到对象, 会抛出异常
        try {
            UserInfo userInfo = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(UserInfo.class), id);
            return userInfo;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    public void update(UserInfo userInfo) {
        String sql = "update user_info set name=?,gender=?,qq=?,address=?,email=?,age=? where id=?";
        jdbcTemplate.update(sql, userInfo.getName(), userInfo.getGender(), userInfo.getQq(), userInfo.getAddress(), userInfo.getEmail(), userInfo.getAge(), userInfo.getId());
    }

    @Override
    public List<UserInfo> findUserInfoByPage(int currentPage, int pageSize) {
        String sql = "select * from user_info limit ?,?";
        int start = (currentPage - 1) * pageSize;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(UserInfo.class), start, pageSize);
    }

    @Override
    public int findCount() {
        String sql = "select count(*) from user_info";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }
}
