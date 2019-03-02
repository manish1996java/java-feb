package com.bmpl.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public interface CommonDAO {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		// create Connection class reference variable to store connection 
		Connection con = null;
		
		ResourceBundle rs = ResourceBundle.getBundle("config");
		
		//  load the driver class
//		Class.forName("com.mysql.cj.jdbc.Driver");
		Class.forName(rs.getString("driver"));
		System.out.println("Driver loaded");
		
		
		//get connection 
//		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","manish@123");
		con = DriverManager.getConnection(rs.getString("url"),rs.getString("userid"),rs.getString("pass"));
		System.out.println("connection established");
		
		
		//return connection
		return con;
	}
	
}