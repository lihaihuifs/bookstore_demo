package com.haihui.book.bookstore_demo.web;
/**
 * @author : lihai
 * @mailto : lihaihuifs@outlook.com
 * @created : 2022/5/8, 星期日
 * @version : 1.0
 **/

import com.haihui.book.bookstore_demo.entity.Book;
import com.haihui.book.bookstore_demo.entity.Cart;
import com.haihui.book.bookstore_demo.entity.CartItem;
import com.haihui.book.bookstore_demo.service.BookService;
import com.haihui.book.bookstore_demo.service.impl.BookServiceImpl;
import com.haihui.book.bookstore_demo.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version : [v1.0]
 * @description :
 */
public class CartServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Query for book
        int bookId = WebUtils.parseInt(req.getParameter("id"), 0);
        Book book = bookService.queryBookById(bookId);
        // Add to cart
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        // If not exists, creat cart and save to session
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        cart.addItem(cartItem);

        // Save last added item name
        req.getSession().setAttribute("lastAddedItem", cartItem.getName());

        // Redirect to the page
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = WebUtils.parseInt(req.getParameter("id"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.deleteItem(bookId);
            // Redirect to the page
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.clear();
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        int count = WebUtils.parseInt(req.getParameter("count"), 1);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.updateCount(id, count);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
}