package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelRecap {
	
	@Test
	public void readExcel() throws IOException {
		String filePath = System.getProperty("user.dir")+ "/src/test/resources/Book1.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		
		Workbook wbook = new XSSFWorkbook(fis);
		Sheet sheet = wbook.getSheet("Sheet1");
		int rows = sheet.getPhysicalNumberOfRows();
		int cells = sheet.getRow(0).getPhysicalNumberOfCells();
		
		for(int i = 0; i < rows; i++) {
			for(int  j = 0; j < cells; j++) {
				String value = sheet.getRow(i).getCell(j).toString();
				System.out.println(value);
			}
		}
		
		
	}

}
