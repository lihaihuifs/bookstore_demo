package com.haihui.book.bookstore_demo.test;
/**
 * @author : lihai
 * @mailto : lihaihuifs@outlook.com
 * @created : 2022/5/3, 星期二
 * @version : 1.0
 **/

import com.haihui.book.bookstore_demo.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @description  :
 * @version      : [v1.0]
 */
public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils(){
        for (int i = 0; i < 100; i++){
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
            JdbcUtils.closeConnection(connection);
        }
    }
}
