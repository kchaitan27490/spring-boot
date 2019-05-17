package com.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class TestPost {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver is loaded");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
		System.out.println("Connection is created");
	
// STATEMENT

//		 String query = "insert into posts values(1,'Title of the post','Body of the post')";
//		 Statement st = con.createStatement();
//		
//		 int res = st.executeUpdate(query);
//		 System.out.println("Rows affected : " + res);

// PREPARED STATEMENTS
		
//		Scanner scan = new Scanner(System.in);
//		System.out.println("Enter Post ID:");
//		int id = scan.nextInt();
//		
//		scan.nextLine();
//		
//		System.out.println("Enter the title of the post:");
//		String title = scan.nextLine();
//		
//		System.out.println("Enter the body of the post:");
//		String body = scan.nextLine();
//		
//		String sql = "insert into posts values(?,?,?)";
//		PreparedStatement ps = con.prepareStatement(sql);
//		
//		ps.setInt(1, id);
//		ps.setString(2, title);
//		ps.setString(3, body);
//		
//		int i=ps.executeUpdate();
//		
//		System.out.println("Affected rows:"+i);
		
		 Statement st = con.createStatement();
		 ResultSet rs = st.executeQuery("select * from posts");
		
		 while (rs.next()) {
		 System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," +
		 rs.getString(3));
		 }

	}

}
