package com.oracleoaec.control;

import com.oracleoaec.entity.Book;
import com.oracleoaec.service.Impl.BooksImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/3/2.
 */
public class BookServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        BooksImp booksImp = new BooksImp();
        String bookid = req.getParameter("bookid");
        int id = Integer.parseInt(bookid);
        Book bookById = booksImp.findBookById(id);
        req.setAttribute("books",bookById);
        req.getRequestDispatcher("page/books/booksmore.jsp").forward(req,resp);
    }
}
