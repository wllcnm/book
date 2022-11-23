package com.atguigu.book.Service.ServiceImp;

import com.atguigu.book.Dao.CartItemDAO;
import com.atguigu.book.Service.BookService;
import com.atguigu.book.Service.CartService;
import com.atguigu.book.pojo.Book;
import com.atguigu.book.pojo.Cart;
import com.atguigu.book.pojo.CartItem;
import com.atguigu.book.pojo.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartItemServiceImp implements CartService {
    private CartItemDAO cartItemDAO = null;

    private BookService bookService=null;

    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemDAO.addCartItem(cartItem);
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        cartItemDAO.updateCartItem(cartItem);
    }

    @Override
    public void updateCartItemOraddCartItem(CartItem cartItem, Cart cart) {
        if (cart != null) {

            Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();
            if (cartItemMap == null) {
                cartItemMap = new HashMap<>();
            }
            if (cartItemMap.containsKey(cartItem.getBook().getId())) {
                CartItem cartItem1 = cartItemMap.get(cartItem.getBook().getId());
                cartItem1.setBuyCount(cartItem1.getBuyCount() + 1);
                updateCartItem(cartItem1);
            } else {
                addCartItem(cartItem);
            }


        } else {

            addCartItem(cartItem);

        }


    }

    @Override
    public Cart getCart(User user) {
        List<CartItem> cartItemList = getCartItemLIst(user);
        Map<Integer, CartItem> cartItemMap = new HashMap<>();
        for (CartItem cartItem : cartItemList) {
            cartItemMap.put(cartItem.getBook().getId(), cartItem);
        }
        Cart cart = new Cart();
        cart.setCartItemMap(cartItemMap);
        return cart;
    }

    @Override
    public List<CartItem> getCartItemLIst(User user) {
        List<CartItem> cartItemList = cartItemDAO.getCartItemList(user);
        for(CartItem cartItem:cartItemList){
            Book book = bookService.getBook(cartItem.getBook().getId());
            cartItem.setBook(book);
        }
        return cartItemList;
    }
}
