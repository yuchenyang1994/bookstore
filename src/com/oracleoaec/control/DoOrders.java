package com.oracleoaec.control;

import com.oracleoaec.entity.CartItem;
import com.oracleoaec.entity.Consigness;
import com.oracleoaec.entity.Oders;
import com.oracleoaec.entity.OrdersItem;
import com.oracleoaec.service.Impl.ConsigneesImp;
import com.oracleoaec.service.Impl.OdersImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/4.
 */
public class DoOrders extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Date date = new Date();
        long time = date.getTime();
        String concheck = req.getParameter("concheck");
        int conID = Integer.parseInt(concheck);
        ConsigneesImp consigneesImp = new ConsigneesImp();
        Consigness consigness = consigneesImp.findconnByid(conID);
        Map<Integer,CartItem> cart = (Map<Integer, CartItem>) req.getSession().getAttribute("cart");
        Oders oders = new Oders();
        oders.setConsigneeId(consigness.getId());
        oders.setShopped_date(new java.sql.Date(time));
        oders.setStatus("发货");
        oders.setDescription("已经发货");
        OdersImp odersImp = new OdersImp();
        int i = odersImp.saveOders(oders);
        if (i!=0)
        {
            System.out.println("保存成功");
        }
        else {
            System.out.println("保存失败");
        }
        for (Integer key:cart.keySet())
        {
            List<Oders> allOders = odersImp.findAllOders();
            System.out.println(allOders);
            for (int j = 0; j <allOders.size() ; j++)
            {
                Oders oders1 = allOders.get(j);
                int id = oders1.getId();
                System.out.println(id);
                OrdersItem ordersItem = new OrdersItem();
                ordersItem.setBooksId(key);
                ordersItem.setItemID(id);
                ordersItem.setCount(cart.get(key).getQuantity());
                odersImp.saveOders_item(ordersItem);
            }
        }
        resp.sendRedirect("page/books/detail.jsp");

    }
}
