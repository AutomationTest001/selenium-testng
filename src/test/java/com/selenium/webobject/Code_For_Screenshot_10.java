package com.selenium.webobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Code_For_Screenshot_10 {

	WebDriver w;
	String projectPath;

	@BeforeTest
	public void beforeTest() {

		projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", projectPath + "\\BrowserDriver\\geckodriver.exe");
		w=new FirefoxDriver();
		
	}

	@Test
	public void Code_For_Screenshot() throws Exception {


         // .png   .jpg    .gif	
		String screenshotPath=projectPath +"\\Screenshot\\RegisterPage.png";
		
		w.get("http://demo.automationtesting.in/Register.html");

		
		TakesScreenshot ts=(TakesScreenshot) w;
		File f=ts.getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(f, new File(screenshotPath));
		
		
        Thread.sleep(2000);
		
        
		/*
		  
		 * For FileUtils add dependencies in pom.xml.
		 
		  <dependency>
		  
		   <groupId>commons-io</groupId>
		 <artifactId>commons-io</artifactId> 
		 <version>2.6</version>
		 
		    </dependency>
		 
		 
		 * 
		 */

	}

	@AfterTest
	public void afterTest() {

		w.quit();
	}

}
