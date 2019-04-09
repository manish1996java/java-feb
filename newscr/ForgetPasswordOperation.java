package com.bmpl.myServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bmpl.utils.CommonDAO;
import com.bmpl.utils.Mailing;

/**
 * Servlet implementation class ForgetPassword
 */
@WebServlet("/ForgetPasswordOperation")
public class ForgetPasswordOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPasswordOperation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isSent;
		String email = request.getParameter("inputpassword");
		String username = null;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
		if(email != null) {
			
			
				con = CommonDAO.getConnection();
			
			ps = con.prepareStatement("select userid from user_mst where email=?;");
			ps.setString(1, email);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				username = rs.getString("userid");
				System.out.println("userName"+username);
				String otps[] = {"45hj96","yu856","jkd75","Ld4856"};
				Random rd = new Random();
				int index = rd.nextInt(otps.length);
				isSent = Mailing.sendMail(email, otps[index]);
				

				PreparedStatement ps1 = null;
				ResultSet rs1 = null;
				
				ps1 = con.prepareStatement("update user_mst set otp=? where email=?; ");
				ps1.setString(1, otps[index]);
				ps1.setString(2, email);
				ps1.executeUpdate();
				if(isSent) {
					System.out.println("Mail Sent");
					request.setAttribute("emailadd", email);
					request.setAttribute("username", username);
					
					RequestDispatcher rdes = request.getRequestDispatcher("enterotp.jsp");
					rdes.forward(request, response);
					
					
				}else {
					System.out.println("Not Sent");
					response.sendRedirect("forgetpasswordscreen.jsp");
				}
				
			}
			else {
				System.out.println("wronge email id");
				response.sendRedirect("forgetpasswordscreen.jsp");
			}	
		}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
		doGet(request, response);
	
	}	
}	
		
		
		
		
		
//		
//		boolean isSent;
//		ForgetPassword fp = new ForgetPassword();
//		String email=null;
//		try {
//			email = fp.checkEmail();
//		
//		String otps[] = {"45hj96","yu856","jkd75","Ld4856"};
//		Random rd = new Random();
//		int index = rd.nextInt(otps.length);
//
//		isSent = Mailing.sendMail(email, otps[index]);
//		
//		Connection con1 = null;
//		PreparedStatement ps1 = null;
//		ResultSet rs1 = null;
//		
//		con1 = CommonDAO.getConnection();
//		ps1 = con1.prepareStatement("update user_mst set otp=? where email=?; ");
//		ps1.setString(1, otps[index]);
//		ps1.setString(2, email);
//		ps1.executeUpdate();
//		
//		
//		
//		if(isSent) {
//			System.out.println("Mail Sent");
//			
//			Connection con = null;
//			PreparedStatement ps = null;
//			ResultSet rs = null;
//			
//			con = CommonDAO.getConnection();
//			ps = con.prepareStatement("select otp from user_mst where email=?;");
//			ps.setString(1, email);
//			rs = ps.executeQuery();
//			
//			if(rs.next()) {
//				String newotp = rs.getString("otp");
//				Scanner scan = new Scanner(System.in);
//				System.out.println("Enter the otp");
//				String userotp = scan.next();
//				
//				if(otps[index].equals(userotp)) {
//					System.out.println("Enter new password");
//				}else {
//					System.out.println("wrong otp");
//					System.out.println("reirect to same page");
//				}
//				
//			}else {
//				System.out.println("redirect to same page");
//			}
//			
//			
//		}else {
//			System.out.println("Not Sent");
//		}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		doGet(request, response);
//	}
//
//}
