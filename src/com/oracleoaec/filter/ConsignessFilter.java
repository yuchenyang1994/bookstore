package com.oracleoaec.filter;

import com.oracleoaec.entity.Consigness;
import com.oracleoaec.entity.accounts;
import com.oracleoaec.service.IConsignee;
import com.oracleoaec.service.Impl.AccountImpl;
import com.oracleoaec.service.Impl.ConsigneesImp;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/3/4.
 */
public class ConsignessFilter implements Filter
{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException
    {
        String account = (String)((HttpServletRequest) req).getSession().getAttribute("account");
        AccountImpl accountImp = new AccountImpl();
        accounts accounts = accountImp.findAccountByname(account);
        int id = accounts.getId();
        IConsignee consigneesImp = new ConsigneesImp();
        System.out.println(id);
        List<Consigness> consigneesByid = consigneesImp.findConsigneesByid(id);
        ((HttpServletRequest) req).getSession().setAttribute("conList",consigneesByid);
        filterChain.doFilter(req,resp);
    }

    @Override
    public void destroy() {

    }
}
