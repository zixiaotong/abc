package com.abc.homework.senior.day0614.demo2;

import com.abc.homework.senior.day0613.demo01.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PrepareStatementOperate {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        Scanner sc = new Scanner(System.in);
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("insert into studentInfo values(?,?,?,?)");
            System.out.println("input id name bj age");
            int id = sc.nextInt();
            while (id != -1) {
                String name = sc.next();
                String bj = sc.next();
                int age = sc.nextInt();
                pstmt.setInt(1, id);
                pstmt.setString(2, name);
                pstmt.setString(3, bj);
                pstmt.setInt(4, age);
                pstmt.executeUpdate();
                id = sc.nextInt();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
                System.exit(-1);
            }
        }
    }
}
