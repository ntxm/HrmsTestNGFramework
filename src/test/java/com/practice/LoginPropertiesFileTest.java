package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.Constants;

public class LoginPropertiesFileTest extends CommonMethods {
	
	Properties property;
	
	@Test
	public void login() throws InterruptedException {
		
		String filePath = System.getProperty("user.dir")+ "/src/test/java/com/practice/settings.properties";
		try {
			FileInputStream fis = new FileInputStream(filePath);
			property = new Properties();
			property.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
		}
		
		//String loginUsername = ;
		LoginPageElements login = new LoginPageElements();
		sendText(login.username, property.getProperty("username"));
		sendText(login.password, property.getProperty("password"));
		jsClick(login.loginBtn);
		
		Thread.sleep(2000);

		
	}
	////////////////////////////////////////////
	
	@Test
	public void addEmployeeExcelReader() throws IOException {
		String filePath = Constants.EMPLOYEE_EXCEL_PATH;
		FileInputStream fis = new FileInputStream(filePath);
		
		Workbook workbook = new XSSFWorkbook(fis);
		
		Sheet sheet = workbook.getSheet("Sheet1");
		
		int rows = sheet.getPhysicalNumberOfRows();
		
		int cols = sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] array = new Object[rows][cols];
		
		for(int i = 0; i < rows; i++) {
			for(int y = 0; y < cols; y++) {
				String valueOfCell = sheet.getRow(i).getCell(y).toString();
				array[i][y] = valueOfCell;
				System.out.println(array[i][y]);
			}
			System.out.println("");
		}
		//return array;
		
	}
	

}
