package com.atguigu.book.Service.ServiceImp;

import com.atguigu.book.Dao.CartItemDAO;
import com.atguigu.book.Dao.OrderDAO;
import com.atguigu.book.Dao.OrderItemDAO;
import com.atguigu.book.Service.OrderService;
import com.atguigu.book.pojo.CartItem;
import com.atguigu.book.pojo.OrderBean;
import com.atguigu.book.pojo.OrderItem;
import com.atguigu.book.pojo.User;

import java.io.PushbackReader;
import java.util.List;
import java.util.Map;

public class OrderServiceImp implements OrderService {

    private OrderDAO orderDAO = null;
    private OrderItemDAO orderItemDAO = null;

    private CartItemDAO cartItemDAO = null;

    private Integer getOrderTotalBookCount;


    @Override
    public void addOrderBean(OrderBean orderBean) {
        orderDAO.addOrderBean(orderBean);

//        orderBean中的orderItemList为空
        User currUser = orderBean.getOrderUser();
        Map<Integer, CartItem> cartItemMap = currUser.getCart().getCartItemMap();

        for (CartItem cartItem : cartItemMap.values()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setBook(cartItem.getBook());
            orderItem.setBuyCount(cartItem.getBuyCount());
            orderItem.setOrderBean(orderBean);
            orderItemDAO.addOrderItem(orderItem);
        }
        for (CartItem cartItem : cartItemMap.values()) {
            cartItemDAO.delCartItem(cartItem);

        }

    }

    @Override
    public List<OrderBean> getOrderList(User user) {
        List<OrderBean> orderBeanList = orderDAO.getOrderList(user);
        for (OrderBean orderBean : orderBeanList) {
            Integer totalBookCount = orderDAO.getOrderTotalBookCount(orderBean);
            orderBean.setTotalBookCount(totalBookCount);

        }
        return orderBeanList;
    }
}
