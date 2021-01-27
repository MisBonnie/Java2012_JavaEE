package b_register;

import org.springframework.jdbc.core.JdbcTemplate;
import utils.DruidUtils;

public class UsersDao {
    public void addUser(User user) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
        String sql = "insert into users values(null, ?,?,?,?,?,?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getGender(), user.getBirthday(), user.getName());
    }
}
