package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class DashboardPageElements {
	
	@FindBy(linkText="Leave")
	public WebElement leaveLink;
	
	@FindBy(linkText = "Leave List")
	public WebElement leaveList;
	
	public DashboardPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}

}
