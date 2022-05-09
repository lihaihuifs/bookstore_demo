package com.haihui.book.bookstore_demo.dao;

import com.haihui.book.bookstore_demo.entity.OrderItem;

/**
 * @author : lihai
 * @version : 1.0
 * @mailto : lihaihuifs@outlook.com
 * @created : 2022/5/9, 星期一
 **/
public interface OrderItemDAO {
    int saveOrderItem(OrderItem orderItem);
}
