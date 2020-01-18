package com.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.hrms.pages.LoginPage;
import com.hrms.utils.CommonMethods;

public class LoignPageTest extends CommonMethods {
	
	@Test
	public void login() {
		
		LoginPage login = new LoginPage();
		sendText(login.username, "Admin");
		sendText(login.password, "Hum@nhrm123");
		click(login.loginBtn);
		
	}
	
	@Test 
	public void negativeLogin() {
		LoginPage login = new LoginPage();
		sendText(login.username, "Admin");
		click(login.loginBtn);
		String errorExpected = "Password cannot be empty";
		Assert.assertEquals(login.errMsg.getText(), errorExpected);
		
	}

}