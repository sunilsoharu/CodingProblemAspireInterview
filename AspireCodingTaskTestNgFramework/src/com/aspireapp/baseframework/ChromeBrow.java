package com.aspireapp.baseframework;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.aspireapp.SystemUtilities.PropertyReader;


public class ChromeBrow {

protected static PropertyReader reader;
public static  WebDriver driver;
	public static WebDriver getChromeDriver(String OSName){
		System.out.println(OSName.toLowerCase());
		if(OSName.toLowerCase().indexOf("win") >= 0){
		System.setProperty("webdriver.chrome.driver", reader.getChromeDriverPath());
		  driver = new ChromeDriver();
		
		}
		else if(OSName.toLowerCase().indexOf("mac") >=0) {
		System.out.println(OSName.toLowerCase());
			//System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("driver/chromedriver.exe"));
		 driver = new ChromeDriver();
		
		}
		if(driver==null)
		System.out.println("has null value");
		else {System.out.println(driver.toString());}
		return  driver;
		
	}
}
