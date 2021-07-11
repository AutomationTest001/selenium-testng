package com.selenium.pageobject_test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.selenium.pageobject.FixedDeposit_PageObj;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

@Listeners(com.selenium.pageobject.ListenerCode.class)

public class FixedDeposit_Test_ExtentReport {

	FixedDeposit_PageObj fd = new FixedDeposit_PageObj();

	ExtentHtmlReporter extentHtmlReporter;
	ExtentReports extentReports;
	ExtentTest extentTest;

	@BeforeTest
	public void preCondition() throws Exception {

		fd.openBrowser(fd.readPropertiesFileValue("browser"));
		fd.callPageFactory_FixedDeposit_PageObj();

		extentHtmlReporter = new ExtentHtmlReporter(fd.projectPath + "\\TestReport.html");
		extentHtmlReporter.config().setDocumentTitle("Fixed Deposit Report");
		extentHtmlReporter.config().setReportName("Fixed Deposit Test Suite");

		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
		extentReports.setSystemInfo("Automation Tool", "Selenium 3.141.59");
		extentReports.setSystemInfo("Prgramming Lanaguage", "Java 8");
		extentReports.setSystemInfo("Test Build", "Smoke Test");

	}

	@Test(priority = 0, description = "Test case to verify fixed deposit for '100000'", groups = "Fixed Deposit")
	public void fd_10000() throws Exception {

		extentTest = extentReports.createTest("Fixed deposit for 1 lakh");

		fd.openApplication(fd.readPropertiesFileValue("fd_url"));

		fd.handleTextBox(fd.principalTextBox, "100000");

		fd.handleTextBox(fd.roiTextBox, "8");

		fd.handleTextBox(fd.tenureTextBox, "3");

		fd.handleDropDown(fd.tenurePeriodDropDown, "year(s)");

		fd.handleDropDown(fd.frequencyDropDown, "Simple Interest");

		fd.handleClickEvent(fd.calculateBtn);

		fd.waitSec(2);

		String maturityValue = fd.verifyText(fd.maturityValue);

		System.out.println("Maturity Value for 1 lakh FD : " + maturityValue);

		Assert.assertEquals(maturityValue, "124000.00");

	}

	@Test(priority = 1, description = "Test case to verify fixed deposit for '400000'", groups = "Fixed Deposit")
	public void fd_40000() throws Exception {

		extentTest = extentReports.createTest("Fixed deposit for 4 lakh");

		fd.openApplication(fd.readPropertiesFileValue("fd_url"));

		fd.handleTextBox(fd.principalTextBox, "400000");

		fd.handleTextBox(fd.roiTextBox, "7.5");

		fd.handleTextBox(fd.tenureTextBox, "2");

		fd.handleDropDown(fd.tenurePeriodDropDown, "year(s)");

		fd.handleDropDown(fd.frequencyDropDown, "Simple Interest");

		fd.handleClickEvent(fd.calculateBtn);

		fd.waitSec(2);

		String maturityValue = fd.verifyText(fd.maturityValue);

		System.out.println("Maturity Value for 4 lakh FD : " + maturityValue);

	}

	@AfterMethod
	public void updateExtentReport(ITestResult result) throws Exception {
		
		String ScreenshotPass=fd.projectPath+"\\Screenshot\\Pass\\"+result.getMethod().getMethodName()+".png";
		String ScreenshotFail=fd.projectPath+"\\Screenshot\\Fail\\"+result.getMethod().getMethodName()+".png";


		if (result.getStatus() == ITestResult.SUCCESS) {

			extentTest.log(Status.PASS, result.getName());
			
			
			
			MediaEntityModelProvider mediaModel = 
					MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotPass).build();
			extentTest.pass("details", mediaModel);

		} else if (result.getStatus() == ITestResult.FAILURE) {

			extentTest.log(Status.FAIL, result.getName());
			
			MediaEntityModelProvider mediaModel = 
					MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotFail).build();
			extentTest.fail("details", mediaModel);

		}
		
		extentReports.flush();
	}

	@AfterTest
	public void postCondition() {

		fd.closeBrowser();

	}

}
