package com.hrms.testbase;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.hrms.utils.CommonMethods;

public class Listener extends CommonMethods implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		System.out.println("Test started: " + result.getName());
		test = report.createTest(result.getName());
		
	}
	
	public void onTestSuccess(ITestResult result) {
	    System.out.println("Test passed: " + result.getName());
	    test.pass("Test passed " + result.getName());
	    String imagePath = CommonMethods.takeScreenshot("passed/" + result.getName());
	    try {
			test.addScreenCaptureFromPath(imagePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }
	
	public void onTestFailure(ITestResult result) {
	    System.out.println("Test failed: " + result.getName());
	    test.pass("Test failed " + result.getName());
	    String imagePath = CommonMethods.takeScreenshot("failed/" + result.getName());
	    try {
			test.addScreenCaptureFromPath(imagePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }
	
	 public void onTestSkipped(ITestResult result) {
		   System.out.println("Test skipped: " + result.getName());
		   test.pass("Test skipped " + result.getName());
		  }
}
