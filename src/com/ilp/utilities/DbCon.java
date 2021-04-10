package com.ilp.utilities;

import java.sql.*;
import java.sql.DriverManager;

public class DbCon {
	private static Connection con = null;
//vaideeoracle.svcsubnetad1.svcvcn.oraclevcn.com:1521/PDB12.svcsubnetad1.svcvcn.oraclevcn.com

	private static final String URL = "jdbc:oracle:thin:@localhost:1521/vaidee19";
	private static final String USERNAME = "system";
	private static final String PASSWORD = "Test@123";

	public static Connection getConnection() {
		if (con == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GamingWebStore?user=root&password=Test@123");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}

	public static void closeConnection() {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
			}
			con = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
