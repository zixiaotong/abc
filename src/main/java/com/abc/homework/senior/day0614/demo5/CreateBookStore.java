package com.abc.homework.senior.day0614.demo5;

import com.abc.homework.senior.day0613.demo01.DBConnection;
import com.mysql.jdbc.Connection;

import java.sql.SQLException;
import java.sql.Statement;

public class CreateBookStore {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        conn = DBConnection.getConnection();
        if (conn == null) {
            System.out.println("数据库未能连接");
            System.exit(-1);
        }
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("create database BookStore");
            stmt.executeUpdate("use BookStore");
            stmt.executeUpdate("create table Book(Bookid int auto_increment " + "not null primary key," + " Bookname varchar(30) not null," + "author varchar(10) not null," + "Price double not null," + "number int not null," + "Pub varchar(30) not null)");
            stmt.executeUpdate("insert into Book(Bookname,author,Price,number,Pub) values('Java程序设计','杨国兴',38.00,10,'中国水利水电出版社')");
            stmt.executeUpdate("insert into Book(Bookname,author,Price,number,Pub) values('实用软件工程','卢慧恩',34.50,15,'清华大学电出版社')");
        } catch (SQLException e) {
            System.out.println("数据库异常");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            DBConnection.closeConnection(conn);
        }

    }
}
