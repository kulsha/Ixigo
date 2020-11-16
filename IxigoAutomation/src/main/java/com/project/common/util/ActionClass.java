package com.project.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionClass {

	public static void mouseOverUsingActions(WebDriver driver , WebElement element1 , WebElement element_2) throws InterruptedException
	{
		Actions a = new Actions(driver);
		a.moveToElement(element1).build().perform();
		Thread.sleep(2000);
		a.moveToElement(element_2).click().build().perform();
	}
	
	public static void mouseOverUsingActionsMenuBar(WebDriver driver , WebElement element1 , WebElement element_2) throws InterruptedException
	{
		Actions a = new Actions(driver);
		a.moveToElement(element1).click().build().perform();
		Thread.sleep(2000);
		a.moveToElement(element_2).click().build().perform();
	}
	
	
	public static void click(WebDriver driver , WebElement element)
	{
		element.click();
	}
	
	
	
	public static void dropdown(WebDriver driver , String fieldName , String value)
	{
		Map<String,String> data = ConstantValues.getDropdownId();
		WebElement dd  = driver.findElement(By.xpath("//*[@id='"+data.get(fieldName)+"']"));
		Select s = new Select(dd);
		s.selectByVisibleText(value);
	}
	
	public static void click(WebDriver driver , WebElement element , int timeout)
	{
		new WebDriverWait(driver , timeout).
		until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
	
}
