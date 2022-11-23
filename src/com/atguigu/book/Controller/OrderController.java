package com.atguigu.book.Controller;

import com.alibaba.druid.sql.visitor.functions.Now;
import com.atguigu.book.Service.OrderService;
import com.atguigu.book.pojo.OrderBean;
import com.atguigu.book.pojo.User;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.SimpleFormatter;

public class OrderController {

    private OrderService orderService = null;

    public String checkout(HttpSession session) {
        OrderBean orderBean = new OrderBean();
        Date now = new Date();
        int year = now.getYear();
        int month = now.getMonth();
        int day = now.getDay();
        int hour = now.getHours();
        int min = now.getMinutes();
        int sec = now.getSeconds();
        orderBean.setOrderNo(UUID.randomUUID().toString() + "_" + year + month + day + hour + sec);
        orderBean.setOrderDate(now);

        User user = (User) session.getAttribute("currUser");
        orderBean.setOrderUser(user);
        orderBean.setOrderMoney(user.getCart().getTotalMoney());
        orderBean.setOrderStatus(0);


        orderService.addOrderBean(orderBean);

        return "redirect:book.do";
    }

    public String getOrderList(HttpSession session) {
        User currUser = (User) session.getAttribute("currUser");
        List<OrderBean> orderList = orderService.getOrderList(currUser);
        currUser.setOrderList(orderList);
        session.setAttribute("currUser", currUser);

        return "order/order";

    }


}
