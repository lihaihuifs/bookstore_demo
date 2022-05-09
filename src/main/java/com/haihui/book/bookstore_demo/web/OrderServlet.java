package com.haihui.book.bookstore_demo.web;
/**
 * @author : lihai
 * @mailto : lihaihuifs@outlook.com
 * @created : 2022/5/9, 星期一
 * @version : 1.0
 **/

import com.haihui.book.bookstore_demo.entity.Cart;
import com.haihui.book.bookstore_demo.entity.User;
import com.haihui.book.bookstore_demo.service.OrderService;
import com.haihui.book.bookstore_demo.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version : [v1.0]
 * @description :
 */
    public class OrderServlet extends BaseServlet {
        private OrderService orderService = new OrderServiceImpl();

        protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws
                ServletException, IOException {
            Cart cart = (Cart) req.getSession().getAttribute("cart");
            User loginUser = (User) req.getSession().getAttribute("user");
            if (loginUser == null) {
                req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
                return;
            }
            Integer userId = loginUser.getId();
            String orderId = orderService.createOrder(cart, userId);
            req.getSession().setAttribute("orderId", orderId);
            resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
        }
    }
