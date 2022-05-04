package com.haihui.book.bookstore_demo.dao;

import com.haihui.book.bookstore_demo.entity.User;

/**
 * @author : lihai
 * @version : 1.0
 * @mailto : lihaihuifs@outlook.com
 * @created : 2022/5/3, 星期二
 **/
public interface UserDAO {
    /**
     * Query user by username
     * @param username
     * @return if null, user doesn't exist
     */
    User queryUserByUsername(String username);

    /**
     * Query user by username + password
     * @param username
     * @param password
     * @return if null, either username or password is wrong
     */
    User queryUserByUsernameAndPassword(String username,String password);

    /**
     * Insert user record into database
     * @param user
     * @return if return -1, failed; others mean num of updated rows
     */
    int saveUser(User user);
}
