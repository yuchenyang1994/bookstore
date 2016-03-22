package com.oracleoaec.filter;

import com.oracleoaec.entity.Consigness;
import com.oracleoaec.entity.Oders;
import com.oracleoaec.service.Impl.BooksImp;
import com.oracleoaec.service.Impl.ConsigneesImp;
import com.oracleoaec.service.Impl.OdersImp;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/3/4.
 */
public class AllOderFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException
    {
        OdersImp odersImp = new OdersImp();
        List<Oders> allOders = odersImp.findAllOders();
        ((HttpServletRequest)req).getSession().setAttribute("oderslist",allOders);
        filterChain.doFilter(req,resp);


    }

    @Override
    public void destroy() {

    }
}
