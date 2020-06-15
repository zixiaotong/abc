package com.abc.homework.senior.day0614.demo4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.abc.homework.senior.day0613.demo01.DBConnection;

public class ScrollRsOperate {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("select * from studentInfo where stuid=2");
            if (rs.next()) {
                rs.updateInt("age", 30);
                rs.updateRow();
            }

            rs = stmt.executeQuery("select * from studentInfo");
            rs.afterLast();
            while (rs.previous()) {
                System.out.print(rs.getString("stuid") + " ");
                System.out.print(rs.getString("name") + " ");
                System.out.print(rs.getString("class") + " ");
                System.out.print(rs.getString("age"));
                System.out.println();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
                System.exit(-1);
            }
        }
    }
}
