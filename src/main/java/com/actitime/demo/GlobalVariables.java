package com.actitime.demo;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class GlobalVariables {
public WebDriver driver;
public Properties object;
public Properties browser;
public Select select;
public By by;
public Actions action;
public JavascriptExecutor jexecuter;
public FileInputStream file;
public Properties excelprop;
public Workbook wbook;
public ExtentReports extentreports;
public ExtentTest extenttest;
public ExtentHtmlReporter  extenthtmlreporter;
public Properties extentreportprop;
public Sheet sheet;
}
