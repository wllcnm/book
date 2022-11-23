package com.atguigu.book.Dao;

import com.atguigu.book.pojo.OrderBean;
import com.atguigu.book.pojo.User;
import com.atguigu.myssm.basedao.BaseDAO;

import java.math.BigDecimal;
import java.util.List;

public class OrderDAOImp extends BaseDAO<OrderBean> implements OrderDAO {
    @Override
    public void addOrderBean(OrderBean orderBean) {
        int orderBeanId = super.executeUpdate("insert into t_order values(0,?,?,?,?,?)", orderBean.getOrderNo(), orderBean.getOrderDate(), orderBean.getOrderMoney(), orderBean.getOrderUser().getId(), orderBean.getOrderStatus());
        orderBean.setId(orderBeanId);

    }

    @Override
    public List<OrderBean> getOrderList(User user) {

        return executeQuery("select * from t_order where orderUser=?", user.getId());
    }

    @Override
    public Integer getOrderTotalBookCount(OrderBean orderBean) {
        String sql = "SELECT SUM(t3.buyCount) AS totalBookCount , t3.orderBean FROM " +
                "(" +
                "SELECT t1.id , t2.buyCount , t2.orderBean FROM t_order t1 INNER JOIN t_order_item t2 " +
                "ON t1.id = t2.orderBean WHERE t1.orderUser = ? " +
                ") t3 WHERE t3.orderBean = ? GROUP BY t3.orderBean" ;

        if (executeComplexQuery(sql,orderBean.getOrderUser().getId(),orderBean.getId())!=null){

            return ((BigDecimal)executeComplexQuery(sql,orderBean.getOrderUser().getId(),orderBean.getId())[0]).intValue();
        }
       else {
           return 0;

        }
    }
}
