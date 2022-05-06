package com.haihui.book.bookstore_demo.web;
/**
 * @author : lihai
 * @mailto : lihaihuifs@outlook.com
 * @created : 2022/5/6, 星期五
 * @version : 1.0
 **/

import com.haihui.book.bookstore_demo.entity.Book;
import com.haihui.book.bookstore_demo.entity.Page;
import com.haihui.book.bookstore_demo.service.BookService;
import com.haihui.book.bookstore_demo.service.impl.BookServiceImpl;
import com.haihui.book.bookstore_demo.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description  :
 * @version      : [v1.0]
 */
public class ClientBookServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();

    public void page(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page = bookService.page(pageNo, pageSize);
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }

    public void pageByPrice(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize,min,max);
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }

}
