package com.bmpl.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class ForgetPassword2 {
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		
		boolean isSent;
		ForgetPassword fp = new ForgetPassword();
		String email=null;
		email = fp.checkEmail();
		String otps[] = {"45hj96","yu856","jkd75","Ld4856"};
		Random rd = new Random();
		int index = rd.nextInt(otps.length);

		isSent = Mailing.sendMail(email, otps[index]);
		
		Connection con1 = null;
		PreparedStatement ps1 = null;
		ResultSet rs1 = null;
		
		con1 = CommonDAO.getConnection();
		ps1 = con1.prepareStatement("update user_mst set otp=? where email=?; ");
		ps1.setString(1, otps[index]);
		ps1.setString(2, email);
		ps1.executeUpdate();
		
		
		
		if(isSent) {
			System.out.println("Mail Sent");
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			con = CommonDAO.getConnection();
			ps = con.prepareStatement("select otp from user_mst where email=?;");
			ps.setString(1, email);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String newotp = rs.getString("otp");
				Scanner scan = new Scanner(System.in);
				System.out.println("Enter the otp");
				String userotp = scan.next();
				
				if(otps[index].equals(userotp)) {
					System.out.println("Enter new password");
				}else {
					System.out.println("wrong otp");
					System.out.println("reirect to same page");
				}
				
			}else {
				System.out.println("redirect to same page");
			}
			
			
		}else {
			System.out.println("Not Sent");
		}
		
	}
}
