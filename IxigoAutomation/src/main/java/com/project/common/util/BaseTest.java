package com.project.common.util;

import static com.project.common.util.BaseTest.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ixigo.testcases.HomePageTest;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop;
	public static Logger log = Logger.getLogger(BaseTest.class);
	public static ExtentTest logReport;
	public static ExtentReports report ;
	public static ExtentHtmlReporter reportH;
	
	@BeforeSuite
	 public void start()
	 {
			reportH=new ExtentHtmlReporter(new File (System.getProperty("user.dir")+"./ExtentReport/ExtentReportResults.html"));
		 	reportH.config().setDocumentTitle("Automation Report"); //Title of Report
		 	reportH.config().setReportName("Functional Report"); // Name of Report
		 	reportH.config().setTheme(Theme.STANDARD);
			
			report = new ExtentReports();
		 	report.attachReporter(reportH);
		 	report.setSystemInfo("Env", "QA");
		 	report.setSystemInfo("Tester", "Shashank");		
		 	report.setSystemInfo("Browser", "Chrome");
		 	
		 	log.info("before suite run"); 
		 	
	 }
	
	public BaseTest() 
	{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "./Resources/Application.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization()
	{
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--start-maximized");
			System.setProperty("webdriver.chrome.driver", "./Softwares/chromedriver_86.exe");	
			driver = new ChromeDriver(options); 
			
			PropertyConfigurator.configure("log4j.properties");
			
		}
		else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "./Softwares/geckodriver.exe");	
			driver = new FirefoxDriver(); 
			PropertyConfigurator.configure("log4j.properties");
			
		}
		driver.get(prop.getProperty("url"));
		log.info("browser launched , url entered"); //log4j
		
		//driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	}	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logReport.log(Status.FAIL , "Test case failed is " +result.getName()); // to add name in extent report
			logReport.log(Status.FAIL , "Test case failed is " +result.getThrowable()); // to add error/exception
			
			String temp = Helper.screenshot(driver , result.getName());
			logReport.log(Status.FAIL, ""+logReport.addScreenCaptureFromPath(temp));
	
		}
		else if (result.getStatus() == ITestResult.SKIP)
		{
			logReport.log(Status.SKIP, "Test case skipped is " +result.getName());
		}
		else if (result.getStatus() == ITestResult.SUCCESS)
		{
			logReport.log(Status.PASS, "Test case passed is " +result.getName());
		}
		
		
		report.flush();
	}
	
}
