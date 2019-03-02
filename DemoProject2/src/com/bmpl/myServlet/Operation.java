package com.bmpl.myServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bmpl.DAO.VehicleDAO;
import com.bmpl.DTO.VehicleDTO;

/**
 * Servlet implementation class Operation
 */
@WebServlet("/Operation")
public class Operation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Operation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		PrintWriter out = response.getWriter();
		VehicleDAO vdao = new VehicleDAO();
		VehicleDTO vdto = new VehicleDTO();
		
		vdto.setName(request.getParameter("name"));
		vdto.setStaffNo(request.getParameter("staff"));
		vdto.setType(request.getParameter("type"));
		vdto.setVehicleNo(request.getParameter("vnumber"));
		vdto.setStickerNo(request.getParameter("sticker"));
		vdto.setSupportingDoc(request.getParameter("doc"));
		vdto.setContactNo(request.getParameter("cng"));
		vdto.setSignature(request.getParameter("sig"));
		
		boolean flage = vdao.addIntoDB(vdto);
		
		if(flage) {
			
			System.out.println("sumitted");
			out.println("<h2>Submitted</h2>");
			
		}else {
			System.out.println("not submitted");
			out.println("<h2>not Submitted</h2>");
		}
		
				
		
		
		
		
		
		
		
//		if(request.getAttribute("tablelist") != null) {
//		if(request.getAttribute("tablelist") instanceof ArrayList<?>) {
//		ArrayList<VehicleDTO> list =  (ArrayList<VehicleDTO>) request.getAttribute("tablelist");
//			
//				
//		
//		}
//		}
//		
//		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
