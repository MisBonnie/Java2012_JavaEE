package b_list;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.DruidUtils;

import java.util.List;

public class UserDao {
    public List<User> findAllUsers() {
        String sql = "select * from user_info";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }
}
