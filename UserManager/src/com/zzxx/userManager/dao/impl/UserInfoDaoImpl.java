package com.zzxx.userManager.dao.impl;

import com.zzxx.userManager.beans.UserInfo;
import com.zzxx.userManager.dao.UserInfoDao;
import com.zzxx.userManager.utils.DruidUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    public List<UserInfo> findUserInfoByPage(int currentPage, int pageSize, Map<String, String[]> condition) {
        // 要根据条件, 来动态拼接sql语句, 建议使用StringBuilder
        // select * from user_info where 1=1 and name like ? and address like ? and email like ? limit ?,?
        String sql = "select * from user_info where 1=1 ";
        List<Object> paramList = new ArrayList<>(); // 用来保存参数值的
        // 遍历condition来动态拼接条件
        Set<Map.Entry<String, String[]>> entries = condition.entrySet();
        for (Map.Entry<String, String[]> entry: entries) {
            if (entry.getKey().equals("name")) {
                sql += " and name like ? ";
                paramList.add("%" + entry.getValue()[0] + "%");
            } else if (entry.getKey().equals("address")) {
                sql += " and address like ? ";
                paramList.add("%" + entry.getValue()[0] + "%");
            } else if (entry.getKey().equals("email")) {
                sql += " and email like ? ";
                paramList.add("%" + entry.getValue()[0] + "%");
            }
        }
        sql += " limit ?,?";
//        select * from user_info where name like '%张%' and address like '%%' and email like '%%' limit ?,?
        int start = (currentPage - 1) * pageSize;
        paramList.add(start);
        paramList.add(pageSize);
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(UserInfo.class), paramList.toArray());
    }

    @Override
    public int findCount(Map<String, String[]> condition) {
        String sql = "select count(*) from user_info where 1=1 ";
        List<Object> paramList = new ArrayList<>(); // 用来保存参数值的
        // 遍历condition来动态拼接条件
        Set<Map.Entry<String, String[]>> entries = condition.entrySet();
        for (Map.Entry<String, String[]> entry: entries) {
            if (entry.getKey().equals("name")) {
                sql += " and name like ? ";
                paramList.add("%" + entry.getValue()[0] + "%");
            } else if (entry.getKey().equals("address")) {
                sql += " and address like ? ";
                paramList.add("%" + entry.getValue()[0] + "%");
            } else if (entry.getKey().equals("email")) {
                sql += " and email like ? ";
                paramList.add("%" + entry.getValue()[0] + "%");
            }
        }
        int count = jdbcTemplate.queryForObject(sql, Integer.class, paramList.toArray());
        return count;
    }
}
