package com.atguigu.book.Service;

import com.atguigu.book.pojo.Cart;
import com.atguigu.book.pojo.CartItem;
import com.atguigu.book.pojo.User;

import java.util.List;

public interface CartService {
    void addCartItem(CartItem cartItem);
    void updateCartItem(CartItem cartItem);
    void updateCartItemOraddCartItem(CartItem cartItem, Cart cart);

    Cart getCart(User user);

    List<CartItem> getCartItemLIst(User user);


}
