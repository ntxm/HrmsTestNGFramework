package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.ViewEmployeePageElements;
import com.hrms.utils.CommonMethods;

public class AddEmployeePageTest extends CommonMethods {
	
	@Test(groups="regression")
	public void AddNewEmployee() throws InterruptedException {
	//create LoginPageElements, AddEmployeePageElements and ViewEmployeePageElements Objects
	LoginPageElements login = new LoginPageElements();
	DashboardPageElements dashboard = new DashboardPageElements();
	AddEmployeePageElements addEmployee = new AddEmployeePageElements();
	ViewEmployeePageElements viewEmployee = new ViewEmployeePageElements();
	
	test.info("Login in into HRMS");
	sendText(login.username, "Admin");
	sendText(login.password,"Syntax@123");
	click(login.loginBtn);
	
	test.info("Navigate to add employee page");
	waitForClickability(dashboard.PIMLink);
	jsClick(dashboard.PIMLink);
	jsClick(dashboard.AddEmpLink);
	click(dashboard.AddEmpLink);
	
	test.info("Add employee");
	waitForClickability(addEmployee.firstName);
	sendText(addEmployee.firstName, "Ann");
	sendText(addEmployee.middleName, "Maria");
	sendText(addEmployee.lastName, "Espaniollo");

	click(addEmployee.saveBtn);
	
	test.info("Validate created employee compare empID");
	Assert.assertEquals(viewEmployee.ActualEmployeeID.getText(), addEmployee.personalEmpID.getText()+"11","Employee IDs is not match");
	Thread.sleep(4000);
	
	
	
	}
	
	
	

}
