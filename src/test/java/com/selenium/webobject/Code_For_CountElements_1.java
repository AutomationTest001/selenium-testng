package com.selenium.webobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Code_For_CountElements_1 {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowserDriver\\chromedriver.exe");
		w = new ChromeDriver();
		w.manage().window().maximize();

	}

	@Test(priority = 0, description = "Test case to Count WebElements ")
	public void CountWebElement() throws Exception {

		w.get("http://demo.automationtesting.in/Register.html");
		Thread.sleep(2000);

		// Count number of radio button on web page.
		
		List <WebElement> radioButton=w.findElements(By.name("radiooptions"));
		int count_radioButton=radioButton.size();		
		System.out.println("Number of radio button : "+count_radioButton);	


		// Count number of checkbox on web page.
		
		
		List<WebElement> checkBox=w.findElements(By.cssSelector("input[type='checkbox']"));
		System.out.println("Number of checkbox : "+checkBox.size());	


		// Count number of Dropdown on web page.
		
		List<WebElement> dropDown=w.findElements(By.tagName("select"));
		System.out.println("Number of dropDown : "+dropDown.size());	


		// Count number of links on web page.
		
		List<WebElement> links=w.findElements(By.tagName("a"));
		System.out.println("Number of links : "+links.size());
		
		
		//Print value from drop-down list
		
		System.out.println("\n Print Value from Month drop-down : \n");
		
		WebElement monthDrop_Down=w.findElement(By.cssSelector("select[ng-model='monthbox']"));
		Select sel=new Select(monthDrop_Down);
		
		List <WebElement> values=sel.getOptions();		
		System.out.println("Number of value : "+values.size());
		
	/*	for(int i=0;i<values.size();i++) {
			
			System.out.println(values.get(i).getText());
		}
	*/
		
		for(WebElement data : values) {
			
			System.out.println(data.getText());
		}
		
		Thread.sleep(2000);

	}

	@AfterTest
	public void afterTest() {

		w.quit();
	}

}
