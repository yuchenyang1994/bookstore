package com.oracleoaec.dao.impl;

import com.oracleoaec.dbutil.JDBCTemplate;
import com.oracleoaec.entity.Book;
import com.oracleoaec.entity.Oders;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2016/3/4.
 */
public class OdersDao extends CommonDaoImp<Oders>
{
    @Override
    public int save(final Oders orders)
    {
        String sql = "insert into orders values(seq_orders_id.nextval,?,?,?,?)";
        int result= JDBCTemplate.update(sql, new JDBCTemplate.PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement pstmt) throws SQLException
            {
                pstmt.setInt(1,orders.getConsigneeId());
                pstmt.setDate(2,orders.getShopped_date());
                pstmt.setString(3,orders.getStatus());
                pstmt.setString(4,orders.getDescription());
            }
        });

        return result;
    }

    @Override
    public List<Oders> findAll() {
        String sql = "select * from orders";
        List<Oders> odersList= JDBCTemplate.query(sql, null, new JDBCTemplate.ResultSetCallBack<Oders>() {
            @Override
            public Oders processRs(ResultSet rs) throws SQLException
            {
                int id = rs.getInt(1);
                int consigneeId = rs.getInt(2);
                Date date = rs.getDate(3);
                String status = rs.getString(4);
                String description = rs.getString(5);
                Oders oders = new Oders();
                oders.setId(id);
                oders.setConsigneeId(consigneeId);
                oders.setShopped_date(date);
                oders.setStatus(status);
                oders.setDescription(description);
                return oders;
            }
        });
        return odersList;
    }
}
