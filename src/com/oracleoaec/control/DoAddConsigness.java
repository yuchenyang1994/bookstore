package com.oracleoaec.control;

import com.oracleoaec.entity.Consigness;
import com.oracleoaec.entity.accounts;
import com.oracleoaec.service.IAccount;
import com.oracleoaec.service.Impl.AccountImpl;
import com.oracleoaec.service.Impl.ConsigneesImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/3/3.
 */
public class DoAddConsigness extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String full_name = req.getParameter("name");
        String tel = req.getParameter("tel");
        String city = req.getParameter("city");
        String extra = req.getParameter("address");
        String accountName = (String) req.getSession().getAttribute("account");
        AccountImpl accountImp = new AccountImpl();
        accounts accounts = accountImp.findAccountByname(accountName);
        ConsigneesImp consigneesImp = new ConsigneesImp();
        Consigness consigness = new Consigness();
        int id = accounts.getId();
        System.out.println(id);
        consigness.setFull_name(full_name);
        consigness.setCity(city);
        consigness.setTel(tel);
        consigness.setExtra(extra);
        consigness.setProvince("江苏省");
        consigness.setAccount_id(id);
        System.out.println(consigness);
        int i = consigneesImp.saveConsignees(consigness);
        //System.out.println(i);
        if (i==0){
            System.out.println("保存失败");
        }
        else {
            System.out.println("保存成功");
        }

        System.out.println(i);
        resp.sendRedirect("/page/user/userinfo.jsp");
    }
}
