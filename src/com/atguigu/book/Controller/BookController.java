package com.atguigu.book.Controller;

import com.atguigu.book.Service.BookService;
import com.atguigu.book.pojo.Book;

import javax.servlet.http.HttpSession;
import java.util.List;

public class BookController {
    private BookService bookService=null;
    public String index(HttpSession session){
        List<Book> bookList=bookService.getBookList();
        System.out.println("bookList = " + bookList);
        session.setAttribute("bookList",bookList);
        return "index";
    }



}
