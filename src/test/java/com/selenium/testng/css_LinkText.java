package com.selenium.testng;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class css_LinkText {

	WebDriver w;

	@BeforeTest
	public void preCondition() {
		WebDriverManager.chromedriver().setup();
		w = new ChromeDriver();
	}

	@Test(priority=0,description="Test case to verify css and linktext locator")
	public void cssLinkText_Code() throws Exception {
		
		w.get("https://opensource-demo.orangehrmlive.com/");
		
		w.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		
		
		w.findElement(By.cssSelector("input[name='txtPassword']")).sendKeys("admin123");		
		
		
		w.findElement(By.cssSelector("input.button")).click();
		
		Thread.sleep(2000); // 2sec pause
		
		w.findElement(By.cssSelector("a#welcome")).click();
		
		Thread.sleep(1000);// 2 sec  pause 
		
		w.findElement(By.linkText("Logout")).click();

		Thread.sleep(2000);

		
	}

	@AfterTest
	public void postCondition() {
		
		w.quit();
	}

}
