package d_login;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import mailutils.DruidUtils;

import java.util.List;

public class UsersDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
    /**
     * 添加用户
     * @param user
     */
    public void addUser(User user) {
        String sql = "insert into users values(null, ?,?,?,?,?,?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getGender(), user.getBirthday(), user.getName());
    }
    /**
     * 根据账号密码查询用户
     */
    public User findByUsernameAndPwd(String username, String password) {
        String sql = "select * from users where username = ? and password = ?";
        // query() 返回的集合 永远不可能是null, 如果查不到, list.size() == 0
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), username, password);
        System.out.println(list);
        return list.size() == 0 ? null:list.get(0);
    }
}
