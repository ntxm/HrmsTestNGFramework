package com.hrms.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;

public class BaseClass {
	
    public static WebDriver driver;
    public static ExtentHtmlReporter html;
	public static ExtentReports report;
    
    
    @BeforeTest(alwaysRun = true)
	public void generateReports() {

		ConfigsReader.readProperties(Constants.CREDENTIAL_FILEPATH);
		html=new ExtentHtmlReporter(Constants.REPORT_FILEPATH);
		html.config().setTheme(Theme.DARK);
		html.config().setDocumentTitle("Syntax Batch V Report");
		html.config().setReportName("HRM Execution Report");
		
		report=new ExtentReports();
		report.attachReporter(html);
		report.setSystemInfo("QA Engineer", Constants.USER_NAME);
		report.setSystemInfo("Environment", "Test");
		report.setSystemInfo("OS Name", Constants.OS_NAME);
		report.setSystemInfo("Browser", ConfigsReader.getProperty("browser"));
	}
    
    
	
	@AfterTest(alwaysRun=true)
	public void writeReport(){
		report.flush();
	}
	
	
    
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
    	
    	ConfigsReader.readProperties(Constants.CREDENTIAL_FILEPATH);
    	
        switch (ConfigsReader.getProperty("browser").toLowerCase()) {
      
        case "chrome":
            System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
            driver = new ChromeDriver();
            break;
        
        case "firefox":
            System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
            driver = new FirefoxDriver();
            break;
        
        default:
            System.err.println("Browser is not supported");
        }
        
        driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_LOAD_TIME, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        
        driver.get(ConfigsReader.getProperty("url"));
    }
    
    
    
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    	
    }
}




