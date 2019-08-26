package utility;

import com.actitime.demo.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Extentreportclass extends BaseClass{
	public void extentreportload()
	{
	gv.extentreports= new ExtentReports();
	gv.extenttest=gv.extentreports.createTest("Reports");
	gv.extenthtmlreporter=new ExtentHtmlReporter(gv.extentreportprop.getProperty("path"));
	gv.extentreports.attachReporter(gv.extenthtmlreporter);
	}
}
