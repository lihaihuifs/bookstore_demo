package com.haihui.book.bookstore_demo.service.impl;
/**
 * @author : lihai
 * @mailto : lihaihuifs@outlook.com
 * @created : 2022/5/5, 星期四
 * @version : 1.0
 **/

import com.haihui.book.bookstore_demo.dao.BookDAO;
import com.haihui.book.bookstore_demo.dao.impl.BookDAOImpl;
import com.haihui.book.bookstore_demo.entity.Book;
import com.haihui.book.bookstore_demo.service.BookService;

import java.util.List;

/**
 * @description  :
 * @version      : [v1.0]
 */
public class BookServiceImpl implements BookService {

    private static BookDAO bookDAO = new BookDAOImpl();

    @Override
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDAO.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDAO.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDAO.queryBooks();
    }
}
