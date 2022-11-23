package com.atguigu.book.Controller;

import com.atguigu.book.Service.CartService;
import com.atguigu.book.pojo.Book;
import com.atguigu.book.pojo.Cart;
import com.atguigu.book.pojo.CartItem;
import com.atguigu.book.pojo.User;
import com.google.gson.Gson;

import javax.servlet.http.HttpSession;

public class CartController {

    private CartService cartService = null;

    //    加载购物车信息
    public String index(HttpSession session) {
        User user = (User) session.getAttribute("currUser");
        Cart cart = cartService.getCart(user);

        user.setCart(cart);

        session.setAttribute("currUser", user);
        return "cart/cart";
    }


    public String addCart(Integer bookId, HttpSession session) {
        User user = (User) session.getAttribute("currUser");

        CartItem cartItem = new CartItem(new Book(bookId), 1, user);


//        将图书加入到购物车中
//        1.如果已存在,则图书数量加一
//        2.如果没有,则CartItem加1
        cartService.updateCartItemOraddCartItem(cartItem, (Cart) user.getCart());

        return "redirect:cart.do";


    }

    public String editCart(Integer cartItemId, Integer buyCount) {
        cartService.updateCartItem(new CartItem(cartItemId, buyCount));


        return "";
    }

    public String cartInfo(HttpSession session){
        User user = (User) session.getAttribute("currUser");
        Cart cart = cartService.getCart(user);


//        调用cart中的getToatalMoney方法得到总金额,将值赋值到属性上,
//        从而返回json时,属性上就有值了,不为空
        cart.getTotalMoney();
        cart.getTotalBookCount();
        cart.getTotalCount();
        cart.getCartItemEmpty();


        Gson gson=new Gson();
        String cartObj = gson.toJson(cart);
        return "json:"+cartObj;



    }
}
