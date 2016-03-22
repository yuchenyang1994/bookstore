package com.oracleoaec.control;

import com.oracleoaec.entity.accounts;
import com.oracleoaec.service.Impl.AccountImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Administrator on 2016/3/1.
 */
public class DoLogin extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String loginName = req.getParameter("account");
        String loginPassword = req.getParameter("password");
        AccountImpl account = new AccountImpl();
        accounts accounted = account.findAccountByPassword(loginName, loginPassword);
        if (accounted!=null){
            HttpSession session = req.getSession();
            session.setAttribute("account",loginName);
            resp.sendRedirect("./page/books/detail.jsp");
        }
        else {
            String message = "用户或密码错误";
            req.setAttribute("message",message);
            req.setAttribute("meassageclass","alert alert-danger");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
}
