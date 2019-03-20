package com.bmpl.utils;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;



public class PdfGenerator {

	public static void main(String[] args) {

		Date currentDate = new Date();
		System.out.println("currentdate  :"+currentDate);
		
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs =null;
			
			
			try {
				
			//  load the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
			
			//get connection 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdfdb","root","manish@123");
			ps = con.prepareStatement("select * from pdftable;");/*Enter the Query to get name ,in time and out time from your table*/
			rs = ps.executeQuery();
	
			
			String fileName = "D://Newpdf.pdf";
			
			File file = new File(fileName);
			
			if(file.exists()) {
				file.delete();
			}
			
			//Document object for storing meta information
			Document doc = new Document();
			System.out.println("document created");
			
			
			
			Font bold = new Font(FontFamily.HELVETICA,16,Font.BOLD);
				
			PdfWriter.getInstance(doc,new FileOutputStream(file));
			DateFormat df = new SimpleDateFormat("hh:mm:ss");
			
			System.out.println("Get instance");
			doc.open();
			
			//add name of componey
			Paragraph pr1 = new Paragraph("Lazz parking",bold);
			pr1.setAlignment(Element.ALIGN_CENTER);
			
			Paragraph pr2 = new Paragraph("-------------------");
			pr2.setAlignment(Element.ALIGN_CENTER);
			

			Paragraph pr3 = new Paragraph(" "+new Date(),new Font(FontFamily.HELVETICA,10));
			pr3.setAlignment(Element.ALIGN_CENTER);
			pr3.setSpacingAfter(20);
			
			//add name in double quote
			Paragraph pr4 = new Paragraph("Name       :"+"manish",new Font(FontFamily.HELVETICA,12));
			pr4.setAlignment(Element.ALIGN_CENTER);
			
			//place in time instead of 'df.format(newDate())'
			Paragraph pr5 = new Paragraph("Entry Time :"+df.format(new Date()),new Font(FontFamily.HELVETICA,12));
			pr5.setAlignment(Element.ALIGN_CENTER);
			
			//place out time
			Paragraph pr6 = new Paragraph("Exit Time  :"+df.format(new Date()),new Font(FontFamily.HELVETICA,12));
			pr6.setAlignment(Element.ALIGN_CENTER);
			
			Paragraph pr7 = new Paragraph("================================");
			pr7.setAlignment(Element.ALIGN_CENTER);
			
			Paragraph pr8 = new Paragraph("Thank you for your visit",new Font(FontFamily.HELVETICA,12));
			pr8.setAlignment(Element.ALIGN_CENTER);
			
			Paragraph pr9 = new Paragraph("Please come again",new Font(FontFamily.HELVETICA,12));
			pr9.setAlignment(Element.ALIGN_CENTER);
			
			doc.add(pr1);
			doc.add(pr3);
			doc.add(pr2);
			doc.add(pr4);
			doc.add(pr5);
			doc.add(pr6);
			doc.add(pr2);
			doc.add(pr7);
			doc.add(pr8);
			doc.add(pr9);
			doc.add(pr7);
							
			doc.close();
				System.out.println("Finish writing");
				
				Desktop desktop = Desktop.getDesktop();
				if(file.exists()) {
					try {
						desktop.open(file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
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