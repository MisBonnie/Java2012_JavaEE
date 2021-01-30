package com.zzxx.userManager.test;

import com.zzxx.userManager.utils.DruidUtils;
import org.junit.Test;

import javax.sql.DataSource;

public class DruidUtilsTest {
    @Test
    public void testGetDataSource() {
        DataSource dataSource = DruidUtils.getDataSource();
        System.out.println(dataSource);
    }
}
