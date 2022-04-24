package com.aspireapp.WebPageUtilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aspireapp.SystemUtilities.LogsUtil;
import com.aspireapp.baseframework.FrameworkInitialize;

public class PageElementUtil extends FrameworkInitialize{
	PageWaitUtil waitutil = new PageWaitUtil();
	public void setText(By locator ,String text)
	{
		try
		{waitutil.waitForElementClickable(locator, 1000, 1, TimeUnit.MILLISECONDS, null);
			Driver.findElement(locator).sendKeys(text);
			Thread.sleep(1500);
		LogsUtil.info(text+": Entered into Field "+locator.toString());
		}
		catch(Exception e)
		{
			LogsUtil.error(e.getMessage());
				
		}
			
	}	
	public void setText(By locator ,Keys text)
	{
		try
		{waitutil.waitForElementVisible(locator, 1000, 1, TimeUnit.MILLISECONDS, null);
			Driver.findElement(locator).sendKeys(text);
			Thread.sleep(1500);
		LogsUtil.info(text+": Entered into Field "+locator.toString());
		}
		catch(Exception e)
		{
			LogsUtil.error(e.getMessage());
				
		}
			
	}	
	
public void performClick(By locator)
{	try
{Thread.sleep(1500);
	Driver.findElement(locator).click();;

LogsUtil.info("Clicked locator is : "+locator.toString());
}
catch(Exception e)
{
	LogsUtil.error(e.getLocalizedMessage());
}}

public void ClearField(By locator)
{	try

{Thread.sleep(1500);
	Driver.findElement(locator).clear();

LogsUtil.info("Field is cleared at  locator : "+locator.toString());
}
catch(Exception e)
{
	LogsUtil.error(e.getLocalizedMessage());
}}

public String getFieldText(By locator)
{String text="";
	try
{Thread.sleep(1500);
		text=Driver.findElement(locator).getText();

LogsUtil.info(text+": is text captured at the specified  locator : "+locator.toString());
}
catch(Exception e)
{
	LogsUtil.error(e.getLocalizedMessage());
}
return text;}
}
