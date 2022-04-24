package com.aspireapp.SystemUtilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader{
	String var_propertyFilePath;
	Properties properties;
	
	public PropertyReader() {
		this("./configuration/project.properties");
	}
	public PropertyReader(String PropertyFilepath){

		this.var_propertyFilePath=PropertyFilepath;



		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(var_propertyFilePath));
			LogsUtil.info("Propert file found at the location :"+ new FileReader(var_propertyFilePath).toString());
			properties = new Properties();
			try {
				properties.load(reader);
				LogsUtil.info("Property file loaded into the system ");
				System.out.println(getBrowserType());
				reader.close();
				LogsUtil.info("Property File Reader object is closed");
			} catch (IOException e) {
				LogsUtil.error("Property file IO exception has occured , either file is not accessible or have permission issues");
				e.printStackTrace();

			}}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			LogsUtil.error("Property file is not found at the specified location : "+var_propertyFilePath);
			throw new RuntimeException("Configuration.properties not found at " + var_propertyFilePath);

		}}	

	public String getBrowserType()
	{
		return properties.getProperty("BrowserType")	;
	}
	public String getUserName() {
		return properties.getProperty("URL_Username");
	}

	public String getProjectName() {
		return properties.getProperty("Projectname");
	}

	public String getPassword() {
		return properties.getProperty("URL_Password");
	}

	public String getWebsite() {
		return properties.getProperty("TestURL");
	}


	public int getPageLoadTimeOut() {
		return Integer.parseInt(properties.getProperty("PageLoadTimeout"));
	}

	public int getImplicitWait() {
		return Integer.parseInt(properties.getProperty("ImplicitWait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(properties.getProperty("ExplicitWait"));
	}

	public String getChromeDriverPath() {
		// TODO Auto-generated method stub
		return properties.getProperty("ChromeDriverPath");
	}

	public String getSafariDriverPath() {
		// TODO Auto-generated method stub
		return properties.getProperty("ChromeDriverPath");
	}


}
