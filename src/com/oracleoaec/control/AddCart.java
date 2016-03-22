package com.oracleoaec.control;

import com.oracleoaec.entity.Book;
import com.oracleoaec.entity.CartItem;
import com.oracleoaec.service.Impl.BooksImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2016/3/2.
 */
public class AddCart extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        int id = Integer.valueOf(req.getParameter("booksid"));
        BooksImp booksImp = new BooksImp();
        Book book = booksImp.findBookById(id);
        CartItem cartItem = null;
        HttpSession session = null;
        session=req.getSession();
        Map<Integer,CartItem> shopingCart = new HashMap<>();
        shopingCart = (Map<Integer, CartItem>) session.getAttribute("cart");
        if (shopingCart==null){
            shopingCart = new HashMap<>();
            cartItem=new CartItem();
            cartItem.setBook(book);
            shopingCart.put(book.getId(),cartItem);
            session.setAttribute("cart",shopingCart);
        }
        else {

            if (shopingCart.containsKey(id)){
                shopingCart.get(book.getId()).setQuantity(shopingCart.get(book.getId()).getQuantity()+1);
            }
            else {
                cartItem=new CartItem();
                cartItem.setBook(book);
                shopingCart.put(book.getId(),cartItem);
                session.setAttribute("cart",shopingCart);
            }
        }
        float total =0;
        for (Integer key:shopingCart.keySet()) {
            CartItem cartitem = shopingCart.get(key);
            total=total+cartitem.getTotal();
        }
        req.getSession().setAttribute("total",total);
        resp.sendRedirect("/page/books/detail.jsp");


    }
}
