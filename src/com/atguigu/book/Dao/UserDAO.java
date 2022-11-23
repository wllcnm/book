package com.atguigu.book.Dao;

import com.atguigu.book.pojo.User;

public interface UserDAO {
    User getUser(String uname,String pwd);

}
