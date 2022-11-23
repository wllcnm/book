package com.atguigu.book.Service;

import com.atguigu.book.pojo.Book;

import java.util.List;

public interface BookService {

    List<Book> getBookList();

    Book getBook(Integer id);


}
