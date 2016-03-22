package com.oracleoaec.control;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/3/7.
 */
public class Doexit extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String account = (String) req.getSession().getAttribute("account");
        req.getSession().removeAttribute(account);
        resp.sendRedirect("index.jsp");
    }
}
