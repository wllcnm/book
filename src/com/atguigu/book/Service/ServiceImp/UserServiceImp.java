package com.atguigu.book.Service.ServiceImp;

import com.atguigu.book.Dao.UserDAO;
import com.atguigu.book.Service.UserService;
import com.atguigu.book.pojo.User;

public class UserServiceImp implements UserService {
    private UserDAO userDAO=null;

    @Override
    public User login(String uname, String pwd) {
        System.out.println("userDAO = " + userDAO);

        return userDAO.getUser(uname, pwd);
    }
}
