package com.hrms.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	private static Workbook wbook;
	private static Sheet sheet;
	
	public void openExcel(String filePath, String sheetName) {
		try {
			FileInputStream fis = new FileInputStream(filePath);
			try {
				wbook = new XSSFWorkbook(fis);
				sheet = wbook.getSheet(sheetName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public int rowCount() {
		int rows = sheet.getPhysicalNumberOfRows();
		return rows;
	}
	
	public int columnCount() {
		int columns = sheet.getRow(0).getPhysicalNumberOfCells();
		return columns;
	}
	
	public String getCellValue(int rowIndex, int colIndex) {
		String value = sheet.getRow(rowIndex).getCell(colIndex).toString();
		return value;
	}
	
	
	public Object[][] excelToArray(String filePath, String sheetName){
		
		openExcel(filePath, sheetName);
		
		Object[][] data = new Object[rowCount()-1][columnCount()];
		
		for(int i = 1; i < rowCount(); i++) {
			for(int y = 0; y< columnCount(); y++) {
				String value = sheet.getRow(i).getCell(y).toString();
				data[i-1][y] = value;
			}
		}
		return data;
		
	}

}
