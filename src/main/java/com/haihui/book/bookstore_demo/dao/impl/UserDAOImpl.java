package com.haihui.book.bookstore_demo.dao.impl;
/**
 * @author : lihai
 * @mailto : lihaihuifs@outlook.com
 * @created : 2022/5/3, 星期二
 * @version : 1.0
 **/

import com.haihui.book.bookstore_demo.dao.BaseDAO;
import com.haihui.book.bookstore_demo.dao.UserDAO;
import com.haihui.book.bookstore_demo.entity.User;

/**
 * @description  :
 * @version      : [v1.0]
 */
public class UserDAOImpl extends BaseDAO implements UserDAO {

    @Override
    public User queryUserByUsername(String username) {
        String sql =  "select `id`,`username`,`password`,`email` from t_user where username = ?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username = ? and password = ?";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(`username`,`password`,`email`) values (?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
