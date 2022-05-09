package com.haihui.book.bookstore_demo.dao;

import com.haihui.book.bookstore_demo.entity.Order;
import com.haihui.book.bookstore_demo.entity.OrderItem;

/**
 * @author : lihai
 * @version : 1.0
 * @mailto : lihaihuifs@outlook.com
 * @created : 2022/5/9, 星期一
 **/
public interface OrderDAO {
    /**
     * Save Order
     *
     * @param order
     * @return
     */
    int saveOrder(Order order);
}
