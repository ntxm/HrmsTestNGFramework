package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyFileReading {

	Properties property;
	
	@Test
	public void read() throws IOException {
	String filePath = System.getProperty("user.dir") + "/src/test/java/com/practice/example.properties";
	
	//create File Input Stream Object
	try {
		FileInputStream fis = new FileInputStream(filePath);
		property = new Properties();
		property.load(fis);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	
	String cityValue = property.getProperty("city");
	System.out.println(cityValue);
	String url = property.getProperty("mainURL");
	System.out.println(url);
			
	}
}
