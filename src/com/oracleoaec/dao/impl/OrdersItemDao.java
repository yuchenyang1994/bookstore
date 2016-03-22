package com.oracleoaec.dao.impl;

import com.oracleoaec.dao.ICommonDao;
import com.oracleoaec.dbutil.JDBCTemplate;
import com.oracleoaec.entity.Oders;
import com.oracleoaec.entity.OrdersItem;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2016/3/4.
 */
public class OrdersItemDao extends CommonDaoImp<OrdersItem>
{
    @Override
    public int save(final OrdersItem oderItem)
    {
        String sql = "insert into order_items values(?,?,?)";
        int result=JDBCTemplate.update(sql, new JDBCTemplate.PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement pstmt) throws SQLException {
                pstmt.setInt(1,oderItem.getItemID());
                pstmt.setInt(2,oderItem.getBooksId());
                pstmt.setInt(3,oderItem.getCount());
            }
        });

        return result;
    }

    @Override
    public List<OrdersItem> findAll()
    {
        String sql ="select * from orders";
        List<OrdersItem> ordersItem= JDBCTemplate.query(sql, null, new JDBCTemplate.ResultSetCallBack<OrdersItem>() {
            @Override
            public OrdersItem processRs(ResultSet rs) throws SQLException
            {
                int oderid = rs.getInt(1);
                int bookid = rs.getInt(2);
                int qu = rs.getInt(3);
                OrdersItem ordersItem = new OrdersItem();
                ordersItem.setItemID(oderid);
                ordersItem.setBooksId(bookid);
                ordersItem.setBooksId(qu);
                return ordersItem;
            }
        });
        return ordersItem;
    }
}
