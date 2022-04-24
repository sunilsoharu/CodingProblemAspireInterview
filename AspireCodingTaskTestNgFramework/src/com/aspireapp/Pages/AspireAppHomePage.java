package com.aspireapp.Pages;

import org.openqa.selenium.By;

import com.aspireapp.WebPageUtilities.PageElementUtil;
import com.aspireapp.baseframework.FrameworkInitialize;

public class AspireAppHomePage extends FrameworkInitialize{
	PageElementUtil pageutil = new PageElementUtil();
	public By icon_inventory =  By.xpath("//a[@id='result_app_1']");
	public By icon_manufacturing = By.xpath("//a[@id='result_app_2']");
	public void clickInventory()
	{
		pageutil.performClick(icon_inventory);
	}
	
	public void clickManufacturing()
	{
		pageutil.performClick(icon_manufacturing);
	}
	
}
