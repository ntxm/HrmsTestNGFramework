package com.hrms.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LeaveListPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;

public class LeaveListPageTest extends CommonMethods {
	
	@Test(groups="regression")
	public void leaveLabelValidation() {
		//LoginPageElements  object
		LoginPageElements login = new LoginPageElements();
		//Dashboard object
		DashboardPageElements dashboard = new DashboardPageElements();
		//LeaveList object
		LeaveListPageElements leaveList = new LeaveListPageElements();
		
		sendText(login.username, "Admin");
		sendText(login.password, "Hum@nhrm123");
		click(login.loginBtn);
		click(dashboard.leaveLink);
		click(dashboard.leaveList);
		Assert.assertTrue(leaveList.leaveListLbl.isDisplayed(), "Label is NOT displayed");
		
	}
	
	@Test(groups="regression")
	public void leaveLabelValidation1() {
		LoginPageElements login = new LoginPageElements();
		DashboardPageElements dashboard = new DashboardPageElements();
		LeaveListPageElements leaveList = new LeaveListPageElements();
		
		login.login("Admin", "Hum@nhrm123");
		dashboard.navigateToLeaveList();
		Assert.assertTrue(leaveList.leaveListLbl.isDisplayed(), "Label is NOT displayed");
	}

}
