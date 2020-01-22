package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class XLReader {
	
	@Test
	public void read() throws IOException {
		String filePath = "/Users/natalia/eclipse-workspace/HRMS/src/test/resources/Book1.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		
		//to read excel we need to use different classes
		//Workbook wbook=HSSFWorkbook() --> 2003 xfiles
		Workbook wbook = new XSSFWorkbook(fis);// for 2007 files
		Sheet sheet = wbook.getSheet("Sheet1");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String value = cell.toString();
		System.out.println(value);
		String value2= sheet.getRow(1).getCell(1).toString();
 		System.out.println(value2);
		
	}
}
