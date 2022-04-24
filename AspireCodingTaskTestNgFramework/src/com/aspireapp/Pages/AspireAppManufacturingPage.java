package com.aspireapp.Pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.asserts.Assertion;

import com.aspireapp.WebPageUtilities.PageElementUtil;
import com.aspireapp.baseframework.FrameworkInitialize;

public class AspireAppManufacturingPage extends FrameworkInitialize{
	public static String OrderReferenceNumber;
	PageElementUtil pageutil = new PageElementUtil();
	
	By btn_CreateOrder= By.xpath("//button[@type='button' and @data-original-title='Create record']");
	By txt_ProductName = By.xpath("//div[@name='product_id']//input");
	By btn_Confirm = By.xpath("//button[@type='button' and @name='action_confirm']");
	By txt_QuantityField = By.xpath("//input[@class='o_field_float o_field_number o_field_widget o_quick_editable o_input text-left']");
	By btn_addline = By.xpath("(//*[@role='button'][contains(text(),'Add a line')])[1]");
	By txt_LineProductName =  By.xpath("//div[@name='product_id']//input");
	By txt_LineQty = By.xpath("//input[@name='quantity_done']");
	By btn_markasDone = By.xpath("(//button[@name='button_mark_done']/span[contains(text(),'Mark as Done')])[1]");
	By btn_saverecord = By.xpath("//button[@type='button' and @title='Save record']");
	By txt_orderReference = By.xpath("//span[@name='name' and @placeholder='Manufacturing Reference']");
	
	By btn_manufacturingHome= By.xpath("//a[contains(text(),'Manufacturing')][@class='dropdown-item o_menu_brand']");
	By img_ClearSearchfilters= By.xpath("//i[@role='img' and @title='Remove']");
	By btn_searchRecords= By.xpath("//input[@type='text' and @title='Search for records']");
	
	
	
	public void CreateManufacturingorder(String ProductName, String Quantity, String LineProductName,String LineQauntity) throws InterruptedException
	{
		pageutil.performClick(btn_CreateOrder);
		
		pageutil.setText(txt_ProductName,ProductName );
		pageutil.setText(txt_ProductName,(Keys.ENTER) );
		pageutil.performClick(btn_Confirm);
		pageutil.performClick(txt_QuantityField);
		
		
		pageutil.setText(txt_QuantityField, (Keys.BACK_SPACE));
		pageutil.setText(txt_QuantityField, (Keys.BACK_SPACE));
		pageutil.setText(txt_QuantityField, (Keys.BACK_SPACE));
		pageutil.setText(txt_QuantityField, (Keys.BACK_SPACE));
		pageutil.setText(txt_QuantityField, (Keys.BACK_SPACE));
		
		pageutil.setText(txt_QuantityField, Quantity);
		pageutil.performClick(btn_addline);
		pageutil.setText(txt_LineProductName, LineProductName);
		pageutil.setText(txt_ProductName,(Keys.ENTER) );
		pageutil.ClearField(txt_LineQty);
		pageutil.setText(txt_LineQty, LineQauntity);
		pageutil.performClick(btn_markasDone);
		OrderReferenceNumber=pageutil.getFieldText(txt_orderReference);
		pageutil.performClick(btn_saverecord);
		System.out.println("Order reference number is : "+OrderReferenceNumber);
		
		
	}
		public void ValidateOrder()
	{
	pageutil.performClick(btn_manufacturingHome);	
	pageutil.performClick(img_ClearSearchfilters);
	pageutil.performClick(btn_searchRecords);
	pageutil.setText(btn_searchRecords,OrderReferenceNumber);
	pageutil.setText(btn_searchRecords, Keys.ENTER);
	String ExpectedOrderNumber=Driver.findElement(By.xpath("//td[@title='"+OrderReferenceNumber+"']")).getText();
	System.out.println("Referenced Xpath is : "+"//td[@title='"+OrderReferenceNumber+"']");
	System.out.println("expected and actual are"+ExpectedOrderNumber+":"+OrderReferenceNumber);
	assertEquals(OrderReferenceNumber, ExpectedOrderNumber);
	
	}

}
