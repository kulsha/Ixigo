package com.project.common.util;

import java.util.HashMap;
import java.util.Map;

public class ConstantValues {
	
	public static final String filePath = "./Resources/TestData/TestData.xlsx";
	public static final String sheetName="login";	
	public static final String sheetName_HomePage="homePage";
	public static final String sheetName_BrowserHistoryPage="BrowserHistory";

	public static Map<String , String> getDropdownId()
	{
		Map<String,String> data = new HashMap<String, String>();
		data.put("All", "searchDropdownBox");
		
		return data;
		
	}
	
	
}
