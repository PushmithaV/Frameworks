package com.actitime.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.actitime.base.BaseClass;
import com.aventstack.extentreports.Status;

public class ListenersClass extends BaseClass implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {		
		gv.extenttest.log(Status.PASS, gv.testcasename+" is pass");
		gv.reports.extentflush();
	}

	@Override
	public void onTestFailure(ITestResult result) {	
		gv.extenttest.log(Status.FAIL, gv.testcasename+" is fail");
		gv.reports.extentflush();
	}

	@Override
	public void onTestSkipped(ITestResult result) {		
		gv.extenttest.log(Status.SKIP, gv.testcasename+" is skipped");
		gv.reports.extentflush();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		
	}

}
