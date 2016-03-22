package com.oracleoaec.service.Impl;

import com.oracleoaec.dao.DaoFactory;
import com.oracleoaec.entity.Book;
import com.oracleoaec.service.IBooks;

import java.util.List;

/**
 * Created by Administrator on 2016/3/1.
 */
public class BooksImp implements IBooks {
    @Override
    public List findAllBooks()
    {
        return DaoFactory.getInstance("bookDao").findAll();
    }

    @Override
    public Book findBookById(int id) {
        return (Book) DaoFactory.getInstance("bookDao").findById(id);
    }
}
