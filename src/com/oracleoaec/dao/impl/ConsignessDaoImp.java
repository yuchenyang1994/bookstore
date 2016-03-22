package com.oracleoaec.dao.impl;

import com.oracleoaec.dbutil.JDBCTemplate;
import com.oracleoaec.entity.Consigness;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2016/3/3.
 */
public class ConsignessDaoImp extends CommonDaoImp<Consigness> {

    @Override
    public int save(final Consigness consigness) {
        System.out.println(123213);
        String sql = "insert into consignees values(seq_consignees_id.nextval,?,?,?,?,?,?)";
        int result = JDBCTemplate.update(sql, new JDBCTemplate.PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement pstmt) throws SQLException {
                pstmt.setInt(1, consigness.getAccount_id());
                pstmt.setString(2, consigness.getFull_name());
                pstmt.setString(3, consigness.getTel());
                pstmt.setString(4, consigness.getProvince());
                pstmt.setString(5, consigness.getCity());
                pstmt.setString(6, consigness.getExtra());
            }
        });
        return result;
    }

    @Override
    public List<Consigness> findObjectById(final int id)
    {
        String sql = "select * from consignees where account_id=?";
        List<Consigness> consignessList = JDBCTemplate.query(sql, new JDBCTemplate.PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement pstmt) throws SQLException
            {
                pstmt.setInt(1,id);
            }
        }, new JDBCTemplate.ResultSetCallBack<Consigness>() {
            @Override
            public Consigness processRs(ResultSet rs) throws SQLException
            {
                int id = rs.getInt(1);
                int account_id = rs.getInt(2);
                String full_name = rs.getString(3);
                String tel = rs.getString(4);
                String province = rs.getString(5);
                String city = rs.getString(6);
                String extra = rs.getString(7);
                Consigness consigness = new Consigness(account_id, full_name, tel, province, city, extra);
                consigness.setId(id);
                return consigness;
            }
        });

        return consignessList;
    }

    @Override
    public int delete(final int id) {
        String sql = "delete from consignees where id = ?";
        int result = JDBCTemplate.update(sql, new JDBCTemplate.PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement pstmt) throws SQLException {
                pstmt.setInt(1,id);
            }

        });
        return result;
    }

    @Override
    public Consigness findById(final int id)
    {
        String sql = "select * from consignees where id=?";
        Consigness conn = JDBCTemplate.singleQuery(sql, new JDBCTemplate.PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement pstmt) throws SQLException
            {
                pstmt.setInt(1,id);
            }
        }, new JDBCTemplate.ResultSetCallBack<Consigness>() {
            @Override
            public Consigness processRs(ResultSet rs) throws SQLException
            {
                int id = rs.getInt(1);
                int account_id = rs.getInt(2);
                String full_name = rs.getString(3);
                String tel = rs.getString(4);
                String province = rs.getString(5);
                String city = rs.getString(6);
                String extra = rs.getString(7);
                Consigness consigness = new Consigness(account_id, full_name, tel, province, city, extra);
                consigness.setId(id);
                return consigness;
            }
        });
        return conn;
    }
}
