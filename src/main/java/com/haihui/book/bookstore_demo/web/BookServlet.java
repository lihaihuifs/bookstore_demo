package com.haihui.book.bookstore_demo.web;
/**
 * @author : lihai
 * @mailto : lihaihuifs@outlook.com
 * @created : 2022/5/5, 星期四
 * @version : 1.0
 **/

import com.haihui.book.bookstore_demo.entity.Book;
import com.haihui.book.bookstore_demo.entity.Page;
import com.haihui.book.bookstore_demo.entity.User;
import com.haihui.book.bookstore_demo.service.BookService;
import com.haihui.book.bookstore_demo.service.impl.BookServiceImpl;
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
public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    public void list(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Book> books = bookService.queryBooks();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    public void add(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Use WebUtils to inject field data
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        // Save book
        bookService.addBook(book);
        // Redirect: avoid repeats of submission;
        // List all books
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }

    public void update(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        bookService.updateBook(book);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String idParam = req.getParameter("id");
        Integer id = WebUtils.parseInt(idParam, 0); // Return 0 if not found, MySQL starts at 1
        bookService.deleteBookById(id);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }

    public void getBook(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);
        req.setAttribute("book", book);
        req.getRequestDispatcher("/manager/book_edit.jsp").forward(req, resp);
    }

    public void page(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page = bookService.page(pageNo, pageSize);
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }

}
