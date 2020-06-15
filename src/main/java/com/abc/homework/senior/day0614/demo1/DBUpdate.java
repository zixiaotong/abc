package com.abc.homework.senior.day0614.demo1;

import com.abc.homework.senior.day0613.demo01.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBUpdate {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        try {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();
            System.out.println("input id name bj age");
            int id = sc.nextInt();
            while (id != -1) {
                String name = sc.next();
                String bj = sc.next();
                String age = sc.next();
                String sql = "insert into studentInfo values(" + id + ",'" + name + "','" + bj + "'," + age + ")";
                stmt.executeUpdate(sql);
                id = sc.nextInt();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e2) {
                // TODO: handle exception
                e2.printStackTrace();
                System.exit(-1);
            }
        }
    }
}
