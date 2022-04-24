package com.aspireapp.baseframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SafariBrow {
 	public static WebDriver getSafariDriver(){
 		WebDriver driver = new SafariDriver();
 		return driver;
 		
 	}
}
