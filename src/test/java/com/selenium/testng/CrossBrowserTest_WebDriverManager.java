package com.selenium.testng;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;

public class CrossBrowserTest_WebDriverManager {

	WebDriver w;

    @Test(priority=0,description="Validate application on chrome browser")
	public void chromeBrowser() throws Exception {
		
    	WebDriverManager.chromedriver().setup();
		w = new ChromeDriver();
		w.get("https://www.google.com/");
		Thread.sleep(2000);
		w.quit();		
	}
	
	@Test(priority=1,description="Validate application on firfox browser")
	public void firefoxBrowser() throws Exception {		
		
		WebDriverManager.firefoxdriver().setup();
		w=new FirefoxDriver();
		w.get("https://www.google.com/");
		Thread.sleep(2000);
		w.quit();
	
	}


	@Test(priority=2,description="Validate application on edge browser")
	public void edgeBrowser() throws Exception {
		
		WebDriverManager.edgedriver().setup();
		w=new EdgeDriver();
		w.get("https://www.google.com/");
		Thread.sleep(2000);
		w.quit();
	
	}
	
	@Test(priority=3,description="Validate application on IE browser")
	public void ieBrowser() throws Exception {
		
		WebDriverManager.iedriver().setup();
		w=new InternetExplorerDriver();
		w.get("https://www.google.com/");
		Thread.sleep(2000);
		w.quit();
	
	}


}
