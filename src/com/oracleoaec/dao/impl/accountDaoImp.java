package com.oracleoaec.dao.impl;


import com.oracleoaec.dbutil.JDBCTemplate;
import com.oracleoaec.entity.accounts;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/2/29.
 */
public class accountDaoImp extends CommonDaoImp<accounts>{
    @Override
    public int save(final accounts acc) {
        String sql = "insert into accounts(id,account,password,email)values(seq_accounts_id.nextval,?,?,?)";
        int result = JDBCTemplate.update(sql, new JDBCTemplate.PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement pstmt) throws SQLException {
                pstmt.setString(1,acc.getAccount());
                pstmt.setString(2,acc.getPassword());
                pstmt.setString(3,acc.getMail());

            }
        });
        return result;
    }

    @Override
    public accounts findByName(final String name)
    {
        String sql = "select id,account,password,email from accounts where account=?";
        accounts account = (accounts) JDBCTemplate.singleQuery(sql, new JDBCTemplate.PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement pstmt) throws SQLException
            {
                pstmt.setString(1,name);
            }
        }, new JDBCTemplate.ResultSetCallBack<accounts>() {
            @Override
            public accounts processRs(ResultSet rs) throws SQLException {
                int id = rs.getInt(1);
                String account = rs.getString(2);
                String password = rs.getString(3);
                String email = rs.getString(4);
                accounts acc = new accounts(id,account,password,email);
                return acc;
            }
        });
        return account;
    }

    @Override
    public accounts findByNameAndPassowrd(final String name, final String password)
    {
        String sql = "select id,account,password,email from accounts where account = ? and password = ?";
        accounts accounts = JDBCTemplate.singleQuery(sql, new JDBCTemplate.PreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement pstmt) throws SQLException {
                pstmt.setString(1,name);
                pstmt.setString(2,password);
            }
        }, new JDBCTemplate.ResultSetCallBack<accounts>() {
            @Override
            public com.oracleoaec.entity.accounts processRs(ResultSet rs) throws SQLException {
                int id = rs.getInt(1);
                String account = rs.getString(2);
                String password = rs.getString(3);
                String email = rs.getString(4);
                accounts acc = new accounts(id, account, password, email);
                return acc;
            }
        });
        return accounts;
    }
}
