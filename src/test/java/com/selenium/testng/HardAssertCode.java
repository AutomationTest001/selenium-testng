package com.selenium.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class HardAssertCode {

	WebDriver w;

	@BeforeTest
	public void preCondition() {

		String projectPath = System.getProperty("user.dir");
		String chromeExePath = projectPath + "\\BrowserDriver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeExePath);
		w = new ChromeDriver();

	}

	@Test(priority = 0, description = "Test case to verify login functionality", groups = "Login")
	public void adminLogin() throws Exception {

		w.get("https://demo.testfire.net/login.jsp");

		String loginPageTitle = w.getTitle();
		
		//Junit (Expected - > Actual )
	//Assert.assertArrayEquals(expecteds, actuals);
		Assert.assertEquals("Altoro Mutual", loginPageTitle);

		//TestNG  (Actual -> Excepted)
	//	Assert.assertEquals(actual, expected);
		Assert.assertEquals(loginPageTitle, "Altoro Mutual");

		String loginPageUrl = w.getCurrentUrl(); // http://demo.testfire.net/login.jsp
		Assert.assertTrue(loginPageUrl.contains("login"), "URL doesnt contains login keyword");

		String loginPageLabel = w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1")).getText();
		Assert.assertTrue(loginPageLabel.contains("Login"), "Login Page label is different");

		w.findElement(By.id("uid")).sendKeys("admin");

		w.findElement(By.name("passw")).sendKeys("admin");

		w.findElement(By.name("btnSubmit")).click();

		Thread.sleep(2000);

	}

	@Test(priority = 1, description = "Test case to verify logout functionality", groups = "Login", dependsOnMethods = "adminLogin")
	public void adminLogout() {

		String homePageTitle = w.getTitle();
		Assert.assertEquals(homePageTitle, "Altoro Mutual");

		String homePageLabel = w.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/h1")).getText();
		Assert.assertTrue(homePageLabel.contains("Admin"));

		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();

	}

	@AfterTest
	public void postCondition() {

	//	w.quit();
	}

}
