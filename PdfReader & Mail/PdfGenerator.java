package practice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfGenerator {

	public static void main(String[] args) {

		Date currentDate = new Date();
		System.out.println("currentdate  :"+currentDate);
		
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs =null;
			
			//  load the driver class
			try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				
				System.out.println("Driver loaded");
			
			
			//get connection 
			
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdfdb","root","manish@123");
			
			ps = con.prepareStatement("select * from pdftable;");
			rs = ps.executeQuery();
	
		
			System.out.println("inside Pdf generator");
			
			String fileName = "D://Newpdf.pdf";
			
			
			//Document object for storing meta information
			Document doc = new Document();
			System.out.println("document created");
			Font bold = new Font(FontFamily.HELVETICA,16,Font.BOLD);
				
			PdfWriter.getInstance(doc,new FileOutputStream(fileName));
			
			System.out.println("Get instance");
			doc.open();
				
			
				
//				PdfPTable table = new PdfPTable(5);
//				
//				PdfPCell cell = new PdfPCell();
//				
//				for(int i=1;i<=40;i++) {
//				table.addCell(new Paragraph("Heading "+i));
//				}
				PdfPTable table = new PdfPTable(3);
				table.addCell(new Paragraph("name",bold));
				table.addCell(new Paragraph("course",bold));
				table.addCell(new Paragraph("phone",bold));
				
				int column = 1;
				while(rs.next()) {
//					if(column == 1) {
					table.addCell(new Paragraph(rs.getString("name")));
//					}
//					if(column == 2) {
						table.addCell(new Paragraph(rs.getString("course")));
//					}
//					if(column == 3) {
						table.addCell(new Paragraph(rs.getString("phone")));
//					}
//				column++;
				}
				
				doc.add(table);
				
				
			doc.close();
				System.out.println("Finish writing");
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	

}
