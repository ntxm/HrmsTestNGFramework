package com.hrms.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.hrms.utils.Constants;

public class BaseClass {
	
    public static WebDriver driver;
    
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
    	
        switch (Constants.BROWSER.toLowerCase()) {
      
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
        
        driver.get(Constants.HRMS_URL);
    }
    
    
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    	
    }
}




