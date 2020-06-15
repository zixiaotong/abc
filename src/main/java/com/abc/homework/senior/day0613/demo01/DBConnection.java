package com.abc.homework.senior.day0613.demo01;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBConnection {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://47.98.146.184:3306?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "abc123");
        } catch (ClassNotFoundException e) {
            System.out.println("failed to register deiver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("failed to execute sql.");
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
