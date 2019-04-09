
package com.bmpl.myServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bmpl.utils.CommonDAO;

/**
 * Servlet implementation class UpdateNewPass
 */
@WebServlet("/UpdateNewPass")
public class UpdateNewPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNewPass() {
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
		
		System.out.println("inside do post");
		
		String pass = request.getParameter("pass");
		String email = request.getParameter("email") ;
		
		Connection con = null;
		PreparedStatement ps = null;
		
		System.out.println("after connection");
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement("update user_mst set password=? where email=?;");
			ps.setString(1, pass);
			ps.setString(2, email);
			
			ps.executeUpdate();
			
			
			System.out.println("open signin page");
			//Enter the singin page name here
			response.sendRedirect("");
			
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
