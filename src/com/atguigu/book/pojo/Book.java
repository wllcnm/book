package com.atguigu.book.pojo;

public class Book {
    private Integer id;
    private  String bookName ;
    private  String bookImg ;
    private  Double price;
    private  String author;


    private  Integer salCount;
    private  Integer bookCount;
    private  Integer bookStatus;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", bookImg='" + bookImg + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", salCount=" + salCount +
                ", bookCount=" + bookCount +
                ", bookStatus=" + bookStatus +
                '}';
    }

    public Book(){
    }



    public Book(Integer id){
        this.id=id;
    }


    public Integer getSalCount() {
        return salCount;
    }

    public void setSalCount(Integer salCount) {
        this.salCount = salCount;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookImg() {
        return bookImg;
    }

    public void setBookImg(String bookImg) {
        this.bookImg = bookImg;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public Integer getBookCount() {
        return bookCount;
    }

    public void setBookCount(Integer bookCount) {
        this.bookCount = bookCount;
    }

    public Integer getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Integer bookStatus) {
        this.bookStatus = bookStatus;
    }
}
