package com.oracleoaec.control;

import com.oracleoaec.entity.accounts;
import com.oracleoaec.service.Impl.AccountImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/3/1.
 */
public class Doregister extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String registerName = req.getParameter("account");
        String registerPassword = req.getParameter("password");
        String registeremail = req.getParameter("email");
        accounts accounts = new accounts();
        accounts.setAccount(registerName);
        accounts.setPassword(registerPassword);
        accounts.setMail(registeremail);
        AccountImpl accounted = new AccountImpl();
        int i = accounted.saveAccount(accounts);
        if (i==1){
            resp.sendRedirect("login.jsp");
        }
        else {
            req.setAttribute("result","注册失败");
            req.getRequestDispatcher("register.jsp").forward(req,resp);
        }
    }
}
