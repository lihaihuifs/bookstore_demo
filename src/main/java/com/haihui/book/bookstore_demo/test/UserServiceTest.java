package com.haihui.book.bookstore_demo.test;
/**
 * @author : lihai
 * @mailto : lihaihuifs@outlook.com
 * @created : 2022/5/4, 星期三
 * @version : 1.0
 **/

import com.haihui.book.bookstore_demo.entity.User;
import com.haihui.book.bookstore_demo.service.UserService;
import com.haihui.book.bookstore_demo.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @description  :
 * @version      : [v1.0]
 */
public class UserServiceTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void registerUser() {
        userService.registerUser(new User(null, "bbj168", "666666", "bbj168@qq.com"));
        userService.registerUser(new User(null, "abc168", "666666", "abc168@qq.com"));
    }
    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "wzg168", "123456", null)) );
    }
    @Test
    public void existsUsername() {
        if (userService.existsUsername("wzg16888")) {
            System.out.println("用户名已存在！");
        } else {
            System.out.println("用户名可用！");
        }
    }
}
