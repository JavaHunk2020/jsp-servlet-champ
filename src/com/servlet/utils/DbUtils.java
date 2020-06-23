package com.servlet.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtils {

	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle_db", "root", "mysql@1234");
		return conn;
	}
}
