package com.haihui.book.bookstore_demo.service.impl;
/**
 * @author : lihai
 * @mailto : lihaihuifs@outlook.com
 * @created : 2022/5/9, 星期一
 * @version : 1.0
 **/

import com.haihui.book.bookstore_demo.dao.BookDAO;
import com.haihui.book.bookstore_demo.dao.OrderDAO;
import com.haihui.book.bookstore_demo.dao.impl.BookDAOImpl;
import com.haihui.book.bookstore_demo.dao.impl.OrderDAOImpl;
import com.haihui.book.bookstore_demo.dao.impl.OrderItemDAOImpl;
import com.haihui.book.bookstore_demo.entity.*;
import com.haihui.book.bookstore_demo.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @version : [v1.0]
 * @description :
 */
public class OrderServiceImpl implements OrderService {
    private OrderDAO orderDao = new OrderDAOImpl();
    private OrderItemDAOImpl orderItemDao = new OrderItemDAOImpl();
    private BookDAO bookDao = new BookDAOImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        // Create unique orderId
        String orderId = System.currentTimeMillis() + "" + userId;
        // Create Order with cart info and userId
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        // Save Order to DataBase
        orderDao.saveOrder(order);
        // Save OrderItem one by one
        Set<Map.Entry<Integer, CartItem>> items = cart.getItems().entrySet();
        for (Map.Entry<Integer, CartItem> itemEntry : items) {
            CartItem cartItem = itemEntry.getValue();
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
            orderItemDao.saveOrderItem(orderItem);
            // Update Book data
            // 更新库存和销量
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales() + cartItem.getCount());
            book.setStock(book.getStock() - cartItem.getCount());
            bookDao.updateBook(book);
        }

        // Clear cart
        cart.clear();
        return orderId;
    }

    @Override
    public List<Order> getOrderByUserId(Integer userId) {
        List<Order> orders = orderDao.getOrderByUserId(userId);
        return orders;
    }
}
