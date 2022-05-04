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
public class RegisterServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        // If code != abcde, go back to register page
        if (!code.equalsIgnoreCase("abcde")){
            System.out.println("验证码[" + code + "]错误");
            req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp); // Might need request info
            return;
        }

        // Check username
        if (userService.existsUsername(username)){
            // Username already exists
            System.out.println("用户名[" + username + "]已存在!");
            req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
            return;
        }

        // Save user
        userService.registerUser(new User(null, username, password,email));
        req.getRequestDispatcher("/pages/user/regist_success.html").forward(req,resp);
    }
}
