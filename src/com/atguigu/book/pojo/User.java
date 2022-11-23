package com.atguigu.book.pojo;

import java.util.List;

public class User {

   private Integer id;
    private String uname;
   private String pwd;
  private   String email;
    private Integer role;

    Cart cart;

  private   List<OrderBean> orderList;

    public User() {
    }


    public User(Integer id) {
        this.id = id;


    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", cart=" + cart +
                '}';
    }
    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {

        this.cart = cart;
    }

    public User(Integer id, String uname, String pwd, String email, Integer role, Cart cart) {
        this.id = id;
        this.uname = uname;
        this.pwd = pwd;
        this.email = email;
        this.role = role;
        this.cart = cart;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public List<OrderBean> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderBean> orderList) {
        this.orderList = orderList;
    }
}
