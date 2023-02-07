package com.service;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.entity.User;



public class ExcelService {
	

	public static ByteArrayInputStream dataToExcel(List<User> user ) throws IOException{
		String[] columns = {"Id","Aggregrator","client","service","amount","frontEndUrl","schedulersBackendUrl","CCPortalUrl","ServerDetails","Database","serviceManager","SDPUrl","callBackUrl","localLocation","developer","serviceLaunchDate","field1","field2","field3","field4","field5","field6",
				"field7","field8","field9","field10"};
		try(
				Workbook workbook = new XSSFWorkbook();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
							
			){
			Sheet sheet = workbook.createSheet("VisiontrekData");
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());
			CellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setFont(headerFont);
			
			
			
			//Row For Header
			
			Row headerRow = sheet.createRow(0);
			
			
			//Header 
			for(int col =0; col<columns.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(columns[col]);
				cell.setCellStyle(cellStyle);
			}
			
			
			int rowIndex =1;
			for(User u : user) {
			
				Row row =  sheet.createRow(rowIndex++);
				row.createCell(0).setCellValue(u.getId());
				row.createCell(1).setCellValue(u.getAggregrator());
				row.createCell(2).setCellValue(u.getAmount());
				row.createCell(3).setCellValue(u.getCallBackUrl());
				row.createCell(4).setCellValue(u.getCCPortalUrl());
				row.createCell(5).setCellValue(u.getClient());
				row.createCell(6).setCellValue(u.getDatabase());
				row.createCell(7).setCellValue(u.getDeveloper());
				row.createCell(8).setCellValue(u.getFrontEndUrl());
				row.createCell(9).setCellValue(u.getLocalLocation());
				row.createCell(10).setCellValue(u.getSchedulersBackendUrl());
				row.createCell(11).setCellValue(u.getSDPUrl());
				row.createCell(12).setCellValue(u.getServerDetails());
				row.createCell(13).setCellValue(u.getService());
				row.createCell(14).setCellValue(u.getServiceLaunchDate());
				row.createCell(15).setCellValue(u.getServiceManager());
				row.createCell(16).setCellValue(u.getField1());
				row.createCell(16).setCellValue(u.getField2());
				row.createCell(17).setCellValue(u.getField3());
				row.createCell(18).setCellValue(u.getField4());
				row.createCell(19).setCellValue(u.getField5());
				row.createCell(20).setCellValue(u.getField6());
				row.createCell(21).setCellValue(u.getField7());
				row.createCell(22).setCellValue(u.getField8());
				row.createCell(22).setCellValue(u.getField9());
				row.createCell(23).setCellValue(u.getField10());
						
			}
			workbook.write(outputStream);
			
			return new  ByteArrayInputStream(outputStream.toByteArray());
			
			
		}
				
	
	
	
	}
	
	
	
	
	
	
}
