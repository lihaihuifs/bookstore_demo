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
import com.haihui.book.bookstore_demo.entity.Page;
import com.haihui.book.bookstore_demo.service.BookService;

import java.util.List;

/**
 * @version : [v1.0]
 * @description :
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

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();
        page.setPageSize(pageSize);

        // Must Calculate pageTotal first, because of boundary check
        Integer pageTotalCount = bookDAO.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }

        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);
        int begin = (page.getPageNo() - 1) * pageSize;
        List<Book> items = bookDAO.queryForPageItems(begin, pageSize);
        page.setItems(items);

        // Set page url
        page.setUrl("client/bookServlet?action=page");
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();
        page.setPageSize(pageSize);

        // Must Calculate pageTotal first, because of boundary check
        Integer pageTotalCount = bookDAO.queryForPageTotalCountByPrice(min,max);
        page.setPageTotalCount(pageTotalCount);
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }

        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);
        int begin = (page.getPageNo() - 1) * pageSize;
        List<Book> items = bookDAO.queryForPageItemsByPrice(begin, pageSize,min,max);
        page.setItems(items);

        // Set page url
        page.setUrl("client/bookServlet?action=pageByPrice");
        return page;
    }
}
