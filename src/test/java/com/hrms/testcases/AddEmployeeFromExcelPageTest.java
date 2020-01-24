package com.hrms.testcases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.*;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.ViewEmployeePageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.Constants;

/**
 * 
 * @author natalia
 *This class contains 2 methods:
 *	addEmployeeExcelReader() --> @DataProvider
 *	createEmployeeFromExcel() with 3 input String parameters provided by @DataProvider
 *
 *@DataProvider takes data from Excel file and add to 2D Array;
 *
 */
public class AddEmployeeFromExcelPageTest extends CommonMethods {
	
	@Test(dataProvider="addEmployeeExcelReader")
	public void createEmployeeFromExcel(String fName, String mName, String lName) throws InterruptedException {
		//create an Object of LoginPageElements
		LoginPageElements login = new LoginPageElements();
		//create an Object of DashboardPageElements
		DashboardPageElements dashboard = new DashboardPageElements();
		//create an Object of AddEmployeePageElements
		AddEmployeePageElements emp = new AddEmployeePageElements();
		//create an Object of ViewEmployeePageElements
		ViewEmployeePageElements viewEmp = new ViewEmployeePageElements();
	
		//Login
		sendText(login.username, usePropertiesFile("username"));
		sendText(login.password, usePropertiesFile("password"));
		click(login.loginBtn);
		
		//navigate to the Add Employee Page
		jsClick(dashboard.PIMLink);
		jsClick(dashboard.AddEmpLink);
		
		//Send data provided by @DataProvider
		sendText(emp.firstName, fName);
		sendText(emp.middleName, mName);
		sendText(emp.lastName, lName);
		jsClick(emp.saveBtn);
		
		//Checking if expected and actual IDs is matched
		Assert.assertEquals(viewEmp.ActualEmployeeID.getText(), emp.personalEmpID.getText(), "ID is NOT matched");
		Thread.sleep(2000);
		
	}
	
	@DataProvider
	public Object[][] addEmployeeExcelReader() throws IOException {
		String filePath = Constants.EMPLOYEE_EXCEL_PATH;
		FileInputStream fis = new FileInputStream(filePath);
		
		Workbook workbook = new XSSFWorkbook(fis);
		
		Sheet sheet = workbook.getSheet("Sheet1");
		
		int rows = sheet.getPhysicalNumberOfRows();
		
		int cols = sheet.getRow(0).getPhysicalNumberOfCells();
		
		//Creating Object to store data from Excel
		// [rows-1] --> because we wants to ignore Header Row, so we need to store row.size - 1 
		Object[][] array = new Object[rows-1][cols];
		
		//avoid First row with Header. Here we starts looping from second row of Excel
		// So, we start looping with int i = 1 (from the second row)
		for(int i = 1; i < rows; i++) {
			//looping from first column of Excel
			for(int y = 0; y < cols; y++) {
				//retrieve value from excel by specified row and column
				String valueOfCell = sheet.getRow(i).getCell(y).toString();
				//store retrieved data into 2D array
				//[i-1][y] --> because we need to add data to array with index[0][0]
				array[i-1][y] = valueOfCell;
				System.out.println(array[i-1][y]);
			}
			System.out.println("");
		}
		return array;
		
	}
	
	

}
