package com.oracleoaec.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Administrator on 2016/3/2.
 */
public class Userfilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        Object account = session.getAttribute("account");
       if(account==null){
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }
        else {
           filterChain.doFilter(req,resp);
       }
    }

    @Override
    public void destroy() {

    }
}
