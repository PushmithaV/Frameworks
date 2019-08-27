package com.flipkart;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generics.Generic_methods;
import com.aventstack.extentreports.Status;

@Listeners(com.actitime.utility.ListenersClass.class)
public class SearchforProduct extends Generic_methods {

	
	@Test
	public void searchforProduct()
	{
		//System.out.println(Status.PASS.toString());
		clickon("closebtn");
		setDatato("search", "Fiction books");
		clickon("searchbtn");
		Assert.fail();
	}
}
