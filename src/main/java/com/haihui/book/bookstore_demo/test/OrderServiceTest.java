package com.haihui.book.bookstore_demo.test;
/**
 * @author : lihai
 * @mailto : lihaihuifs@outlook.com
 * @created : 2022/5/9, 星期一
 * @version : 1.0
 **/

import com.haihui.book.bookstore_demo.entity.Cart;
import com.haihui.book.bookstore_demo.entity.CartItem;
import com.haihui.book.bookstore_demo.service.OrderService;
import com.haihui.book.bookstore_demo.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @description  :
 * @version      : [v1.0]
 */
public class OrderServiceTest {
    @Test
    public void testCreateOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, new BigDecimal(100), new BigDecimal(100)));
        OrderService orderService = new OrderServiceImpl();
        System.out.println("订单号是：" + orderService.createOrder(cart, 1));
    }
    @Test
    public void showOrderTest(){
        OrderService orderService = new OrderServiceImpl();
    }
}
