package com.atguigu.book.Dao;

import com.atguigu.book.pojo.Book;
import com.atguigu.myssm.basedao.BaseDAO;

import java.util.List;

public class BookDAOImp extends BaseDAO<Book> implements BookDAO {
    @Override
    public List<Book> getBookList() {
        return executeQuery("select * from t_book");
    }

    @Override
    public Book getBook(Integer id) {

       return load("select * from t_book where id=?",id);

    }
}
