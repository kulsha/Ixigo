package com.ixigo.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener {
	
	
	public void onFinish(ITestContext result) {					
        System.out.println("Test finish "); 			
        		
    }		

    public void onStart(ITestContext arg0) {					
        System.out.println("Starting execution ");
    }		

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    public void onTestFailure(ITestResult result) {					
       System.out.println("Test case failed " +result.getName());				
        		
    }		

    public void onTestSkipped(ITestResult result) {					
        System.out.println("Test case skipped " +result.getName());				
        		
    }		

    public void onTestStart(ITestResult result) {					
        System.out.println("Test case start " +result.getName());				
        		
    }		

    	
    public void onTestSuccess(ITestResult result) {					
        System.out.println("Test success "+result.getName());		
        		
    }
	
}
