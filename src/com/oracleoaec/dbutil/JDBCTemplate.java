package com.oracleoaec.dbutil;

import com.oracleoaec.entity.accounts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/2/29.
 */
public class JDBCTemplate
{
    // 增删改操作
    public static int update(String sql, PreparedStatementSetter setter) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int res = 0;// 影响的行数
        try {
            conn = ConntionFactory.getConnection();
            pstmt = conn.prepareStatement(sql);
            if (setter != null) {
                setter.setValues(pstmt);// 替换占位符
            }
            res = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(null, pstmt, conn);
        }
        return res;
    }

    // 泛型方法 （在运行的时候确定T的类型，此方法返回的是一个T类型的集合）
    public static <T> List<T> query(String sql, PreparedStatementSetter setter, ResultSetCallBack handler) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<T> dataList = null;
        try {
            conn = ConntionFactory.getConnection();
            pstmt = conn.prepareStatement(sql);
            if (setter != null) {
                setter.setValues(pstmt);// 替换占位符
            }
            rs = pstmt.executeQuery();// 执行查询
            // 假设提供了处理结果集的接口的实现类对象
            if (handler != null) {
                dataList = new ArrayList<>();// 首先产生一个泛型集合
                // 循环记录集
                while (rs.next()) {
                    // 处理结果集并把记录存到泛型集合中
                    dataList.add((T) handler.processRs(rs));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(rs, pstmt, conn);
        }
        return dataList;
    }

    //查询数据库返回的是单个值
    public static <T> T singleQuery(String sql, PreparedStatementSetter setter, ResultSetCallBack handler) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        T data=null;
        try {
            conn = ConntionFactory.getConnection();
            pstmt = conn.prepareStatement(sql);
            if (setter != null) {
                setter.setValues(pstmt);// 替换占位符
            }
            rs = pstmt.executeQuery();// 执行查询
            // 假设提供了处理结果集的接口的实现类对象
            if (handler != null) {
                if(rs.next()){
                    data= (T) handler.processRs(rs);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(rs, pstmt, conn);
        }
        return data;
    }

    public static void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
        }
    }


    // 替换占位符
    public static interface PreparedStatementSetter {
        // 一个回调函数，给PreparedStatement的所要执行的SQL语句中的占位符替换成具体的数据
        public void setValues(PreparedStatement pstmt) throws SQLException;
    }

    // 处理结果集的
    public static interface ResultSetCallBack<T> {
        // 处理结果集的一个回调函数
        public T processRs(ResultSet rs) throws SQLException;
    }
}
