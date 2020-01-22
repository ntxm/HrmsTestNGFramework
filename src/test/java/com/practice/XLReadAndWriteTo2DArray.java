package com.practice;

import java.io.FileInputStream;

import java.io.IOException;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class XLReadAndWriteTo2DArray {
	
	@Test
	public void read() throws IOException {
		//provide path to file
		String filePath = "/Users/natalia/eclipse-workspace/HRMS/src/test/resources/Book1.xlsx";
		//create file input stream object and load file
		FileInputStream fis = new FileInputStream(filePath);
		
		//to read excel we need to use different classes
		//Workbook wbook=HSSFWorkbook() --> 2003 xfiles
		//create object for workbook and load file
		Workbook wbook = new XSSFWorkbook(fis);// for 2007 files
		//get the sheet which you want to modify or create
		Sheet sheet = wbook.getSheet("Sheet1");
		
		//Row row = sheet.getRow(0);
		//Cell cell = row.getCell(0);
		//String value = cell.toString();
		
		//get number of rows
		int rows = sheet.getPhysicalNumberOfRows();
		//get number of cols
		int cols = sheet.getRow(0).getLastCellNum();
		//create 2D array with rows and cols size
		String[][] array = new String[rows][cols];
		//loop through each row and column
		for(int i = 0; i < rows; i++) {
			for(int y = 0; y < cols; y++) {
				//access value at specified location
				String cellValue = sheet.getRow(i).getCell(y).toString();
				//add to 2d array
				array[i][y] = cellValue;
				
				
				System.out.println(array[i][y]);
				
			}
			System.out.println(" ");
		}
		
		
	}
}

