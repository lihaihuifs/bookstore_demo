package com.haihui.book.bookstore_demo.web;
/**
 * @author : lihai
 * @mailto : lihaihuifs@outlook.com
 * @created : 2022/5/4, 星期三
 * @version : 1.0
 **/

import com.haihui.book.bookstore_demo.entity.User;
import com.haihui.book.bookstore_demo.service.UserService;
import com.haihui.book.bookstore_demo.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description  :
 * @version      : [v1.0]
 */
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Do Post LoginServlet");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User(null, username, password, null);
        User login = userService.login(user);

        if (login == null){
            System.out.println("Log in Failed");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        } else {
            System.out.println("Log in Succeeded");
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }
}
