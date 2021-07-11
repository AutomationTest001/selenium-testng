package com.selenium.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class MutualLogin {

	WebDriver w;

	@BeforeTest
	public void preCondition() {

		String projectPath = System.getProperty("user.dir");
		String chromeExePath = projectPath + "\\BrowserDriver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeExePath);
		w = new ChromeDriver();

	}
	
	//passw -> password

	@Test(priority = 0, description = "Test Case to verify Login functionality with 'admin' user",groups="Login Module",invocationCount=3,enabled=true)
	public void loginAdmin() throws Exception {

		w.get("https://demo.testfire.net/login.jsp");

		w.findElement(By.id("uid")).sendKeys("admin");

		w.findElement(By.name("passw")).sendKeys("admin");

		w.findElement(By.name("btnSubmit")).click();

		Thread.sleep(2000);

		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
		
		//Assert.assertTrue();
	}
	
	@Test(priority=1,description="Test Case to verify Login Functionality with 'jsmith' user",dependsOnMethods="loginAdmin",groups="Login Module",enabled=false)
	public void loginJsmith() throws Exception{
		
		
		w.get("https://demo.testfire.net/login.jsp");

		w.findElement(By.id("uid")).sendKeys("jsmith");

		w.findElement(By.name("passw")).sendKeys("Demo1234");

		w.findElement(By.name("btnSubmit")).click();

		Thread.sleep(2000);

		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();

	}
	
	
	@Test(priority=2,description="Test Case to verify Login Functionality with 'tuser' user",dependsOnMethods="loginAdmin",groups="Login Module",enabled=false)
	public void loginTestUser() throws Exception{
		
		
		w.get("https://demo.testfire.net/login.jsp");

		w.findElement(By.id("uid")).sendKeys("tuser");

		w.findElement(By.name("passw")).sendKeys("tuser");

		w.findElement(By.name("btnSubmit")).click();

		Thread.sleep(2000);

		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();

	}
	
	
	@Test(priority=3,description="Test Case to verify Login Functionality with 'sspeed' user",dependsOnMethods="loginAdmin",groups="Login Module")
	public void loginSpeed() throws Exception{
		
		
		w.get("https://demo.testfire.net/login.jsp");

		w.findElement(By.id("uid")).sendKeys("sspeed");

		w.findElement(By.name("passw")).sendKeys("Demo1234");

		w.findElement(By.name("btnSubmit")).click();

		Thread.sleep(2000);

		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();

	}



	@AfterTest
	public void postCondition() {

		w.quit();

	}

}
