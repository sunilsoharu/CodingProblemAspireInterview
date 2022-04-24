package com.aspireapp.WebPageUtilities;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aspireapp.SystemUtilities.LogsUtil;
import com.aspireapp.baseframework.FrameworkInitialize;
import com.google.common.base.Function;


public class PageWaitUtil extends FrameworkInitialize{

public static final Logger log = LogsUtil.getLogger(PageWaitUtil.class);
	
	private static WebDriverWait getWait(int timeOutInSeconds,int pollingEveryInMiliSec,TimeUnit unit,Class...exceptiontoIgnore ) {
		WebDriver driver = FrameworkInitialize.getDefaultDriver();
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(pollingEveryInMiliSec, unit);
		if(exceptiontoIgnore != null){
			for (Class exp : exceptiontoIgnore) {
				wait.ignoring(exp);
			}
		}
		log.debug("Getting the Wait Object");
		return wait;
	}
	
	
	public static void setImplicitWait(long timeout,TimeUnit unit) {
		WebDriver driver = FrameworkInitialize.getDefaultDriver();
		driver
		.manage()
		.timeouts()
		.implicitlyWait(timeout, unit == null ? TimeUnit.SECONDS : unit);
		log.debug("Timeout :" + timeout);
	}
	
	public static void waitForElement(By locator,int timeOutInSeconds,int pollingEveryInMiliSec,TimeUnit unit,Class...exceptiontoIgnore ) {
		setImplicitWait(1, TimeUnit.SECONDS);
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec, unit, exceptiontoIgnore);
		log.info(locator);
		wait.until(ExpectedConditions.visibilityOf(Driver.findElement(locator)));
		setImplicitWait(FrameworkInitialize.getReader().getImplicitWait(), TimeUnit.SECONDS);
	}
	

	public static void hardWait(int timeOutInMiliSec) throws InterruptedException {
		log.debug("Sleep : " + timeOutInMiliSec);
		Thread.sleep(timeOutInMiliSec);
	}
	
	public static void waitForElementVisible(By locator,int timeOutInSeconds,int pollingEveryInMiliSec,TimeUnit unit,Class...exceptiontoIgnore ) {
		setImplicitWait(1, TimeUnit.SECONDS);
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec, unit, exceptiontoIgnore);
		log.info(locator);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		setImplicitWait(FrameworkInitialize.getReader().getImplicitWait(), TimeUnit.SECONDS);
	}
	
	public static void waitForElementClickable(By locator,int timeOutInSeconds,int pollingEveryInMiliSec,TimeUnit unit,Class...exceptiontoIgnore ) {
		setImplicitWait(1, TimeUnit.SECONDS);
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec, unit, exceptiontoIgnore);
		log.info(locator);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		setImplicitWait(FrameworkInitialize.getReader().getImplicitWait(), TimeUnit.SECONDS);
	}
	
	public static WebElement handleStaleElement(By locator,int retryCount,int delayInSeconds) throws InterruptedException {
		
		WebDriver driver = FrameworkInitialize.getDefaultDriver();
		WebElement element = null;
		
		while (retryCount >= 0) {
			try {
				element = driver.findElement(locator);
				log.info(element);
				return element;
			} catch (StaleElementReferenceException e) {
				log.info("Recovering the Element : " + locator + " Retry : " + retryCount);
				hardWait(delayInSeconds);
				retryCount--;
			}
		}
		throw new StaleElementReferenceException("Element cannot be recovered");
	}
	
	public static void elementExits(By locator,int timeOutInSeconds,int pollingEveryInMiliSec,TimeUnit unit) {
		setImplicitWait(1, TimeUnit.SECONDS);
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec, unit, NoSuchElementException.class,
				InvalidElementStateException.class);
		log.info(locator);
		wait.until(elementLocatedBy(locator));
		setImplicitWait(FrameworkInitialize.getReader().getImplicitWait(), TimeUnit.SECONDS);
	}
	
	public static void elementExistAndVisible(By locator,int timeOutInSeconds,int pollingEveryInMiliSec,TimeUnit unit) {
		setImplicitWait(1, TimeUnit.SECONDS);
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec, unit, NoSuchElementException.class,
				InvalidElementStateException.class);
		log.info(locator);
		wait.until(elementLocatedBy(locator));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		setImplicitWait(FrameworkInitialize.getReader().getImplicitWait(), TimeUnit.SECONDS);
		
	}
	
	private static Function<WebDriver, Boolean> elementLocatedBy(final By locator){
		return new Function<WebDriver, Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
				log.debug("Waiting for Element :" + locator);
				return driver.findElements(locator).size() >= 1;
			}
		};
	}
	
}
