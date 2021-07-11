package com.selenium.pageobject_test;

import org.testng.annotations.Test;

import com.selenium.pageobject.FixedDeposit_PageObj;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

//@Listeners(com.selenium.pageobject.ListenerCode.class)

public class FixedDeposit_Test {

	FixedDeposit_PageObj fd = new FixedDeposit_PageObj();

	@BeforeTest
	public void preCondition() throws Exception {
		
		fd.openBrowser(fd.readPropertiesFileValue("browser"));
		fd.callPageFactory_FixedDeposit_PageObj();
	}

	@Test(priority = 0, description = "Test case to verify fixed deposit for '100000'", groups = "Fixed Deposit")
	public void fd_10000() throws Exception {
		
		fd.openApplication(fd.readPropertiesFileValue("fd_url"));
		
		fd.handleTextBox(fd.principalTextBox, "100000");
		
		fd.handleTextBox(fd.roiTextBox, "8");

		fd.handleTextBox(fd.tenureTextBox, "3");
		
		fd.handleDropDown(fd.tenurePeriodDropDown, "year(s)");
		
		fd.handleDropDown(fd.frequencyDropDown, "Simple Interest");
		
		fd.handleClickEvent(fd.calculateBtn);
		
		fd.waitSec(2);
		
		String maturityValue=fd.verifyText(fd.maturityValue);
		
		System.out.println("Maturity Value for 1 lakh FD : "+maturityValue);
		
		Assert.assertEquals(maturityValue, "124000.00");
		

	}
	
	
	@Test(priority = 1, description = "Test case to verify fixed deposit for '400000'", groups = "Fixed Deposit")
	public void fd_40000() throws Exception {
		
		fd.openApplication(fd.readPropertiesFileValue("fd_url"));
		
		fd.handleTextBox(fd.principalTextBox, "400000");
		
		fd.handleTextBox(fd.roiTextBox, "7.5");

		fd.handleTextBox(fd.tenureTextBox, "2");
		
		fd.handleDropDown(fd.tenurePeriodDropDown, "year(s)");
		
		fd.handleDropDown(fd.frequencyDropDown, "Simple Interest");
		
		fd.handleClickEvent(fd.calculateBtn);
		
		fd.waitSec(2);
		
		String maturityValue=fd.verifyText(fd.maturityValue);
		
		System.out.println("Maturity Value for 4 lakh FD : "+maturityValue);
		

		

	}


	@AfterTest
	public void postCondition() {
	
		fd.closeBrowser();
	
	}

}
