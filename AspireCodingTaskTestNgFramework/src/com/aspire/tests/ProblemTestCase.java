package com.aspire.tests;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aspireapp.Pages.AspireAppHomePage;
import com.aspireapp.Pages.AspireAppInventoryPage;
import com.aspireapp.Pages.AspireAppLoginPage;
import com.aspireapp.Pages.AspireAppManufacturingPage;
import com.aspireapp.SystemUtilities.LogsUtil;
import com.aspireapp.WebPageUtilities.PageElementUtil;
import com.aspireapp.baseframework.ChromeBrow;
import com.aspireapp.baseframework.FireFoxBrow;
import com.aspireapp.baseframework.FrameworkInitialize;
import com.aspireapp.baseframework.NoCorrectDriverFoundException;
import com.aspireapp.baseframework.SafariBrow;


public class ProblemTestCase extends FrameworkInitialize{
	AspireAppLoginPage login = new AspireAppLoginPage();	
	AspireAppHomePage home = new AspireAppHomePage();
	AspireAppInventoryPage inventory = new AspireAppInventoryPage();
	AspireAppManufacturingPage manufacturing = new AspireAppManufacturingPage();
	
	@BeforeTest
	public  void kickStartProject() throws InterruptedException {
		String BrowserName = reader.getBrowserType();
		LogsUtil.info("Browser Type : " + BrowserName.toLowerCase());
		System.out.println("Lower case "+BrowserName.toLowerCase());
		switch (BrowserName.toLowerCase()) {

		case "firefox":
			Driver = FireFoxBrow.getFirefoxDriver();
			break;

		case "chrome":
			Driver = ChromeBrow.getChromeDriver(var_OSName);
			System.out.println("Entered this loop");
			break;

		case "safari":
			Driver = SafariBrow.getSafariDriver();
			break;
		default:
			throw new NoCorrectDriverFoundException(" Driver Not Found : " + reader.getBrowserType());
		}
		
		Driver.get(reader.getWebsite());
		Driver.manage().timeouts().pageLoadTimeout(reader.getPageLoadTimeOut(), TimeUnit.SECONDS);
		Driver.manage().timeouts().implicitlyWait(reader.getImplicitWait(), TimeUnit.SECONDS);
		Driver.manage().window().maximize();
		login.Login(reader.getUserName(),reader.getPassword());}
	
	@AfterMethod
	
	public void thishasToruntoresetwebSiteStatus()
	{
		inventory.gobacktoHomeMenu();
		
	}
	
	@Test(dataProvider = "excelData", dataProviderClass = FrameworkInitialize.class)
	public void RunEndtoEndTestCase(String ProductName, String Quantity, String LineProductName, String LineQuantity) throws InterruptedException
	
	{
		
		home.clickInventory();
		inventory.createNewProduct(ProductName, Quantity);
		inventory.gobacktoHomeMenu();
		home.clickManufacturing();
		
		
		manufacturing.CreateManufacturingorder( ProductName,  Quantity,  LineProductName, LineQuantity);
		manufacturing.ValidateOrder();
		Thread.sleep(10000);
	}

}
