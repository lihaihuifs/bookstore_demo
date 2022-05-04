package com.haihui.book.bookstore_demo.test;
/**
 * @author : lihai
 * @mailto : lihaihuifs@outlook.com
 * @created : 2022/5/3, 星期二
 * @version : 1.0
 **/

import com.haihui.book.bookstore_demo.dao.UserDAO;
import com.haihui.book.bookstore_demo.dao.impl.UserDAOImpl;
import com.haihui.book.bookstore_demo.entity.User;
import org.junit.Test;

/**
 * @version : [v1.0]
 * @description :
 */
public class UserDAOTest {
    UserDAO userDao = new UserDAOImpl();

    @Test
    public void queryUserByUsername() {
        if (userDao.queryUserByUsername("admin1234") == null) {
            System.out.println("用户名可用！");
        } else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if (userDao.queryUserByUsernameAndPassword("admin", "admin1234") == null) {
            System.out.println("用户名或密码错误，登录失败");
        } else {
            System.out.println("查询成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null, "wzg168", "123456", "wzg168@qq.com")));
    }
}
