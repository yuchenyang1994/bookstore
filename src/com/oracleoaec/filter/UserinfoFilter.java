package com.oracleoaec.filter;

import com.oracleoaec.entity.accounts;
import com.oracleoaec.service.Impl.AccountImpl;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Administrator on 2016/3/4.
 */
public class UserinfoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException
    {
        String account = (String)((HttpServletRequest) req).getSession().getAttribute("account");
        AccountImpl accountImp = new AccountImpl();
        accounts accounts = accountImp.findAccountByname(account);
        req.setAttribute("accountinfo",accounts);
        filterChain.doFilter(req,resp);

    }

    @Override
    public void destroy() {

    }
}
