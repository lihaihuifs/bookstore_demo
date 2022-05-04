package com.haihui.book.bookstore_demo.service.impl;
/**
 * @author : lihai
 * @mailto : lihaihuifs@outlook.com
 * @created : 2022/5/3, 星期二
 * @version : 1.0
 **/

import com.haihui.book.bookstore_demo.dao.UserDAO;
import com.haihui.book.bookstore_demo.dao.impl.UserDAOImpl;
import com.haihui.book.bookstore_demo.entity.User;
import com.haihui.book.bookstore_demo.service.UserService;
import org.omg.CORBA.UserException;

/**
 * @description  :
 * @version      : [v1.0]
 */
public class UserServiceImpl implements UserService {

    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public void registerUser(User user) {
        if (existsUsername(user.getUsername())){
            return;
        }
        userDAO.saveUser(user);
    }

    @Override
    public User login(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        User loginUser = userDAO.queryUserByUsernameAndPassword(username, password);
        return loginUser;
    }

    @Override
    public boolean existsUsername(String username) {
        User user = userDAO.queryUserByUsername(username);
        if (user != null){
            return true;
        }
        return false;
    }
}
