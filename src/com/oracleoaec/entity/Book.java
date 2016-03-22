package com.oracleoaec.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/2/29.
 */
public class Book {
    private int id;//id
    private String name;//书名
    private float selling_price;//售价
    private String description;//摘要
    private String instroduction;//介绍
    private int grade;//等级
    private int purchase_price;//进价
    private String image;//图片
    private String isbn;//出版id
    private String book_concern;//出版社
    private Date publishing_date;//出版日期
    private String author;//作者
    private String author_introduction;//作者介绍
    private List<BookChapter> bookChapterList;

    public Book() {
    }

    public Book(int id, String name, float selling_price, String description, String instroduction, int grade, int purchase_price, String image, String isbn, String book_concern, Date publishing_date, String author, String author_introduction) {
        this.id = id;
        this.name = name;
        this.selling_price = selling_price;
        this.description = description;
        this.instroduction = instroduction;
        this.grade = grade;
        this.purchase_price = purchase_price;
        this.image = image;
        this.isbn = isbn;
        this.book_concern = book_concern;
        this.publishing_date = publishing_date;
        this.author = author;
        this.author_introduction = author_introduction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(float selling_price) {
        this.selling_price = selling_price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstroduction() {
        return instroduction;
    }

    public void setInstroduction(String instroduction) {
        this.instroduction = instroduction;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getPurchase_price() {
        return purchase_price;
    }

    public void setPurchase_price(int purchase_price) {
        this.purchase_price = purchase_price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBook_concern() {
        return book_concern;
    }

    public void setBook_concern(String book_concern) {
        this.book_concern = book_concern;
    }

    public Date getPublishing_date() {
        return publishing_date;
    }

    public void setPublishing_date(Date publishing_date) {
        this.publishing_date = publishing_date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor_introduction() {
        return author_introduction;
    }

    public void setAuthor_introduction(String author_introduction) {
        this.author_introduction = author_introduction;
    }

    public List<BookChapter> getBookChapterList() {
        return bookChapterList;
    }

    public void setBookChapterList(List<BookChapter> bookChapterList) {
        this.bookChapterList = bookChapterList;
    }
}
