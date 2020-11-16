package com.project.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ReadExcel_Fillo {
public static Fillo fillo;
public static Connection connection;
public static Recordset recordset;

public static String getExcelData(String filepath, String sheetName, String RowNum , String ColName)
	{
	String sValue=null;
	try
	{
	fillo=new Fillo();	
	connection=fillo.getConnection(filepath);
	String strQuery="Select * from "+sheetName+" where TestCaseId="+RowNum;
	recordset=connection.executeQuery(strQuery);
	 
	while(recordset.next()){
		sValue=recordset.getField(ColName);
	}
	 
	recordset.close();
	connection.close();
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	return sValue;
	
	}

public static Map<String,String> getExcelRowData(String filepath, String sheetName, String RowNum)
{
Map<String,String> data=new HashMap<String, String>();
List<String> colNames=new ArrayList<String>();
try
{
fillo=new Fillo();	
connection=fillo.getConnection(filepath);
String strQuery="Select * from "+sheetName+" where TestCaseId="+RowNum;
recordset=connection.executeQuery(strQuery);
colNames=recordset.getFieldNames(); 
	
	while(recordset.next()){
		for (String col : colNames) {
			
		data.put(col, recordset.getField(col));
		}
	}


 
recordset.close();
connection.close();
}
catch(Exception e)
{
	System.out.println(e.getMessage());
}
return data;

}
	
}
