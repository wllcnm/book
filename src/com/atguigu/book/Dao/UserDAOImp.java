package com.atguigu.book.Dao;

import com.atguigu.book.pojo.User;
import com.atguigu.myssm.basedao.BaseDAO;

public class UserDAOImp extends BaseDAO<User> implements UserDAO {
    @Override
    public User getUser(String uname, String pwd) {
      return   load("select * from t_user where uname=? and pwd=?",uname,pwd);

    }
}
