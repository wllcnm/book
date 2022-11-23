package com.atguigu.book.Controller;

import com.atguigu.book.Service.CartService;
import com.atguigu.book.Service.UserService;
import com.atguigu.book.pojo.Cart;
import com.atguigu.book.pojo.User;

import javax.servlet.http.HttpSession;

public class UserController {

    private UserService userService = null;
    private CartService cartService = null;

    public String login(String uname, String pwd, HttpSession session) {
        User user = userService.login(uname, pwd);
        System.out.println("userService = " + userService);
        System.out.println("login = " + user);
        System.out.println("user = " + user);

        if (user != null) {
            Cart cart =  cartService.getCart(user);
            user.setCart(cart);
            session.setAttribute("currUser", user);
            return "redirect:book.do";

        }

        return "user/login";


    }


    public String cancellation(HttpSession session){
        session.removeAttribute("currUser");
        return "user/login";
    }


}
