package com.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


public class WriteToExcel {
	
	@Test
	public void writeToExcel() throws IOException {
		String filePath = "/Users/natalia/eclipse-workspace/HRMS/src/test/resources/Book2.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		
		Workbook workbook = new XSSFWorkbook(fis);// for 2007 files
		Sheet sheet = workbook.getSheet("Sheet1");
		sheet.createRow(4).createCell(0).setCellValue("User");
		sheet.getRow(4).createCell(1).setCellValue("User123");
		
		FileOutputStream fos = new FileOutputStream(filePath);
		
		workbook.write(fos);
		workbook.close();
		fos.close();
	}

}
