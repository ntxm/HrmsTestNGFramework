package com.hrms.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.hrms.pages.LoginPage;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;

public class LoginPageTest extends CommonMethods {
	
	@Test(groups="smoke")
	public void login() {
		
		LoginPage login = new LoginPage();
		sendText(login.username, "Admin");
		sendText(login.password, "Hum@nhrm123");
		click(login.loginBtn);
		
	}
	
	@Test (groups="regression")
	public void negativeLogin() throws InterruptedException {
		LoginPageElements login = new LoginPageElements();
		sendText(login.username, "Admin");
		click(login.loginBtn);
		String errorExpected = "Password cannot be empty";
		Assert.assertEquals(login.errorMsg.getText(), errorExpected, "Error message text is not displayed");
		Thread.sleep(3000);
	}
	
	@Test(groups="smoke")
	public void logo() {
		LoginPage login = new LoginPage();
		boolean isDisplayed = login.logo.isDisplayed();
		Assert.assertTrue(isDisplayed, "Logo is not displayed");
	}

}
