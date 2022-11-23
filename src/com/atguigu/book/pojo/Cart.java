package com.atguigu.book.pojo;

import java.util.Map;
import java.util.Set;

public class Cart {

    private Cart Id;

    //    购物车中的总金额
//    Map集合中key是book的id
    private Map<Integer, CartItem> cartItemMap;

    //    所有书总金额
    private Double totalMoney;

    //    购物车中项的数量
    private Integer totalCount;

    //    购物车书本数量
    private Integer totalBookCount;

   private Boolean isCartItemEmpty;

    public Boolean getCartItemEmpty() {
        if (cartItemMap!=null && cartItemMap.size()>0){

            this.isCartItemEmpty=false;

        }
        else {
            this.isCartItemEmpty=true;

        }


        return isCartItemEmpty;
    }

    public void setCartItemEmpty(Boolean cartItemEmpty) {
        isCartItemEmpty = cartItemEmpty;
    }

    public Integer getTotalBookCount() {
        totalBookCount = 0;
        if (cartItemMap != null && cartItemMap.size() > 0) {
            for (CartItem cartItem : cartItemMap.values()) {
                totalBookCount = totalBookCount + cartItem.getBuyCount();
            }
        }
        return totalBookCount;
    }

    public Cart() {

    }

    public Cart(Cart id, Map<Integer, CartItem> cartItemMap, Double totalMoney, Integer totalCount) {
        Id = id;
        this.cartItemMap = cartItemMap;
        this.totalMoney = totalMoney;
        this.totalCount = totalCount;
    }

    public void setId(Cart id) {
        Id = id;
    }

    public Map<Integer, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(Map<Integer, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public Double getTotalMoney() {
        totalMoney = 0.0;
        if (cartItemMap != null && cartItemMap.size() > 0) {

            Set<Map.Entry<Integer, CartItem>> entries = cartItemMap.entrySet();
            for (Map.Entry<Integer, CartItem> cartItemEntry : entries) {
                CartItem cartItem = cartItemEntry.getValue();
                totalMoney = totalMoney + cartItem.getBook().getPrice() * cartItem.getBuyCount();


            }
        }

        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getTotalCount() {
        totalCount = 0;

        if (cartItemMap != null && cartItemMap.size() > 0) {
            totalCount = cartItemMap.size();

        }
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
