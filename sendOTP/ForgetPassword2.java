package com.bmpl.utils;

import java.sql.SQLException;
import java.util.Random;

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
		
		if(isSent) {
			System.out.println("Mail Sent");
		}else {
			System.out.println("Not Sent");
		}
		
	}
}
