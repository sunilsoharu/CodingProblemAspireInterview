package com.aspireapp.baseframework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.NewSessionPayload;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.aspireapp.Pages.AspireAppLoginPage;
import com.aspireapp.SystemUtilities.LogsUtil;
import com.aspireapp.SystemUtilities.PropertyReader;



public class FrameworkInitialize {
protected static String var_OSName;
		protected static PropertyReader reader = null;
		protected static WebDriver Driver = null;
		protected static final Logger log = LogsUtil.getLogger(FrameworkInitialize.class);
		
		public FrameworkInitialize() {
			reader = new PropertyReader();
			var_OSName=System.getProperty("os.name");
			System.out.println("OS name is : "+var_OSName);
		}		

		public FrameworkInitialize(String fileName) {
			reader = new PropertyReader("./configuration/project.properties");
			PageFactory.initElements(Driver, this);
		}

		
		
		public static WebDriver getDefaultDriver() {
			LogsUtil.debug("Driver Object");
			return Driver;
		}
		
		public static PropertyReader getReader(){
			LogsUtil.debug("Reader Object");
			return reader;
		}
		

		@AfterTest(enabled = true)
		public  void tearDown() {
			
			if(Driver != null){
				Driver.quit();
				Driver = null;
				LogsUtil.info("Shutting down the Driver");
			}	}	

		@DataProvider(name = "excelData")
	    public Object[][] excelDataProvider() throws IOException {
	        // We are creating an object from the excel sheet data by calling a method that
	        // reads data from the excel stored locally in our system
	        Object[][] arrObj = getExcelData("./resources/TestData.xlsx","Sheet1");
	        System.out.println("Excel found");
	        return arrObj;
	    }
		
		public String[][] getExcelData(String fileName,  String sheetName) throws IOException {
	        String[][] data = null;
	        try {
	             
	            FileInputStream fis = new FileInputStream(fileName);
	            XSSFWorkbook workbook = new XSSFWorkbook(fis);
	            XSSFSheet sheet = workbook.getSheet(sheetName);
	            XSSFRow row = sheet.getRow(0);
	            int noOfRows = sheet.getPhysicalNumberOfRows();
	            int noOfCols = row.getLastCellNum();
	            System.out.println("Row and Columns : "+noOfRows+" --"+noOfCols);
	            Cell cell;
	            data = new String[noOfRows - 1][noOfCols];
	 
	            for (int i = 1; i < noOfRows; i++) {
	                for (int j = 0; j < noOfCols; j++) {
	                    row = sheet.getRow(i);
	                    cell = row.getCell(j);
	                    CellType type = cell.getCellType();
	                    if (type == CellType.STRING) {
	                    data[i - 1][j] = cell.getStringCellValue();
	                    System.out.println(cell.getStringCellValue());}
	                    else if (type == CellType.NUMERIC)
	                    {
	                    	data[i - 1][j] = Integer.toString((int)cell.getNumericCellValue());
	                    	System.out.println(Integer.toString((int)cell.getNumericCellValue()));
	                    }
	                }
	            }
	        } catch (Exception e) {
	            System.out.println("The exception is: " + e.getMessage());
	        }
	        return data;
	    }
}
