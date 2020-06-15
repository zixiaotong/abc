package com.abc.homework.senior.day0613.demo01;

import com.mysql.jdbc.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBQuery {
    public static void main(String[] args) {
        DBQuery dbq = new DBQuery();
        dbq.queryStudentInfo();
        System.out.println("************************");
        dbq.queryStudentScore();
    }

    public static void queryStudentInfo() {
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
            String sql = "select*from studentInfo";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.print(rs.getInt("stuid") + "\t");
                System.out.print(rs.getString("Name") + "\t");
                System.out.print(rs.getString("Class") + "\t");
                System.out.print(rs.getInt("age") + "\t");
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
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

    public static void queryStudentScore() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DBConnection.getConnection();
        if (conn == null) {
            System.out.println("数据库连接失败");
            System.exit(-1);
        }
        try {
            String sql = "select*from studentScore where stuid=1";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.print(rs.getInt("stuid") + "\t");
                System.out.print(rs.getInt("courseid") + "\t");
                System.out.print(rs.getInt("score") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
