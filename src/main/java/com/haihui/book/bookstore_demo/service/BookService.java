package com.haihui.book.bookstore_demo.service;
/**
 * @author : lihai
 * @mailto : lihaihuifs@outlook.com
 * @created : 2022/5/5, 星期四
 * @version : 1.0
 **/

import com.haihui.book.bookstore_demo.entity.Book;
import com.haihui.book.bookstore_demo.entity.Page;

import java.util.List;

/**
 * @version : [v1.0]
 * @description :
 */
public interface BookService {
    void addBook(Book book);

    void deleteBookById(Integer id);

    void updateBook(Book book);

    Book queryBookById(Integer id);

    List<Book> queryBooks();

    Page<Book> page(int pageNo, int pageSize);
}
