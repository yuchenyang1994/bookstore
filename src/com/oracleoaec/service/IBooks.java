package com.oracleoaec.service;

import com.oracleoaec.entity.Book;

import java.util.List;

/**
 * Created by Administrator on 2016/3/1.
 */
public interface IBooks
{
    public List findAllBooks();
    public Book findBookById(int id);
}
