package com.jmc.loginform;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtlis {
    static String User = "root";
    static String password = "minhcbg123";
    static String url = "jdbc:mysql://localhost:3306/login";
    static String driver = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, User, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
