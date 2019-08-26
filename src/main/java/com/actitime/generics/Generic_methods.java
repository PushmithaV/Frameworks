package com.actitime.generics;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.actitime.base.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Generic_methods extends BaseClass{	
		
	public void setDatato(String element,String value)
	{		
		findwebelement(element).sendKeys(value);
	}
	
	public void clickon(String element)
	{
		findwebelement(element).click();
	}
	
	public void submitthe(String element)
	{
		findwebelement(element).submit();
	}
	
	public void toClear(String element)
	{
		findwebelement(element).clear();
	}
	
	public String fetchTagname(String element)
	{
		return findwebelement(element).getTagName();
		
	}
	
	public String fetchAttribute(String element,String nameofattribute)
	{
		return findwebelement(element).getAttribute(nameofattribute);
		
	}
	
	public boolean selected(String element)
	{
		 return findwebelement(element).isSelected();
		
	}
	
	public boolean enabled(String element)
	{
		 return findwebelement(element).isEnabled();
		
	}
	
	public boolean displayed(String element)
	{
		 return findwebelement(element).isDisplayed();
		
	}
	
	public String gettheText(String element)
	{
		return findwebelement(element).getText();
		
	}
	
	public String gettheTitle()
	{
		return gv.driver.getTitle();
		
	}
	
	public String getCss(String element,String attributename)
	{
		return findwebelement(element).getCssValue(attributename);
	
	}
	
	public void maxbrowser()
	{
		gv.driver.manage().window().maximize();
	}
		
	public WebElement findwebelement(String element)
	{
		String s = gv.object.getProperty(element);
		String[] locator = s.split("-");
		//System.out.println(Arrays.toString(locator));
	switch(locator[0])
	{
	case "id": gv.by=By.id(locator[1]);
	break;

	case "name": gv.by=By.name(locator[1]);
	break;
	
	case "classname": gv.by=By.className(locator[1]);
	break;

	case "partiallinktext": gv.by=By.partialLinkText(locator[1]);
	break;

	case "linktext": gv.by=By.linkText(locator[1]);
	break;

	case "tagname": gv.by=By.tagName(locator[1]);
	break;

	case "cssselector": gv.by=By.cssSelector(locator[1]);
	break;

	case "xpath": gv.by=By.xpath(locator[1]);
	break;

	default: System.out.println("Enter valid locator");
	break;
	}

	return gv.driver.findElement(gv.by);
			
	}

	public  List<WebElement> findwebelements(String element)
	{
		String[] locator = gv.object.getProperty(element).split("-");
	
	switch(locator[0])
	{
	case "id": gv.by=By.id(locator[1]);
	break;

	case "name": gv.by=By.name(locator[1]);
	break;
	case "classname": gv.by=By.className(locator[1]);
	break;

	case "partiallinktext": gv.by=By.partialLinkText(locator[1]);
	break;

	case "linktext": gv.by=By.linkText(locator[1]);
	break;

	case "tagname": gv.by=By.tagName(locator[1]);
	break;

	case "cssselector": gv.by=By.cssSelector(locator[1]);
	break;

	case "xpath": gv.by=By.xpath(locator[1]);
	break;

	default: System.out.println("Enter valid locator");
	break;
	}

	 List<WebElement> elements = gv.driver.findElements(gv.by);
	return elements;
		
	}
	
	public List<WebElement> getOptionsof(String element)
	{
		gv.select=new Select(findwebelement(element));
		return gv.select.getOptions();
	}
	
	public List<WebElement> getSelectedOptions(String element)
	{
		gv.select=new Select(findwebelement(element));
		return gv.select.getAllSelectedOptions();
	}
	
	public WebElement firstSelectedOption(String element)
	{
		gv.select=new Select(findwebelement(element));
		return gv.select.getFirstSelectedOption();
	}
	
	public void selectmultiplevalues(String element, String... values)
	{
		gv.select=new Select(findwebelement(element));
	
		if(gv.select.isMultiple())
		{
			for(int i=0; i<values.length ; i++)
			{
				gv.select.selectByVisibleText(values[i]);
			}
		}else
		{
			
			Reporter.log("Not a multiple list", true);
		}
	}
	
	public void selectmultipleindex(String element, int... values)
	{
		gv.select=new Select(findwebelement(element));
		
		if(gv.select.isMultiple())
		{
			for(int i=0; i<values.length ; i++)
			{
				gv.select.selectByIndex(values[i]);
			}
		}else
		{			
			Reporter.log("Not a multiple list", true);
		}
		
	}
	
	public void selectbytext(String element, String text)
	{
		gv.select=new Select(findwebelement(element));
		gv.select.selectByVisibleText(text);
	}
	
	public void selectonindex(String element, int index)
	{
		gv.select=new Select(findwebelement(element));
		gv.select.selectByIndex(index);		
	}
	
	public void selectonvalue(String element, String value)
	{
		gv.select=new Select(findwebelement(element));
		gv.select.selectByValue(value);	
	}
	
	public void deselectALL(String element)
	{
		gv.select=new Select(findwebelement(element));
		gv.select.deselectAll();
	}
	
	public void deselectmultipletext(String element,String... text)
	{
		gv.select=new Select(findwebelement(element));
		if(gv.select.isMultiple())
		{
			for(int i=0; i<text.length ; i++)
			{
				gv.select.deselectByVisibleText(text[i]);
			}
		}else
		{			
			Reporter.log("Not a multiple list", true);
		}
	}

	public void deselectmultipleindex(String element, int... values)
	{
		gv.select=new Select(findwebelement(element));
		
		if(gv.select.isMultiple())
		{
			for(int i=0; i<values.length ; i++)
			{
				gv.select.deselectByIndex(values[i]);
			}
		}else
		{			
			Reporter.log("Not a multiple list", true);
		}
		
	}
	
	public void deselectbytext(String element, String text)
	{
		gv.select=new Select(findwebelement(element));
		gv.select.deselectByVisibleText(text);
	}
	
	public void deselectonindex(String element, int index)
	{
		gv.select=new Select(findwebelement(element));
		gv.select.deselectByIndex(index);		
	}
	
	public void deselectonvalue(String element, String value)
	{
		gv.select=new Select(findwebelement(element));
		gv.select.deselectByValue(value);	
	}
	
	
}
