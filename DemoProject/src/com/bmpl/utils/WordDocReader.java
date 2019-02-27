package com.bmpl.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import com.bmpl.DAO.VehicleDAO;
import com.bmpl.DTO.VehicleDTO;

public class WordDocReader {
		
	public static ArrayList<VehicleDTO> readDoc(String fullPath) throws IOException {
		System.out.println("inside readDoc method ");
		VehicleDAO vehicledao = new VehicleDAO();
		ArrayList<VehicleDTO> vehicledtoList = new ArrayList<>();
		
		
		File file = new File(fullPath);
//		File file = new File("D://vcls.docx");
		
		if(file.exists()) {
			
			FileInputStream fis = new FileInputStream(file);
			System.out.println("File read");
			
			XWPFDocument xwpf =  new XWPFDocument(fis);
			System.out.println("intansitate Reading Class");
			
			List<XWPFTable> tablelist = xwpf.getTables();
			System.out.println("get table from document file");
			
			//enter only when table in not empty
			if(tablelist != null) {
			
				for(XWPFTable table: tablelist) {
//				System.out.println(table);
				List<XWPFTableRow> rows = table.getRows();
//					System.out.println(rows);
					
					if(rows != null) {
						boolean isFirstRow = true;
						boolean isBlank = true; 
					for(XWPFTableRow row: rows) {
						
						if(isFirstRow == true) {
							isFirstRow = false;
							
							continue;
						}
						
//						System.out.println(row.getCell(0).getText());
						if(row.getCell(0).getText().trim().isEmpty() && row.getCell(0).getText().trim().isEmpty()) {
							isBlank = false;
						}
						// creating vehilcleDTO object
						VehicleDTO vdto = new VehicleDTO();
						
						if(isBlank) {
						
						List<XWPFTableCell> cells = row.getTableCells();
			
						 	int columnCount = 1;		
							for(XWPFTableCell cell : cells) {	
								
								if(columnCount == 1 && cell.getText().trim() != null ) {
//										
								}
								
								if(columnCount == 2 && cell.getText().trim() != null) {
										if((cell.getText().trim().toLowerCase()).equals("name") || (cell.getText().trim().toLowerCase()).equals("")){
										
										}
										else {
											
											vdto.setName(cell.getText());
										}
								}
								
								if(columnCount == 3 && cell.getText().trim() != null) {
										if((cell.getText().trim().toLowerCase()).equals("staff no") || (cell.getText().trim().toLowerCase()).equals("")){
									
										}
										else {	
											
											vdto.setStaffNo(cell.getText());
										}
								}
								
								if(columnCount == 4 && cell.getText().trim() != null) {
									    if((cell.getText().trim().toLowerCase()).equals("vehicle type")|| (cell.getText().trim().toLowerCase()).equals("")){
									
									    }
									    else {
									    	vdto.setType(cell.getText());
									    }
								}
								
								if(columnCount == 5 && cell.getText().trim() != null) {
									  	if((cell.getText().trim().toLowerCase()).equals("vehicle no") || (cell.getText().trim().toLowerCase()).equals("")){
											
									    }
									    else {
									    	vdto.setVehicleNo(cell.getText());
										}
								}
								
								if(columnCount == 6 && cell.getText().trim() != null) {
									    if((cell.getText().trim().toLowerCase()).equals("sticker no") || (cell.getText().trim().toLowerCase()).equals("")){
											
									    }
									    else {
									    	vdto.setStickerNo(cell.getText());
									    }
								}
								if(columnCount == 7 && cell.getText().trim() != null) {
									  	if((cell.getText().trim().toLowerCase()).equals("supporting documents") || (cell.getText().trim().toLowerCase()).equals("")){
									
									  	}
									  	else {
									  		vdto.setSupportingDoc(cell.getText());
									  	}
								}
								
								if(columnCount == 8 && cell.getText().trim() != null) {
									
										if((cell.getText().trim().toLowerCase()).equals("contact no") || (cell.getText().trim().toLowerCase()).equals("")){
										
										}
										else {
											vdto.setContactNo(cell.getText().trim());
										}
										
								}
								
								if(columnCount == 9 && cell.getText().trim() != null) {
									  if((cell.getText().trim().toLowerCase()).equals("supporting documents") || (cell.getText().trim().toLowerCase()).equals("")){
									
									  }
									  else {
											vdto.setSignature(cell.getText());
									  }
								}
								
								
//								System.out.println(vdto.toString());
									columnCount++;
//								vechiledtoList.add(vdto);
									
							   }
//							System.out.println(vdto.toString());
//							vehicledao.insertIntoDB(vdto);
							vehicledtoList.add(vdto);
						    }
					    }
					}
			    }
			}
			
			
			
		}
		
		
		return vehicledtoList;
	}

}