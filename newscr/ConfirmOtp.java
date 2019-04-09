package com.bmpl.myServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bmpl.utils.CommonDAO;

/**
 * Servlet implementation class ConfirmOtp
 */
@WebServlet("/ConfirmOtp")
public class ConfirmOtp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmOtp() {
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
		
		
		
		Connection con = null;
		PreparedStatement ps2 = null;
		ResultSet rs2 = null;
		
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String otp = request.getParameter("otp");
		
		System.out.println("email :"+email);
		System.out.println("username :"+username);
		System.out.println("otp: "+otp);
		try {
		
			con = CommonDAO.getConnection();
		
		
			ps2 = con.prepareStatement("select otp from user_mst where email=?;");
		
		ps2.setString(1, email);
		rs2 = ps2.executeQuery();
		
		if(rs2.next()) {
			String newotp = rs2.getString("otp");
			System.out.println("newotp: "+newotp);
			
			if(otp.equals(newotp)) {
				System.out.println("inside is everything fine");
				request.setAttribute("email", email);
				request.getRequestDispatcher("changepassword.jsp").forward(request, response);;
			}else {
				System.out.println("wrong otp");
				System.out.println("enterotp.jsp");
//				response.sendRedirect("enteropt.jsp");
			}
			
		}else {
			System.out.println("redirect to same page");
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
