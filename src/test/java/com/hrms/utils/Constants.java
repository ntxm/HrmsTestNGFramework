package com.hrms.utils;

public class Constants {
	
	//public static final String HRMS_URL="http://166.62.36.207/Syntax_HRM";
	
	//public static final String BROWSER = "chrome";
	
	//specify path to chrome and gecko driver
	
	public static final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver";
			
	public static final String GECKO_DRIVER_PATH = System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver";
	
	public static final int PAGE_LOAD_TIME = 30;
	
	public static final int IMPLICIT_LOAD_TIME = 10;
	
	public static final int EXPLICIT_LOAD_TIME = 30;
	
	public static final String CREDENTIAL_FILEPATH = System.getProperty("user.dir") + "/src/test/resources/configs/Configurations.properties";
	
	public static final String EMPLOYEE_EXCEL_PATH = "/Users/natalia/eclipse-workspace/HRMS/src/test/resources/Book1.xlsx";
	
	public static final String EXCEL_DATA_FILEPATH = System.getProperty("user.dir") + "/src/test/resources/testdata/HrmsTestData.xlsx";
	
	public static final String REPORT_FILEPATH = System.getProperty("user.dir") + "/target/report/hrms.html";
	
	public static final String OS_NAME = System.getProperty("os.name");
	
	public static final String USER_NAME = System.getProperty("user.name");
	
	public static final String SCREENSHOTS_FILEPATH = System.getProperty("user.dir")+"/target/screenshots/";
	
	
}

