package com.atguigu.book.Dao;

import com.atguigu.book.pojo.Book;

import java.util.List;


public interface BookDAO {

    List<Book> getBookList();

    Book getBook(Integer id);


}
