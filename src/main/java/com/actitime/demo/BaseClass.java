package com.actitime.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public GlobalVariables gv = new GlobalVariables();
	public String userDir = System.getProperty("user.dir");

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
	public void launchbrowser() {
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
		gv.driver.get(gv.browser.getProperty("url"));
		
	}

	@AfterMethod
	public void closeApp() {
		gv.driver.close();
	}

}
