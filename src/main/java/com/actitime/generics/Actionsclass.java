package com.actitime.generics;

import org.openqa.selenium.interactions.Actions;

import com.actitime.base.BaseClass;

public class Actionsclass extends BaseClass{

	Generic_methods gm=new Generic_methods();
	
	public void movetoelement(String element)
	{
		gv.action=new Actions(gv.driver);
		gv.action.moveToElement(gm.findwebelement(element));
	}
	
	public void draganddropon(String source, String dest)
	{
		gv.action=new Actions(gv.driver);
		gv.action.dragAndDrop(gm.findwebelement(source),gm.findwebelement(dest));
	}
	
	public void doubleclickon(String element)
	{
		gv.action=new Actions(gv.driver);
		gv.action.doubleClick(gm.findwebelement(element));
	}
	
	public void rightclick(String element)
	{
		gv.action=new Actions(gv.driver);
		gv.action.contextClick(gm.findwebelement(element));
	}
}
