package com.atguigu.myssm.basedao;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnUtil {


    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    //private static ThreadLocal<Object> threadLocal2 = new ThreadLocal<>();
    //private static ThreadLocal<Object> threadLocal3 = new ThreadLocal<>();


//    public static String DRIVER;
//    public static String URL;
//    public static String USER;
//    public static String PWD;
 static Properties pro = new Properties();
    static {
        InputStream is = ConnUtil.class.getClassLoader().getResourceAsStream("druid.properties");

        try {
            pro.load(is);
//            DRIVER = pro.getProperty("driverClass");
//            URL = pro.getProperty("url");
//            USER = pro.getProperty("user");
//            PWD = pro.getProperty("password");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    private static Connection createConn() {
        try {
            DataSource druidDataSource = DruidDataSourceFactory.createDataSource(pro);


//            DruidDataSource druidDataSource = new DruidDataSource();
//            druidDataSource.setDriverClassName(DRIVER);
//            druidDataSource.setUrl(URL);
//            druidDataSource.setPassword(PWD);
//            druidDataSource.setUsername(USER);
//
//            druidDataSource.setMaxWait(5000);
//            druidDataSource.setMinIdle(3);
//            druidDataSource.setMaxActive(10);

            return druidDataSource.getConnection();


            //1.加载驱动

        } catch ( SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static Connection getConn() {
        Connection conn = threadLocal.get();
        if (conn == null) {
            conn = createConn();
            threadLocal.set(conn);
        }
        return threadLocal.get();
    }

    public static void closeConn() throws SQLException {
        Connection conn = threadLocal.get();
        if (conn == null) {
            return;
        }
        if (!conn.isClosed()) {
            conn.close();
            //threadLocal.set(null);
            threadLocal.remove();
        }
    }
}
