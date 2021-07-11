package com.selenium.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FixedDeposit_PageObj extends TestBase{


	@FindBy(id = "principal")
	public WebElement principalTextBox;

	@FindBy(name = "interest")
	public WebElement roiTextBox;

	@FindBy(id = "tenure")
	public WebElement tenureTextBox;

	@FindBy(name = "tenurePeriod")
	public WebElement tenurePeriodDropDown;

	@FindBy(css = "select#frequency")
	public WebElement frequencyDropDown;

	@FindBy(xpath = "//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")
	public WebElement calculateBtn;

	@FindBy(xpath = "//*[@id=\"resp_matval\"]/strong")
	public WebElement maturityValue;

		
    public void callPageFactory_FixedDeposit_PageObj() {
    	
    	PageFactory.initElements(w, this);
    }
	
	

}
