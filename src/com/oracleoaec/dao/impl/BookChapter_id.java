package com.oracleoaec.dao.impl;

import com.oracleoaec.dbutil.JDBCTemplate.PreparedStatementSetter;
import com.oracleoaec.entity.BookChapter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static com.oracleoaec.dbutil.JDBCTemplate.*;

/**
 * Created by Administrator on 2016/3/2.
 */
public class BookChapter_id extends CommonDaoImp<BookChapter>
{
    @Override
    public List<BookChapter> findObjectById(final int id)
    {
        String sql = "select * from book_chapters where book_id = ?";
        List<BookChapter> bookchapter = query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement pstmt) throws SQLException {
                pstmt.setInt(1,id);
            }
        }, new ResultSetCallBack() {
            @Override
            public Object processRs(ResultSet rs) throws SQLException
            {
                int id=rs.getInt(1);
                String name=rs.getString(2);
                int chapter_id=rs.getInt(3);
                int book_id=rs.getInt(4);
                BookChapter bookChapter = new BookChapter(id,name,chapter_id,book_id);
                return bookChapter;
            }
        });
        return bookchapter;
    }
}
