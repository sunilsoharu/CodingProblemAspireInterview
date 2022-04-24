package com.aspireapp.baseframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FireFoxBrow {

	public static WebDriver getFirefoxDriver() {
	DesiredCapabilities cap = DesiredCapabilities.firefox();
	FirefoxProfile profile = new FirefoxProfile();
	profile.setAcceptUntrustedCertificates(true);
	profile.setAssumeUntrustedCertificateIssuer(true);
	cap.setCapability(FirefoxDriver.PROFILE, profile);
	@SuppressWarnings("deprecation")
	FirefoxDriver driver = new FirefoxDriver(cap);
	return driver;
}
}
