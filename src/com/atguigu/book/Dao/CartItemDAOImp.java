package com.atguigu.book.Dao;

import com.atguigu.book.pojo.CartItem;
import com.atguigu.book.pojo.User;
import com.atguigu.myssm.basedao.BaseDAO;
import org.apache.commons.dbutils.QueryRunner;

import java.util.List;

public class CartItemDAOImp extends BaseDAO<CartItem> implements CartItemDAO {
    @Override
    public void addCartItem(CartItem cartItem) {
        executeUpdate("insert into t_cart_item values(0,?,?,?)", cartItem.getBook().getId(), cartItem.getBuyCount(), cartItem.getUserBean().getId());
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        executeUpdate("update t_cart_item set buyCount=? where id=? ", cartItem.getBuyCount(), cartItem.getId());
    }

    @Override
    public List<CartItem> getCartItemList(User user) {
        return executeQuery("select * from t_cart_item where userBean=?", user.getId());
    }

    @Override
    public void delCartItem(CartItem cartItem) {
        super.executeUpdate("delete from t_cart_item where id=?", cartItem.getId());
    }


}
