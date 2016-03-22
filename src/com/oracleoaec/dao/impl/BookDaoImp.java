package com.oracleoaec.dao.impl;

import com.oracleoaec.dbutil.JDBCTemplate;
import com.oracleoaec.entity.Book;
import com.oracleoaec.entity.BookChapter;
import com.oracleoaec.entity.accounts;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/3/1.
 */
public class BookDaoImp extends CommonDaoImp<Book>
{

    @Override
    public List<Book> findAll()
    {
        String sql= "select * from books";
        List<Book> booklist = JDBCTemplate.query(sql, null, new JDBCTemplate.ResultSetCallBack<Book>() {
            @Override
            public Book processRs(ResultSet rs) throws SQLException {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String description = rs.getString(3);
                String instrouduction = rs.getString(4);
                int grade = rs.getInt(5);
                int purchase_price = rs.getInt(6);
                float selling_price = rs.getFloat(7);
                String image = rs.getString(8);
                String isbn = rs.getString(9);
                String book_concern = rs.getString(10);
                Date publishing_date = rs.getDate(11);
                String author = rs.getString(12);
                String autrhor_introduction = rs.getString(13);
                Book book = new Book(id,name,selling_price,description,instrouduction,grade,purchase_price,image
                        ,isbn,book_concern,publishing_date,author,autrhor_introduction);


                return book;
            }
        });
        return booklist;
    }

    @Override
    public Book findById(final int id)
    {
        String sql = "select * from books where id = ?";
        Book book = JDBCTemplate.singleQuery(sql, new JDBCTemplate.PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement pstmt) throws SQLException {
                pstmt.setInt(1,id);
            }
        }, new JDBCTemplate.ResultSetCallBack() {
            @Override
            public Book processRs(ResultSet rs) throws SQLException {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String descroption = rs.getString(3);
                String instroduction = rs.getString(4);
                int grade = rs.getInt(5);
                int purchase_price = rs.getInt(6);
                float selling_price = rs.getFloat(7);
                String image = rs.getString(8);
                String ISBN = rs.getString(9);
                String book_concern = rs.getString(10);
                Date PubliShing_DATE = rs.getDate(11);
                String author = rs.getString(12);
                String author_introduction = rs.getString(13);
                Book book = new Book(id,name,selling_price,descroption,instroduction,grade,
                        purchase_price,image,ISBN,book_concern,
                        PubliShing_DATE,author,author_introduction);
                BookChapter_id chapterId = new BookChapter_id();
                List<BookChapter> objectById = chapterId.findObjectById(id);
                book.setBookChapterList(objectById);


                return book;
            }
        });
        return book;
    }
}
