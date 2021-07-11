package com.selenium.webobject;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;


public class Code_For_Alert_2 {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		WebDriverManager.firefoxdriver().setup();
		w = new FirefoxDriver();

	}

	@Test
	public void Code_For_Alert_Test() throws Exception {

		w.get("https://demo.testfire.net/login.jsp");
	//	w.findElement(By.id("uid")).sendKeys("1");
	//	w.findElement(By.name("btnSubmit")).click();
		Thread.sleep(2000);

		try {
			w.switchTo().alert().accept();
			System.out.println("Alert Present...");
		} catch (NoAlertPresentException e) {

			System.out.println("No Alert !!!");
		}
		Thread.sleep(2000);

		w.findElement(By.id("uid")).clear();
		w.findElement(By.id("uid")).sendKeys("admin");
		w.findElement(By.id("passw")).clear();
		w.findElement(By.id("passw")).sendKeys("admin");
		w.findElement(By.name("btnSubmit")).click();
		Thread.sleep(3000);
		w.findElement(By.linkText("Sign Off")).click();
		Thread.sleep(2000);

	}

	@AfterTest
	public void afterTest() {

		w.quit();
	}

}
