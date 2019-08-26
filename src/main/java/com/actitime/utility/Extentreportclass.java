package com.actitime.utility;


import com.actitime.base.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Extentreportclass extends BaseClass{
	public void extentreportload(String testname)
	{
	gv.extentreports= new ExtentReports();
	gv.extenttest=gv.extentreports.createTest(testname);
	gv.extenthtmlreporter=new ExtentHtmlReporter(userDir+"\\src\\test\\resources\\"+testname+".html");
	gv.extentreports.attachReporter(gv.extenthtmlreporter);
	}
	
	public void extentflush()
	{
		gv.extentreports.flush();
	}
}
