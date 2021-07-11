package com.selenium.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;

public class CrossBrowserTest {

	WebDriver w;
	String projectPath = System.getProperty("user.dir");
	String chromeExePath = projectPath + "\\BrowserDriver\\chromedriver.exe";
	String firefoxExePath=projectPath +   "\\BrowserDriver\\geckodriver.exe";
	String edgeExePath=projectPath +       "\\BrowserDriver\\msedgedriver.exe";
	String ieExePath=projectPath +       "\\BrowserDriver\\IEDriverServer.exe";

    @Test(priority=0,description="Validate application on chrome browser")
	public void chromeBrowser() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", chromeExePath);
		w = new ChromeDriver();
		w.get("https://www.google.com/");
		Thread.sleep(2000);
		w.quit();		
	}
	
	@Test(priority=1,description="Validate application on firfox browser")
	public void firefoxBrowser() throws Exception {		
		
		System.setProperty("webdriver.gecko.driver", firefoxExePath);
		w=new FirefoxDriver();
		w.get("https://www.google.com/");
		Thread.sleep(2000);
		w.quit();
	
	}


	@Test(priority=2,description="Validate application on edge browser")
	public void edgeBrowser() throws Exception {
		
		
		System.setProperty("webdriver.edge.driver", edgeExePath);
		w=new EdgeDriver();
		w.get("https://www.google.com/");
		Thread.sleep(2000);
		w.quit();
	
	}
	
	@Test(priority=3,description="Validate application on IE browser")
	public void ieBrowser() throws Exception {
		
		
		System.setProperty("webdriver.ie.driver", ieExePath);
		w=new InternetExplorerDriver();
		w.get("https://www.google.com/");
		Thread.sleep(2000);
		w.quit();
	
	}


}
