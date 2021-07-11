package com.selenium.testng;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class BasicWebObject {
	
 WebDriver w;
	
  @BeforeTest
  public void preCondition() {
	  
	  WebDriverManager.chromedriver().setup();
	  w=new ChromeDriver();
  }
  
  @Test(priority=0,description="test case to handle textbox")
  public void handleTextBox() {
	  
	  w.get("http://demo.automationtesting.in/Register.html");
	  
	 WebElement firstName=w.findElement(By.cssSelector("input[ng-model='FirstName']"));
	 firstName.clear();
	 firstName.sendKeys("Jones");
	  
	  w.findElement(By.cssSelector("input[ng-model='LastName']")).clear();
	  w.findElement(By.cssSelector("input[ng-model='LastName']")).sendKeys("Smith");
	  
	  
	  String pageLabel=w.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/h1")).getText();
	  System.out.println("Page Label is : "+pageLabel);
	  
	  String firstNameValue=w.findElement(By.cssSelector("input[ng-model='FirstName']")).getAttribute("value");
	  System.out.println("FirstName entered : "+firstNameValue);
	  
	  String lastNameValue=w.findElement(By.cssSelector("input[ng-model='LastName']")).getAttribute("value");
	  System.out.println("LastName entered : "+lastNameValue);
	  
	 
	  w.findElement(By.cssSelector("textarea[ng-model='Adress']")).clear();
	  w.findElement(By.cssSelector("textarea[ng-model='Adress']")).sendKeys("234 , Sample road , building / flat -2 ");
	 
      w.findElement(By.cssSelector("input[ng-model='EmailAdress']")).clear();
	  w.findElement(By.cssSelector("input[ng-model='EmailAdress']")).sendKeys("automation@gmail.com");
	 
  }
  
  @Test(priority=1,description="test case to handle radioButton")
  public void handleRadioButton() {
	
	WebElement radioButtonFemale= w.findElement(By.xpath("//input[@value='FeMale']"));
	radioButtonFemale.click();
  
  }
	
  @Test(priority=2,description="test case to handle checkBox")
  public void handlecheckBox() throws Exception {
	
	  w.findElement(By.xpath("//input[@value='Cricket']")).click();
	  w.findElement(By.xpath("//input[@value='Hockey']")).click();
	  
	Thread.sleep(2000);
	
//	DataType - > WebElement
	
	WebElement HockeyCheckBox=w.findElement(By.xpath("//input[@value='Hockey']"));
	  
      System.out.println("status of HockeyCheckBox : "+HockeyCheckBox.isSelected());
	  
	  if(HockeyCheckBox.isSelected()) {
		  HockeyCheckBox.click();
	  }
	  
      System.out.println("status of HockeyCheckBox : "+HockeyCheckBox.isSelected());
  
  }
  
  
  @Test(priority=3,description="test case to handle drop-down list")
  public void handleDropDown() throws Exception {
	  
	  
	  WebElement skills=w.findElement(By.id("Skills"));
	  
	  Select sel=new Select(skills);
	  
	//  sel.selectByIndex(5);
	  
	// sel.selectByValue("Android"); 
	  
	  sel.selectByVisibleText("CSS");
	
  }
	

  @AfterTest
  public void postCondition() {
 // w.quit();
  }

}
