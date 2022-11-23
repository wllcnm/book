package com.atguigu.book.Dao;

import com.atguigu.book.pojo.OrderItem;
import com.atguigu.myssm.basedao.BaseDAO;

public class OrderItemDAOImp extends BaseDAO<OrderDAOImp> implements OrderItemDAO{
    @Override
    public void addOrderItem(OrderItem orderItem) {
       super.executeUpdate("insert into t_order_item values(0,?,?,?)",orderItem.getBook().getId(),orderItem.getBuyCount(),orderItem.getOrderBean().getId());

    }
}
