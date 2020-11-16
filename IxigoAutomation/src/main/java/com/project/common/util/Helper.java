package com.project.common.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Helper extends BaseTest{


	
	
	
	public static String screenshot(WebDriver driver , String screenshotName) throws IOException
	{
		String dateName = new SimpleDateFormat("yyyyMMDDhhmmss").format(new Date());
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"./Screenshots/"+screenshotName+ dateName +".jpg";
		
		File destination = new File(path);
		
		try
		{
			FileUtils.copyFile(src, destination);
		}
		catch (IOException e)
		{
			System.out.println("Screenshot capture failure " +e.getMessage());
		}
		
		return path;
	}	
	
	
	
	
	
	
	
}
