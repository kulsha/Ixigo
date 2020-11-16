package com.project.common.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DatePicker {
	
	

	public static void selectDateByJS(WebDriver driver ,WebElement element , String dateval) throws InterruptedException
	{
			JavascriptExecutor js = ((JavascriptExecutor)driver); 
			//js.executeScript("arguments[0].setAttribute('value' , '"+dateval+"');", element);
			//arguments[0].removeAttribute('readonly','readonly')
			js.executeScript("arguments[0].removeAttribute('readonly','readonly')",element);
			element.clear();
			Thread.sleep(2000);
			element.sendKeys(dateval);
			element.sendKeys(Keys.TAB);
	}
	

}
