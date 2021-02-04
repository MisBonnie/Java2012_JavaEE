package c_search;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.DruidUtils;

import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
    @Override
    public List<Product> findProductsByPname(String word) {
        String sql = "select * from products where pname like ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class), word + "%");
    }
}
