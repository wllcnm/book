package com.atguigu.book.pojo;

public class CartItem {
    private Integer id;
    private Book book;
    private Integer buyCount;
    private User userBean;

    public CartItem(Book book, Integer buyCount, User USER) {
        this.book = book;
        this.buyCount = buyCount;
        this.userBean = USER;
    }

    public CartItem() {
    }

    public CartItem(Integer id) {
        this.id = id;
    }

    public CartItem(Integer cartItemId, Integer buyCount) {
        this.id=cartItemId;
        this.buyCount=buyCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public User getUserBean() {
        return userBean;
    }

    public void setUserBean(User userBean) {
        this.userBean = userBean;
    }
}
