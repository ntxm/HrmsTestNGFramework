package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class LoginPageElements {
	
	@FindBy(xpath="//div[@id='divLogo']")
	public WebElement logo;
	
	@FindBy(id="LogInPanelHeading")
	public WebElement loginLabel;
	
	@FindBy(name="txtUsername")
	public WebElement username;
	
	@FindBy(css="input#txtPassword")
	public WebElement password;
	
	@FindBy(id="btnLogin")
	public WebElement loginBtn;
	
	@FindBy(id="spanMessage")
	public WebElement errorMsg;
	
	
	public LoginPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	

}
