package com.bmpl.myServlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class FileUploadServlet
 */
@MultipartConfig(maxFileSize = 169999999)
@WebServlet("/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String username = request.getParameter("username");
	String path = this.getServletContext().getRealPath("upload"); 
	Part filePart = request.getPart("file");
	String fileName = getFileName(filePart);
	
	
	OutputStream out = null;
	InputStream filecontent = null;
	
	PrintWriter writer = response.getWriter();
	
	try {
	out = new FileOutputStream(new File(path + File.separator+ username + fileName));
	filecontent = filePart.getInputStream();
	String filePathName = path + File.separator+ username + fileName;
	
//	//
//	JSONObject obj=new JSONObject();
//	obj.put(username, filePathName);
//	Files.write(Paths.get(path+"//"+username+".json"), obj.toJSONString().getBytes());
//	//
	
	int read = 0;
	byte[] bytes = new byte[1024];
	
	while((read = filecontent.read(bytes)) != -1 ) {
		out.write(bytes, 0 ,read);
	}
	
	writer.println("New file"+ fileName + "created at " + path);
	} catch (FileNotFoundException fn) {
		writer.println("<br/> ERROR: "+fn.getMessage());
	}
	
	request.setAttribute("image", username + fileName);
	request.setAttribute("jsonname",username+".json");
	RequestDispatcher rd = request.getRequestDispatcher("fshow.jsp");
	rd.forward(request, response);
	
	
//	String relpath = "./upload";
//	String saveFile = this.getServletContext().getRealPath(relpath);
//	
		
		
		
	}

	private String getFileName(Part part) {
		
		String partHeader = part.getHeader("content-disposition");

		for(String content: part.getHeader("content-disposition").split(";")) {
			
			if(content.trim().startsWith("filename")) {
				return content.substring(content.indexOf("=") + 1).trim().replace("\"","");
			}
		}
		
		
		return null;
	}

}
