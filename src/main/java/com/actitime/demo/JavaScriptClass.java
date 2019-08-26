package com.actitime.demo;

import org.openqa.selenium.JavascriptExecutor;

public class JavaScriptClass extends BaseClass {

	Generic_methods gm=new Generic_methods();
	
	public void scrolltoelement(String element)
	{
	gv.jexecuter=(JavascriptExecutor)gv.driver;
	gv.jexecuter.executeScript("arguments[0].scrollIntoView();", gm.findwebelement(element));
	}
	
	public void scrolltocoordinates(String x, String y)
	{
		gv.jexecuter=(JavascriptExecutor)gv.driver;
		gv.jexecuter.executeScript("window.scrollBy("+gv.object.getProperty(x)+","+gv.object.getProperty(y)+")");
	}
	
}
