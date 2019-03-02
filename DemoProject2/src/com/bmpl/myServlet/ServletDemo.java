package com.bmpl.myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bmpl.DAO.VehicleDAO;
import com.bmpl.DTO.VehicleDTO;
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
		

		// for printing on web page
		
		PrintWriter out = response.getWriter();
		
		String fileName = request.getParameter("path");
		ArrayList<VehicleDTO> list = WordDocReader.readDoc(fileName);			/* read Doc giving you list of Vehicle DTO */
		
		
		VehicleDAO vdao = new VehicleDAO();
		boolean isupload = vdao.isUploadIntoDB(list);
		if(isupload) {
			System.out.println("Upload Successfully");
			out.println("<h1>Upload Successfully<h1>");
		}
		
		
		
		
		
		System.out.println("Start Displaying"); 
		
//		ArrayList<VehicleDTO> listFromDB = new ArrayList<>();
//
//		listFromDB = vdao.showData();
		
//		out.println("<hr>");
//		out.println("<br><br>");
//		out.println("<table border=2px>");
//		int counter = 1;
//		out.println("<tr>");
//		out.println("<th>SNo.</th>");
//		out.println("<th>Name</th>");
//		out.println("<th>Staff NO</th>");
//		out.println("<th>Vehicle Type</th>");
//		out.println("<th>Vehicle Type</th>");
//		out.println("<th>Sticker No</th>");
//		out.println("<th>Supporting Doc</th>");
//		out.println("<th>Contact No</th>");
//		out.println("<th>Singnature</th>");
//		
//		out.println("<tr>");
//		for(VehicleDTO vdto : listFromDB) {
//			out.println("<tr>");
//			out.println("<td>"+counter+"</td>");
//			out.println("<td>"+vdto.getName()+"</td>");
//			out.println("<td>"+vdto.getStaffNo()+"</td>");
//			out.println("<td>"+vdto.getType()+"</td>");
//			out.println("<td>"+vdto.getVehicleNo()+"</td>");
//			out.println("<td>"+vdto.getStickerNo()+"</td>");
//			out.println("<td>"+vdto.getSupportingDoc()+"</td>");
//			out.println("<td>"+vdto.getContactNo()+"</td>");
//			out.println("<td>"+vdto.getSignature()+"</td>");
//			out.println("</tr>");
//			counter++;
//		}
//		out.println("</talbe>");
//		
		
//		request.setAttribute("tablelist",listFromDB);
		
		RequestDispatcher rd = request.getRequestDispatcher("showtable.jsp");
		rd.forward(request, response);
		
					
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
