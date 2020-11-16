package com.ixigo.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.project.common.util.ActionClass;
import com.project.common.util.BaseTest;
import com.project.common.util.ConstantValues;
import com.project.common.util.DatePicker;
import com.project.common.util.Helper;
import com.project.common.util.ReadExcel_Fillo;

public class ixigoHome extends BaseTest {

	WebDriverWait wait = new WebDriverWait(driver, 10);
	JavascriptExecutor je = (JavascriptExecutor) driver;
	
	//Page Factory - OR
	
		@FindBy(xpath = "//div[text()='From']/following-sibling::input")
		WebElement from;
	
		@FindBy(xpath = "//div[text()='To']/following-sibling::input")
		WebElement to;
		
		@FindBy(xpath = "//div[text()='Departure']/following-sibling::input")
		WebElement departure;
		
		@FindBy(xpath = "//div[text()='Return']/following-sibling::input")
		WebElement Return;
		
		@FindBy(xpath = "//button[text() = 'Search']")
		WebElement search;
		
		@FindBy(xpath = "//span[text() = '2']")
		WebElement NoOfTravellers;
		
		@FindBy(xpath = "//div[text() = 'Non stop']/../preceding-sibling::span")
		WebElement nonStop;
		
		@FindBy(xpath = "//a[@class='flight-name']/div")
		WebElement puneToHyd;
		
		@FindBy(xpath = "//a[@class='flight-name']/div")
		List<WebElement> puneToHydList;
		
		@FindBy(xpath = "//div[@class='price']/div/span/following-sibling::span")
		List<WebElement> puneToHydPrice ;
		
		@FindBy(xpath = "//a[@class='flight-name']/following-sibling::div")
		List<WebElement> flightNo ;
		
		@FindBy(xpath = "//div[@class='left-wing']/div[@class='time']")
		List<WebElement> departTime ;
		
		
		Map<String,String> data1=ReadExcel_Fillo.getExcelRowData(ConstantValues.filePath, ConstantValues.sheetName_HomePage, "1");
		
		public ixigoHome()
		{
			PageFactory.initElements(driver, this);
		}
		
		public void ixigoNonstop() throws InterruptedException	
		{
			
			//log.info("menu icon clicked"); //log4j
			//logReport.info("menu icon clicked"); //extent report
			
			from.click();
			from.sendKeys("Pune");
			Thread.sleep(3000);
			from.sendKeys(Keys.ENTER);
			from.sendKeys(Keys.TAB);
			
			 
			 to.sendKeys("Hyderabad");
			 Thread.sleep(3000);
			 to.sendKeys(Keys.ENTER);
			 to.sendKeys(Keys.TAB);
			 
			/*
			  Thread.sleep(3000);
			 String departDate = "17 Dec, Thu";
			 DatePicker.selectDateByJS(driver, departure, departDate);
			 String returnDate = "31 Dec, Thu";
			 DatePicker.selectDateByJS(driver, Return, returnDate);
			 */
			 
			 Thread.sleep(2000);
			 search.click();
			 Thread.sleep(4000);
			 
			 String departDate = "17 Dec, Thu";
    		 DatePicker.selectDateByJS(driver, departure, departDate);
			 Thread.sleep(2000);
			 String returnDate1 = "31 Dec, Thu";
			 DatePicker.selectDateByJS(driver, Return, returnDate1);
			 Thread.sleep(2000);
			 NoOfTravellers.click();
			 Thread.sleep(2000);
			 search.click();
			 Thread.sleep(7000);
			 
			 /* nonStop.click();
			    Thread.sleep(6000);
			 */
			 
			 System.out.println("Pune to Hyd Airplanes , Price and Departure Time ");
			 System.out.println();
			 int a = puneToHydList.size();
			 for(int i=0 ; i<a ; i++)
			 {
				 String puneHydAirText = puneToHydList.get(i).getText();
				 String puneHydPriceList = puneToHydPrice.get(i).getText();
				 String flightNum = flightNo.get(i).getText();
				 String departureTime = departTime.get(i).getText();
				 if(Integer.parseInt(puneHydPriceList.trim()) < 6000)
				 {
					 System.out.println("Flight name and number - "+puneHydAirText + " " +flightNum );
					 System.out.println("Departure Time - "+departureTime);
					 System.out.println("Ticket Price = Rupees "+puneHydPriceList+"/-");
					 System.out.println();
				 }
			 }
			

			
		}
	
	
		
}
