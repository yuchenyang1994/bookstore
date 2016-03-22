package com.oracleoaec.entity;

/**
 * Created by Administrator on 2016/3/4.
 */
public class OrdersItem
{
    int itemID;
    int booksId;
    int count;

    public OrdersItem() {
    }

    public OrdersItem(int itemID, int booksId, int count) {
        this.itemID = itemID;
        this.booksId = booksId;
        this.count = count;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getBooksId() {
        return booksId;
    }

    public void setBooksId(int booksId) {
        this.booksId = booksId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
