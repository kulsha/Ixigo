package com.ixigo.testcases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ixigo.pages.ixigoHome;
import com.project.common.util.BaseTest;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;


@Listeners(com.ixigo.listeners.TestNGListeners.class)
public class HomePageTest extends BaseTest {
	ixigoHome hp ;
	

	@BeforeMethod
	public void beforeMethod()
	{
		
		//logReport = report.createTest(Thread.currentThread().getStackTrace()[1].getMethodName().toString()); 
		//logReport = report.createTest("Test");
		BaseTest bt = new BaseTest();
		initialization();
		 hp = new ixigoHome();
		
	}
	
	@Test(description  = "Ixigo" , priority=0)
	public void ixigo () throws InterruptedException
	{
		logReport = report.createTest("Test case 1: ixigo"); // test case name in extent report
		logReport.info("browser launched , url entered"); //extent report
		log.info("test case 1 starting *****************************");
		hp.ixigoNonstop();
	}
	
	
	
	
	

}
