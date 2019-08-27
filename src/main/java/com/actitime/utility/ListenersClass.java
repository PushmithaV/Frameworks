package com.actitime.utility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.actitime.base.BaseClass;
import com.aventstack.extentreports.Status;

public class ListenersClass extends BaseClass implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {	
		new Extentreportclass().extentreportload(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {	
		//System.out.println("Pass");
		Extentreportclass.extenttest.log(Status.PASS, gv.testcasename+" is pass");
		extentreports.flush();
		try {
			ExcelClass.writeResult(result.getName(), Status.PASS.toString());
		} catch (EncryptedDocumentException | IOException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {	
		//System.out.println("Fail");
		Extentreportclass.extenttest.log(Status.FAIL, gv.testcasename+" is fail");
		extentreports.flush();
		try {
			ExcelClass.writeResult(result.getName(), Status.FAIL.toString());
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {		
		Extentreportclass.extenttest.log(Status.SKIP, gv.testcasename+" is skipped");
		extentreports.flush();
		try {
			ExcelClass.writeResult(result.getName(), Status.SKIP.toString());
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
