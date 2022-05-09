package com.haihui.book.bookstore_demo.web;
/**
 * @author : lihai
 * @mailto : lihaihuifs@outlook.com
 * @created : 2022/5/9, 星期一
 * @version : 1.0
 **/

import com.haihui.book.bookstore_demo.entity.Cart;
import com.haihui.book.bookstore_demo.entity.Order;
import com.haihui.book.bookstore_demo.entity.OrderItem;
import com.haihui.book.bookstore_demo.entity.User;
import com.haihui.book.bookstore_demo.service.OrderService;
import com.haihui.book.bookstore_demo.service.impl.OrderServiceImpl;
import com.haihui.book.bookstore_demo.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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

    protected void showOrder(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        if (user == null){
            resp.sendRedirect(req.getContextPath() + "/pages/user/login.jsp");
            return;
        }

        List<Order> orders = orderService.getOrderByUserId(user.getId());
        req.setAttribute("orders",orders);
        req.getRequestDispatcher("/pages/order/order.jsp").forward(req,resp);
    }

}
