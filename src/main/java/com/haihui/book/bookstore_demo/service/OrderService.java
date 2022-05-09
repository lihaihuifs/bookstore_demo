package com.haihui.book.bookstore_demo.service;

import com.haihui.book.bookstore_demo.entity.Cart;

/**
 * @author : lihai
 * @version : 1.0
 * @mailto : lihaihuifs@outlook.com
 * @created : 2022/5/9, 星期一
 **/
public interface OrderService {
    String createOrder(Cart cart, Integer userId);
}
