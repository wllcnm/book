package com.atguigu.book.Dao;

import com.atguigu.book.pojo.OrderBean;
import com.atguigu.book.pojo.User;

import java.util.List;

public interface OrderDAO {
//    添加订单
    void addOrderBean(OrderBean orderBean);

    List<OrderBean> getOrderList(User user);

    Integer getOrderTotalBookCount(OrderBean orderBean);

}
