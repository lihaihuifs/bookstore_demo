package com.haihui.book.bookstore_demo.web;
/**
 * @author : lihai
 * @mailto : lihaihuifs@outlook.com
 * @created : 2022/5/5, 星期四
 * @version : 1.0
 **/

import com.haihui.book.bookstore_demo.entity.User;
import com.haihui.book.bookstore_demo.service.UserService;
import com.haihui.book.bookstore_demo.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @description  :
 * @version      : [v1.0]
 */
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User(null, username, password, null);
        User login = userService.login(user);

        if (login == null){
            System.out.println("Log in Failed");
            req.setAttribute("msg","Username or password is wrong.");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        } else {
            System.out.println("Log in Succeeded");
            req.getSession().setAttribute("user",login);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }

    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        // Check kaptcha verification code
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY); // Delete Token

        // If code != abcde, go back to register page
        if (code == null || !code.equalsIgnoreCase(token)){
            System.out.println("验证码[" + code + "]错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp); // Might need request info
            return;
        }

        // Check username
        if (userService.existsUsername(username)){
            // Username already exists
            System.out.println("用户名[" + username + "]已存在!");
            req.setAttribute("msg","Username already exists.");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            return;
        }

        // Save user
        userService.registerUser(new User(null, username, password,email));
        req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
    }

    public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.getSession().invalidate(); // Destroy session
        resp.sendRedirect(req.getContextPath()); // Back to index.jsp
    }
}
