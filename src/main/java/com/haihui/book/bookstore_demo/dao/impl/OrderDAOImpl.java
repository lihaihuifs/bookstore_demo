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

/**
 * @description  :
 * @version      : [v1.0]
 */
public class OrderDAOImpl extends BaseDAO implements OrderDAO {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }

}
