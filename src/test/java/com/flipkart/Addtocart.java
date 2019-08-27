package com.flipkart;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generics.Generic_methods;
import com.actitime.utility.ListenersClass;
@Listeners(ListenersClass.class)
public class Addtocart extends Generic_methods {
	
	@Test
	public void addtocart()
	{
		gv.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		clickon("closebtn");
		setDatato("search", "Fiction books");
		clickon("searchbtn");
		clickon("book");
		switchtowindow(2);
		clickon("addtocart");
		
		clickon("placeorder");
		
	}

}
