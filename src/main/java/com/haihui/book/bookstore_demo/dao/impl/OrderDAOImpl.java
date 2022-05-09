package com.haihui.book.bookstore_demo.dao.impl;
/**
 * @author : lihai
 * @mailto : lihaihuifs@outlook.com
 * @created : 2022/5/9, 星期一
 * @version : 1.0
 **/

import com.haihui.book.bookstore_demo.dao.BaseDAO;
import com.haihui.book.bookstore_demo.dao.OrderDAO;
import com.haihui.book.bookstore_demo.entity.Order;
import com.haihui.book.bookstore_demo.entity.OrderItem;

import java.util.List;

/**
 * @version : [v1.0]
 * @description :
 */
public class OrderDAOImpl extends BaseDAO implements OrderDAO {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";
        return update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }

    @Override
    public List<Order> getOrderByUserId(Integer userId) {
        String sql = "select `order_id`,`create_time` createTime,`price`,`status` from t_order where user_id = ?";
        return queryForList(Order.class, sql, userId);
    }

}
