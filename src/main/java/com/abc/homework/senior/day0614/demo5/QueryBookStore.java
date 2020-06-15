package com.abc.homework.senior.day0614.demo5;

import com.abc.homework.senior.day0613.demo01.DBConnection;
import com.mysql.jdbc.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryBookStore {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DBConnection.getConnection();
        if (conn == null) {
            System.out.println("数据库连接失败");
            System.exit(-1);
        }
        try {
            st = conn.createStatement();
            String sql = "SELECT * from BookStore.Book where Bookid = 2";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.print(rs.getInt("Bookid") + "\t");
                System.out.print(rs.getString("Bookname") + "\t");
                System.out.print(rs.getString("author") + "\t");
                System.out.print(rs.getInt("Price") + "\t");
                System.out.print(rs.getInt("number") + "\t");
                System.out.print(rs.getString("Pub") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("数据库异常");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            DBConnection.closeConnection(conn);
        }

    }
}
