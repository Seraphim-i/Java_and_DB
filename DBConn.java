package com.narae.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {

	public final static String server = "jdbc:mariadb://localhost:3306/temp";

	static Connection getcon() {
		Connection con = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(server, "Narae-Default", "1q2w3e4r!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
