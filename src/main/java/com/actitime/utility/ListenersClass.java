package com.actitime.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.actitime.base.BaseClass;
import com.aventstack.extentreports.Status;

public class ListenersClass extends BaseClass implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {	
		new Extentreportclass().extentreportload(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {	
		System.out.println("Pass");
		Extentreportclass.extenttest.log(Status.PASS, gv.testcasename+" is pass");
		extentreports.flush();
	}

	@Override
	public void onTestFailure(ITestResult result) {	
		System.out.println("Fail");
		Extentreportclass.extenttest.log(Status.FAIL, gv.testcasename+" is fail");
		extentreports.flush();
	}

	@Override
	public void onTestSkipped(ITestResult result) {		
		Extentreportclass.extenttest.log(Status.SKIP, gv.testcasename+" is skipped");
		extentreports.flush();
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
