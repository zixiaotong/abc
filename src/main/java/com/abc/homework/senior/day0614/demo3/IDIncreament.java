package com.abc.homework.senior.day0614.demo3;

import com.abc.homework.senior.day0613.demo01.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class IDIncreament {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate("create table student(stuid int auto_increment " + "not null primary key,name VARCHAR(8) not null)");
			stmt.executeUpdate("insert into student (name) values ('张三')");
			stmt.executeUpdate("insert into student (name) values ('李四')");
			stmt.executeUpdate("insert into student (name) values ('王五')");
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
