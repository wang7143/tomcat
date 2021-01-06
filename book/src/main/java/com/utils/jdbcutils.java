package com.utils;

// package com.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.util.JdbcUtils;

public class jdbcutils {

    private static DruidDataSource dataSource;

    static {

        // 读取配置文件

        InputStream re = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        System.out.println(re.toString());
        Properties pro = new Properties();
        try {
            pro.load(re);
            // 创建数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(pro);
            //

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getcon() {

        Connection con = null;
        try {
            con = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;

    }

    public static void close(Connection con) {
        if(con != null){
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // System.out.println("aa");
    }
}
