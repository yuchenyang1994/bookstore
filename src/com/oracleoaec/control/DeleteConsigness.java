package com.oracleoaec.control;

import com.oracleoaec.service.IConsignee;
import com.oracleoaec.service.Impl.ConsigneesImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/3/4.
 */
public class DeleteConsigness extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String conid = req.getParameter("conid");
        System.out.println(conid);
        int id = Integer.parseInt(conid);
        ConsigneesImp consigneesImp = new ConsigneesImp();
        int i = consigneesImp.deleteConsignees(id);
        if (i==0){
            System.out.println("删除失败");
        }
        else {
            System.out.println("删除成功");
        }
        resp.sendRedirect("page/user/contines.jsp");
    }
}
