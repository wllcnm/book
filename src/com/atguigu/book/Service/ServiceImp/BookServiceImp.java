package com.atguigu.book.Service.ServiceImp;

import com.atguigu.book.Dao.BookDAO;
import com.atguigu.book.Service.BookService;
import com.atguigu.book.pojo.Book;

import java.util.List;

public class BookServiceImp implements BookService {
    private BookDAO bookDAO=null;


    @Override
    public List<Book> getBookList() {
        return bookDAO.getBookList();
    }

    @Override
    public Book getBook(Integer id) {

       return bookDAO.getBook(id);
    }
}
