package com.bmpl.myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.File;

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
		

//		System.out.println("word Reader load");
//		WordDocReader.readingDoc();
//		
		PrintWriter out = response.getWriter();
		
		String url = "D://";
		String fileName = request.getParameter("path");
		System.out.println(fileName);
		String fullPath = url+fileName;
		System.out.println(url);
		java.io.File file = new java.io.File(fileName);
		System.out.println("Full path is " + file.getAbsolutePath());
		
		
		
		
		
		ArrayList<VehicleDTO> list = WordDocReader.readDoc(fullPath);
		VehicleDAO vdao = new VehicleDAO();
		boolean isupload = vdao.isUploadIntoDB(list);
		if(isupload) {
			System.out.println("Upload Successfully");
			out.println("<h1>Upload Successfully<h1>");
		}
		
		

//		String id = request.getParameter("id");
//		String pass = request.getParameter("pass");
		
//		System.out.println("id"+id);
//		System.out.println("password "+pass);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
