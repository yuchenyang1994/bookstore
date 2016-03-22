package com.oracleoaec.control;

import com.oracleoaec.entity.CartItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/3.
 */
public class DeleteCart extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String books = req.getParameter("booksid");
        Integer booksid = Integer.parseInt(books);
        Map<Integer,CartItem> shopingCart = (Map<Integer, CartItem>)req.getSession().getAttribute("cart");
        float total=(Float)req.getSession().getAttribute("total");
        float bookstotal = shopingCart.get(booksid).getTotal();
        total=total-bookstotal;
        shopingCart.remove(booksid);
        req.getSession().setAttribute("total",total);
        req.getSession().setAttribute("cart",shopingCart);
        resp.sendRedirect("page/user/cart.jsp");
    }
}
