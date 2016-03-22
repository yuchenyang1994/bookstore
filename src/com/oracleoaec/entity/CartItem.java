package com.oracleoaec.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/2/29.
 */
public class CartItem implements Serializable
{
    private Book book;
    private int quantity = 1;
    private float Total;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CartItem() {
        // TODO Auto-generated constructor stub
    }

    public CartItem(Book book) {
        this.book = book;
    }

    public float getTotal(){
        return book.getSelling_price()*quantity;
    }

}
