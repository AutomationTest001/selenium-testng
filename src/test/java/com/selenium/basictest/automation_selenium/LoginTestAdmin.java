package com.selenium.basictest.automation_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestAdmin {

	public static void main(String[] args) throws Exception {		
	
		String projectPath=System.getProperty("user.dir"); //return current project path
		String chromeExePath=projectPath+"\\BrowserDriver\\chromedriver.exe";
				
		
		System.setProperty("webdriver.chrome.driver", chromeExePath);		
		WebDriver w=new ChromeDriver(); // open browser -> Chrome
		
		w.get("https://demo.testfire.net/login.jsp");   // Step 1 : Open application with url
		
		w.findElement(By.id("uid")).sendKeys("admin"); // Step 2 : Enter username

		w.findElement(By.name("passw")).sendKeys("admin"); // Step 3 : Enter password
		
		
		w.findElement(By.name("btnSubmit")).click();// Step 4 : Click login
		
		Thread.sleep(3000);// pause 3 sec - 3000 sec 
		
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click(); //Step 5 : Click Logout
		
		w.quit(); // Step 6 : Close Browser
		
		
		System.out.println("Login Test Case Executed Successfully !!");
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
