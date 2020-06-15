package com.abc.homework.senior.day0614.demo5;

import com.abc.homework.senior.day0613.demo01.DBConnection;
import com.mysql.jdbc.Connection;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpSetPrice {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        conn = DBConnection.getConnection();
        if (conn == null) {
            System.out.println("数据库连接失败");
            System.exit(-1);
        }
        Scanner sc = new Scanner(System.in);
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE BookStore.Book SET Price = '28.80' WHERE Book.Bookid = 2");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
                System.exit(-1);
            }
        }
    }
}
