package com.actitime.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public GlobalVariables gv = new GlobalVariables();
	public static String userDir = System.getProperty("user.dir");
	
	public static ExtentReports extentreports;
	public static ExtentTest extenttest;
	public static ExtentHtmlReporter  extenthtmlreporter;
	
	public static Properties excelprop;
	public static Workbook wbook;
	public static Sheet sheet;
	public static FileInputStream file;
	
	
	public void initProperty() throws FileNotFoundException, IOException {
		System.out.println(userDir);
		gv.object = new Properties();
		gv.object.load(new FileInputStream(userDir + "\\src\\main\\resources\\object.properties"));
		gv.browser = new Properties();
		gv.browser.load(new FileInputStream(userDir + "\\src\\main\\resources\\browser.properties"));
		excelprop = new Properties();
		excelprop.load(new FileInputStream(userDir + "\\src\\main\\resources\\excel.properties"));
		gv.extentreportprop = new Properties();
		gv.extentreportprop.load(new FileInputStream(userDir + "\\src\\main\\resources\\extent.properties"));
		gv.flipkartprop = new Properties();
		gv.flipkartprop.load(new FileInputStream(userDir + "\\src\\main\\resources\\flipkart.properties"));
	
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
		
	}

	public void enterurl() {
		gv.driver.get(gv.browser.getProperty("flipkarturl"));
		
	}

	@AfterMethod
	public void closeApp() {
		
		gv.driver.close();
	}

}
