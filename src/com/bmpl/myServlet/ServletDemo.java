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
import com.bmpl.utils.WordDocReader;

/**
 * Servlet implementation class ServletDemo
 */
@WebServlet("/ServletDemo")
public class ServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

//		System.out.println("word Reader load");
//		WordDocReader.readingDoc();
//		
		
		
		
		
		String url = "D://";
		String fileName = request.getParameter("path");
		String fullPath = url+fileName;
		System.out.println(url);
		
		WordDocReader.readDoc(fullPath);
		
		

//		String id = request.getParameter("id");
//		String pass = request.getParameter("pass");
		
//		System.out.println("id"+id);
//		System.out.println("password "+pass);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs= null;
		
		
		
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement("Select * from vehicle_mst;");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("name"+ rs.getString("vname")+"pass"+ rs.getInt("staff_no"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			if(rs != null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps != null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con != null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
