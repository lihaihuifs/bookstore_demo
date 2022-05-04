package com.haihui.book.bookstore_demo.dao;
/**
 * @author : lihai
 * @mailto : lihaihuifs@outlook.com
 * @created : 2022/5/3, 星期二
 * @version : 1.0
 **/

import com.haihui.book.bookstore_demo.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @description  :
 * @version      : [v1.0]
 */
public class BaseDAO {
    // Access database with DbUtils
    private QueryRunner queryRunner = new QueryRunner();

    // Insert, update, and delete
    public int update(String sql, Object...args){
        // Get connection
        Connection connection = JdbcUtils.getConnection();
        try {
            // Update with queryRunner
            return queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close connection
            JdbcUtils.closeConnection(connection);
        }
        return -1;
    }

    // Fetch one record
    public <T> T queryForOne(Class<T> type, String sql, Object...args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(connection);
        }
        return null;
    }

    // Fetch multiple records
    public <T> List<T> queryForList(Class<T> type, String sql, Object...args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(connection);
        }
        return null;
    }

    public Object queryForSingleValue(String sql, Object...args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(connection);
        }
        return null;
    }
}
