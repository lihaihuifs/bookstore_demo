package com.haihui.book.bookstore_demo.utils;
/**
 * @author : lihai
 * @mailto : lihaihuifs@outlook.com
 * @created : 2022/5/3, 星期二
 * @version : 1.0
 **/

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @version : [v1.0]
 * @description :
 */
public class JdbcUtils {
    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    // Initialization
    static {

        try {
            // Read in jdbc.properties
            Properties properties = new Properties();
            InputStream resource = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(resource);
            // Create Data Source
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get database connection
    public static Connection getConnection() {
        Connection connection = threadLocal.get(); // Attempt to retrieve connection
        if (connection == null) {
            try {
                connection = dataSource.getConnection();
                connection.setAutoCommit(false); // Transaction control manually
                threadLocal.set(connection); // Save connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection; // Return connection anyway
//        Connection connection = null;
//        try {
//            connection = dataSource.getConnection();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            return connection;
//        }
    }

    public static void commitAndClose(){
        Connection connection = threadLocal.get(); // Attempt to retrieve connection
        if (connection != null) {
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeConnection(connection);
            }
        }
        // Must remove thread-connection
        threadLocal.remove();
    }

    public static void rollBackAndClose(){
        Connection connection = threadLocal.get(); // Attempt to retrieve connection
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeConnection(connection);
            }
        }
        // Must remove thread-connection
        threadLocal.remove();
    }

    // Close database connection
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}