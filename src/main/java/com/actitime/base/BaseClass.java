package com.actitime.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.actitime.utility.Extentreportclass;
import com.aventstack.extentreports.ExtentReports;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public GlobalVariables gv = new GlobalVariables();
	public String userDir = System.getProperty("user.dir");
	//public Extentreportclass report= new Extentreportclass();
	
	
	
	public void initProperty() throws FileNotFoundException, IOException {
		System.out.println(userDir);
		gv.object = new Properties();
		gv.object.load(new FileInputStream(userDir + "\\src\\main\\resources\\object.properties"));
		gv.browser = new Properties();
		gv.browser.load(new FileInputStream(userDir + "\\src\\main\\resources\\browser.properties"));
		gv.excelprop = new Properties();
		gv.excelprop.load(new FileInputStream(userDir + "\\src\\main\\resources\\excel.properties"));
		gv.extentreportprop = new Properties();
		gv.extentreportprop.load(new FileInputStream(userDir + "\\src\\main\\resources\\extent.properties"));
	
	}

	@BeforeSuite
	public void init() throws FileNotFoundException, IOException {
		initProperty();
	}

	@BeforeMethod
	public void beformethod(ITestResult result) {
		String browsertype = gv.browser.getProperty("browser");
		if (browsertype.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			gv.driver = new ChromeDriver();
			gv.driver.manage().window().maximize();

		} else if (browsertype.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			gv.driver = new FirefoxDriver();
			gv.driver.manage().window().maximize();
		}
		
		enterurl();
		gv.reports= new Extentreportclass();
		gv.testcasename=result.getClass().getSimpleName();
		gv.reports.extentreportload(gv.testcasename);
	}

	public void enterurl() {
		gv.driver.get(gv.browser.getProperty("url"));
		
	}

	@AfterMethod
	public void closeApp() {
		
		gv.driver.close();
	}

}