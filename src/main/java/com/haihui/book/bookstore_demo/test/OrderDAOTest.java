package com.haihui.book.bookstore_demo.test;
/**
 * @author : lihai
 * @mailto : lihaihuifs@outlook.com
 * @created : 2022/5/9, 星期一
 * @version : 1.0
 **/

import com.haihui.book.bookstore_demo.dao.OrderDAO;
import com.haihui.book.bookstore_demo.dao.OrderItemDAO;
import com.haihui.book.bookstore_demo.dao.impl.OrderDAOImpl;
import com.haihui.book.bookstore_demo.dao.impl.OrderItemDAOImpl;
import com.haihui.book.bookstore_demo.entity.Order;
import com.haihui.book.bookstore_demo.entity.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @description  :
 * @version      : [v1.0]
 */
public class OrderDAOTest {
    @Test
    public void saveOrder() {
        OrderDAO orderDao = new OrderDAOImpl();
        orderDao.saveOrder(new Order("1234567890",new Date(),new BigDecimal(100),0, 1));
    }

    @Test
    public void saveOrderItem() {
        OrderItemDAO orderItemDAO = new OrderItemDAOImpl();
        orderItemDAO.saveOrderItem(new OrderItem(null,"java 从入门到精通", 1,new BigDecimal(100),new
                BigDecimal(100),"1234567890"));
        orderItemDAO.saveOrderItem(new OrderItem(null,"javaScript 从入门到精通", 2,new
                BigDecimal(100),new BigDecimal(200),"1234567890"));
        orderItemDAO.saveOrderItem(new OrderItem(null,"Netty 入门", 1,new BigDecimal(100),new
                BigDecimal(100),"1234567890"));
    }

    @Test
    public void getOrderByUserIdTest(){
        OrderDAO orderDao = new OrderDAOImpl();
        List<Order> orders = orderDao.getOrderByUserId(1);
        System.out.println(Arrays.toString(orders.toArray()));
    }
}


