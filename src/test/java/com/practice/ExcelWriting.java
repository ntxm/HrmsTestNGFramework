package com.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelWriting {
	//Assel
	@Test
	public void write() throws IOException {
		String filePath = System.getProperty("user.dir")+ "/src/test/resources/Book2.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		
		Workbook book = new XSSFWorkbook(fis);
		Sheet sheet = book.getSheet("Sheet1");
		sheet.createRow(0).createCell(0).setCellValue("Language");
		sheet.getRow(0).createCell(1).setCellValue("Instructor");
		sheet.getRow(0).createCell(1).setCellValue("Java");
		
		FileOutputStream fos = new FileOutputStream(filePath);
		book.write(fos);
		fos.close();
		book.close();
		fis.close();
		
	}

}
