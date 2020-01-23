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
	

}
