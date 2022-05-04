package com.haihui.book.bookstore_demo.service;
/**
 * @author : lihai
 * @mailto : lihaihuifs@outlook.com
 * @created : 2022/5/3, 星期二
 * @version : 1.0
 **/

import com.haihui.book.bookstore_demo.entity.User;

/**
 * @description  :
 * @version      : [v1.0]
 */
public interface UserService {
    void registerUser(User user);
    User login(User user);
    boolean existsUsername(String username);
}