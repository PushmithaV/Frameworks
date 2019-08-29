package com.flipkart;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generics.Generic_methods;
import com.actitime.utility.ListenersClass;
@Listeners(ListenersClass.class)
public class Addtocart extends Generic_methods {
	
	@Test
	public void addtocart() throws IOException
	{
		gv.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		clickon("closebtn");
		screenshotofScreen(gettheTitle());
		setDatato("search", "Fiction books");
		clickon("searchbtn");
		clickon("book");		
		switchtowindow(2);
		clickon("addtocart");		
		screenshotof("placeorder");
		clickon("placeorder");
		
		
		
	}

}
