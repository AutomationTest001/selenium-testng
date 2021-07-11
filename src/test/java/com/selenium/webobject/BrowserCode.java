package com.selenium.webobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserCode {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.edgedriver().setup();
		
		//Polymorphism - Method overriding (runtime polymorphism)
		
		WebDriver w;		
		
		w=new ChromeDriver();
		w.get("https://www.google.com/");
		
		w=new FirefoxDriver();
		w.get("https://www.google.com/");
		
		w=new EdgeDriver();
		w.get("https://www.google.com/");

		
				
			
		
		//Inheritance implements webdriver parent - chromedriver and firefox and IEDriver child
		
		
		
		

	}

}
