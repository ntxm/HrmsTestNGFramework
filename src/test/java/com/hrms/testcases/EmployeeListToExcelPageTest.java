package com.hrms.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.EmployeeListPageElement;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;

public class EmployeeListToExcelPageTest extends CommonMethods {
	
	@Test
	public void employeeListWriteToExcel() throws IOException {
		
		LoginPageElements login = new LoginPageElements();
		DashboardPageElements dashboard = new DashboardPageElements();
		EmployeeListPageElement empList = new EmployeeListPageElement();
		
		sendText(login.username, usePropertiesFile("username"));
		sendText(login.password, usePropertiesFile("password"));
		click(login.loginBtn);
		
		jsClick(dashboard.PIMLink);
		jsClick(dashboard.empList);
		
		String filePath = "/Users/natalia/eclipse-workspace/HRMS/src/test/resources/Book2.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		
		Workbook workbook = new XSSFWorkbook(fis);// for 2007 files
		Sheet sheet = workbook.getSheet("Sheet1");
		
		
		//List<WebElement> cellsData = empList.tableCell;
		List<WebElement> cellsData = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td"));
		
		for(int i = 0; i<cellsData.size(); i++) {
			String value = cellsData.get(i).getText();
			
			if(!value.isEmpty()) {
				sheet.createRow(i).createCell(i).setCellValue(value);
			}
			
		}
		
		FileOutputStream fos = new FileOutputStream(filePath);
		
		workbook.write(fos);
		workbook.close();
		fos.close();
		
	}

}
