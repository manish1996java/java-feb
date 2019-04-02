package com.bmpl.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.bmpl.DTO.PassDTO;

public class ForgetPassword {

	public String checkEmail() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Scanner scan  = new Scanner(System.in);
		System.out.println("Enter you email address");
		String email = scan.next();
		String username = null;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		if(email != null) {
			
			con = CommonDAO.getConnection();
			ps = con.prepareStatement("select userid from user_mst where email=?;");
			ps.setString(1, email);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				username = rs.getString("userid");
				System.out.println("userName"+username);
				return email;
			}
			else {
				System.out.println("redirect to same page");
			}	
		}
		return null;
	}

}
