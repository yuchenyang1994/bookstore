package com.oracleoaec.control;

import com.oracleoaec.entity.accounts;
import com.oracleoaec.service.Impl.AccountImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/4.
 */
public class AjaxCheckUsername extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        AccountImpl account = new AccountImpl();
        accounts accountByname = account.findAccountByname(username);
        if (accountByname!=null){
            HashMap<String,Integer> result = new HashMap<String,Integer>();
            result.put("result",0);
            ObjectMapper mapper = new ObjectMapper();
            String s = mapper.writeValueAsString(result);
            PrintWriter out = resp.getWriter();
            out.write(s);
            out.close();
            out.flush();
        }
        else{
            HashMap<String, Integer> result = new HashMap<String,Integer>();
            result.put("result",1);
            ObjectMapper mapper = new ObjectMapper();
            String s = mapper.writeValueAsString(result);
            PrintWriter out = resp.getWriter();
            out.write(s);
            out.close();
            out.flush();

        }
    }
}
