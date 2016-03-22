package com.oracleoaec.dbutil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Administrator on 2016/2/29.
 */
public class ConntionFactory
{
    private static String DRIVER;
    private static String URL;
    private static String UNAME;
    private static String UPASS;
    static {
        Properties props = new Properties();
        InputStream is = ConntionFactory.class.getResourceAsStream("jdbcinfo.properties");
        try {
            props.load(is);
            DRIVER = props.getProperty("oracle.driver");
            URL = props.getProperty("oracle.url");
            UNAME = props.getProperty("oracle.uname");
            UPASS = props.getProperty("oracle.upass");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,UNAME,UPASS);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
