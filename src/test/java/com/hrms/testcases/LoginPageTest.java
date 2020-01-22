package com.hrms.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.hrms.pages.LoginPage;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;

public class LoginPageTest extends CommonMethods {
	
	@Test(groups="smoke")
	public void login() {
		
		LoginPage login = new LoginPage();
		sendText(login.username, usePropertiesFile("username"));
		sendText(login.password, usePropertiesFile("password"));
		click(login.loginBtn);
		
	}
	
	@Test (groups="regression")
	public void negativeLogin() throws InterruptedException {
		LoginPageElements login = new LoginPageElements();
		sendText(login.username, usePropertiesFile("username"));
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
	
	//Login using properties file through usePropertiesFile
	@Test(groups="regression")
	public void loginWithProperties() {
		LoginPage login = new LoginPage();
		sendText(login.username, usePropertiesFile("username"));
		sendText(login.password, usePropertiesFile("password"));
		jsClick(login.loginBtn);
		
	}

}
