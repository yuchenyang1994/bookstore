package com.oracleoaec.filter;

import com.oracleoaec.entity.Book;
import com.oracleoaec.service.Impl.BooksImp;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/3/1.
 */
public class AllBookFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException
    {
        BooksImp booksImp = new BooksImp();
        List<Book> allBooks = booksImp.findAllBooks();
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        request.setAttribute("books",allBooks);
        HttpSession session = request.getSession();
        if (session.getAttribute("account")!=null)
        {
            filterChain.doFilter(req,resp);
        }
        else{

            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
