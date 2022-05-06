package com.haihui.book.bookstore_demo.dao;

import com.haihui.book.bookstore_demo.entity.Book;

import java.util.List;

/**
 * @author : lihai
 * @version : 1.0
 * @mailto : lihaihuifs@outlook.com
 * @created : 2022/5/5, 星期四
 **/
public interface BookDAO {
     int addBook(Book book);
     int deleteBookById(Integer id);
     int updateBook(Book book);
     Book queryBookById(Integer id);
     List<Book> queryBooks();

     Integer queryForPageTotalCount();
     List<Book> queryForPageItems(int begin, int pageSize);
}
