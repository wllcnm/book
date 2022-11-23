package com.atguigu.book.Service;

import com.atguigu.book.pojo.OrderBean;
import com.atguigu.book.pojo.User;

import java.util.List;

public interface OrderService {
void addOrderBean(OrderBean orderBean);

List<OrderBean> getOrderList(User user);


}
