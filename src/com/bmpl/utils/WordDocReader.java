package com.bmpl.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class WordDocReader {
	
//	public static String readingDoc() {
//		
//		
//		//store path in String variable
//		String fullPath = "D://vcls.docx";
//		
//		//intensiate file class
//		File file = new File(fullPath);
//		
//		
//		if(file.exists()) {
//			System.out.println("file Exist");
//			
//			
//			
//			
//		}
//		
//		
//		
//		
//		
//		return "";
//	}
	
	
	
	
	
	
	public static String readDoc(String fullPath) throws IOException {
		System.out.println("inside readDoc method ");
		
		
		
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
				System.out.println(table);
				List<XWPFTableRow> rows = table.getRows();
					System.out.println(rows);
					
					if(rows != null) {
						boolean isFirstRow = true;
						
					for(XWPFTableRow row: rows) {
						
						if(isFirstRow == true) {
							isFirstRow = false;
							
							continue;
						}
						
					
						
						if(row != null) {
						
						List<XWPFTableCell> cells = row.getTableCells();
			
						 	int columnCount = 1;		
							for(XWPFTableCell cell : cells) {	
								
								if(columnCount == 1 && cell.getText().trim() != "" ) {
									
										System.out.println(cell.getText());
									
								}
								if(columnCount == 2 && cell.getText().trim() != "") {
									System.out.println(cell.getText());
								}
								if(columnCount == 3 && cell.getText().trim() != "") {
									System.out.println(cell.getText());
								}
								if(columnCount == 4 && cell.getText().trim() != "") {
									System.out.println(cell.getText());
								}
								if(columnCount == 5 && cell.getText().trim() != "") {
									System.out.println(cell.getText());
								}
								if(columnCount == 6 && cell.getText().trim() != "") {
									System.out.println(cell.getText());
								}
								if(columnCount == 7 && cell.getText().trim() != "") {
									System.out.println(cell.getText());
								}
								if(columnCount == 8 && cell.getText().trim() != "") {
									System.out.println(cell.getText());
								}
								if(columnCount == 9 && cell.getText().trim() != "") {
									System.out.println(cell.getText());
								}

									columnCount++;
							   }
							System.out.println("i m here");
						    }
					    }
					}
			    }
			}
			
			
			
		}
		
		
		return "";
	}

}