package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class LeaveListPageElements {

	@FindBy(css="a.toggle.tiptip")
	public WebElement leaveListLbl;
	
	public LeaveListPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}
