package com.actitime.utility;


import com.actitime.base.BaseClass;
import com.actitime.base.GlobalVariables;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Extentreportclass extends BaseClass{
	//public static Object extenttest;

	public  void extentreportload(String testname)
	{
		extenthtmlreporter=new ExtentHtmlReporter(userDir+"\\src\\test\\resources\\"+testname+".html");
	extentreports= new ExtentReports();
	extenttest=extentreports.createTest(testname);	
	extentreports.attachReporter(extenthtmlreporter);
	}
	
	
}
