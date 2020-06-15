package com.abc.homework.senior.day0613.demo01;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DBCreate {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		conn = DBConnection.getConnection();
		if(conn == null) {
			System.out.println("数据库连接失败");
			System.exit(-1);
		}
		try {
			stmt = (Statement) conn.createStatement();
//			stmt.executeUpdate("create database student");
//			stmt.executeUpdate("use student");
			stmt.executeUpdate("create table studentInfo(stuid int not null primary key,name VARCHAR(8) not null,class VARCHAR(6) not null,age INT not null)");
			stmt.executeUpdate("insert into studentInfo values(1,'Zhangsan','150101',15)");
			stmt.executeUpdate("insert into studentInfo values(2,'Lisi','150102',16)");
			stmt.executeUpdate("create table studentScore(stuid int not null,courseid int not null,score int not null)");
			stmt.executeUpdate("insert into studentScore values(1,1,80)");
			stmt.executeUpdate("insert into studentScore values(2,1,90)");
			stmt.executeUpdate("insert into studentScore values(1,2,100)");
			stmt.executeUpdate("insert into studentScore values(2,2,95)");
		}
		catch (SQLException e) {
			System.out.println("创建库失败");
		}
		finally {
			if(stmt !=null) {
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
