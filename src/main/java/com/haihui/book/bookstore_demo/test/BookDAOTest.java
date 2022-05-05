package com.haihui.book.bookstore_demo.test;
/**
 * @author : lihai
 * @mailto : lihaihuifs@outlook.com
 * @created : 2022/5/5, 星期四
 * @version : 1.0
 **/

import com.haihui.book.bookstore_demo.dao.BookDAO;
import com.haihui.book.bookstore_demo.dao.impl.BookDAOImpl;
import com.haihui.book.bookstore_demo.entity.Book;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @description  :
 * @version      : [v1.0]
 */
public class BookDAOTest {
        private BookDAO bookDao = new BookDAOImpl();
        @Test
        public void addBook() {
            bookDao.addBook(new Book(null,"国哥为什么这么帅！", "191125", new
                    BigDecimal(9999),1100000,0,null
            ));
        }
        @Test
        public void deleteBookById() {
            bookDao.deleteBookById(21);
        }
        @Test
        public void updateBook() {
            bookDao.updateBook(new Book(21,"大家都可以这么帅！", "国哥", new
                    BigDecimal(9999),1100000,0,null
            ));
        }
        @Test
        public void queryBookById() {
            System.out.println( bookDao.queryBookById(22) );
        }
        @Test
        public void queryBooks() {
            for (Book queryBook : bookDao.queryBooks()) {
                System.out.println(queryBook);
            }
        }
}
