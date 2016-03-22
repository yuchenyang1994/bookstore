package com.oracleoaec.filter;

import com.oracleoaec.entity.Book;
import com.oracleoaec.service.Impl.BooksImp;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/3/1.
 */
public class BookFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
            throws IOException, ServletException
    {
        BooksImp booksImp = new BooksImp();
        List<Book> allBooks = booksImp.findAllBooks();
        ((HttpServletRequest)req).setAttribute("books",allBooks);
        filterChain.doFilter(req,resp);


    }

    @Override
    public void destroy() {

    }
}
