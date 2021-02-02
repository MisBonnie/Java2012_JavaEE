package mailutils;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DruidUtils {
    private static DruidDataSource ds = new DruidDataSource();
    static {
        Properties pros = new Properties();
        try {
            pros.load(DruidUtils.class.getResourceAsStream("druid.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // --- driver url username password 是必须提供的四个属性 ---
        ds.setDriverClassName(pros.getProperty("driverClassName"));
        ds.setUrl(pros.getProperty("url"));
        ds.setUsername(pros.getProperty("username"));
        ds.setPassword(pros.getProperty("password"));
        ds.setMaxWait(Long.valueOf(pros.getProperty("maxWait")));
    }

    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public static DataSource getDataSource() {
        return ds;
    }
}
