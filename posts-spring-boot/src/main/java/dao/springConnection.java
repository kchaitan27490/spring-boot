package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class springConnection {
	
	private static Connection con;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			setCon(DriverManager.getConnection("jdbc:mysql://localhost/test", "root", ""));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getCon() {
		return con;
	}

	public static void setCon(Connection con) {
		springConnection.con = con;
	}
}
