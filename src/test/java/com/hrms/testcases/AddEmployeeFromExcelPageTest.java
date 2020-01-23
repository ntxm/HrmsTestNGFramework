package com.hrms.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.interactions.SendKeysAction;
import org.testng.Assert;
import org.testng.annotations.*;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.ViewEmployeePageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.Constants;

public class AddEmployeeFromExcelPageTest extends CommonMethods {
	
	@Test(dataProvider="addEmployeeExcelReader")
	public void createEmployeeFromExcel(String fName, String mName, String lName) throws InterruptedException {
		
		LoginPageElements login = new LoginPageElements();
		
		DashboardPageElements dashboard = new DashboardPageElements();
		
		AddEmployeePageElements emp = new AddEmployeePageElements();
		
		ViewEmployeePageElements viewEmp = new ViewEmployeePageElements();
	
		sendText(login.username, usePropertiesFile("username"));
		sendText(login.password, usePropertiesFile("password"));
		click(login.loginBtn);
		
		
		jsClick(dashboard.PIMLink);
		jsClick(dashboard.AddEmpLink);
		
		String empIDExpected = emp.personalEmpID.getText();
		sendText(emp.firstName, fName);
		sendText(emp.middleName, mName);
		sendText(emp.lastName, lName);
		jsClick(emp.saveBtn);
	
		Assert.assertEquals(viewEmp.ActualEmployeeID, empIDExpected, "ID is NOT matched");
		
		
	}
	
	@DataProvider
	public Object[][] addEmployeeExcelReader() throws IOException {
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
				//System.out.println(array[i][y]);
			}
			//System.out.println("");
		}
		return array;
		
	}
	
	

}
