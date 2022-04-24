package com.aspireapp.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.aspireapp.WebPageUtilities.PageElementUtil;
import com.aspireapp.baseframework.FrameworkInitialize;

public class AspireAppInventoryPage extends FrameworkInitialize{
	PageElementUtil pageutil = new PageElementUtil(); 

	
	By btn_ParentProducts= By.xpath("//*[@class='dropdown-toggle  ' and @title='Products']");
	By btn_drpdwnProducts= By.xpath("//*[@data-menu-xmlid='stock.menu_product_variant_config_stock' ]");
	By btn_createProduct = By.xpath("//button[@type='button' and @title='Create record' ]");
	By txt_Productname = By.xpath("//input[@name='name'] [starts-with(@id,'o_field_input')]");
	By btn_updateQty = By.xpath("//button[@type='button' and @name='action_update_quantity_on_hand'] ");
	By btn_createforqtyupdate= By.xpath("//button[@type='button' and @data-original-title='Create record']");
	By txt_CountedQty = By.xpath("//input[@name='inventory_quantity']");
	By btn_scheduledDate = By.xpath("//input[@type='text' and @name='inventory_date']");
	By btn_enableUserdrpdwn = By.xpath("//td[@name='inventory_date']/following-sibling::*[position()=1]");
	By drpdwn_user = By.xpath("//div[@name='user_id']//a");
	By drpdwn_user_options = By.xpath("//td[@name='inventory_date']/following-sibling::*[position()=1]//input");

	//	By drpdwn_user_options= By.xpath("//div[@class='oe-qweb-select']/following-sibling::*[position()=1]//a[contains(text(),'User')]");
	By btnSaveOrder = By.xpath("//button[@type='button' and @title ='Save record']");
	By btn_HomeMenu = By.xpath("//a[@title='Home menu']");
	public void createNewProduct(String ProductName,String Quantity) throws InterruptedException
	{
		pageutil.performClick(btn_ParentProducts);	
		pageutil.performClick(btn_drpdwnProducts);
		pageutil.performClick(btn_createProduct);
		pageutil.setText(txt_Productname, ProductName);
		pageutil.performClick(btn_updateQty);
		pageutil.performClick(btn_createforqtyupdate);
		pageutil.ClearField(txt_CountedQty);
		pageutil.setText(txt_CountedQty, Quantity);
	
		pageutil.performClick(btn_enableUserdrpdwn);
	
		pageutil.setText(drpdwn_user_options, "User");
		pageutil.setText(drpdwn_user, (Keys.ENTER));
		
//		pageutil.performClick(drpdwn_user);
//		pageutil.performClick(drpdwn_user_options);
		pageutil.performClick(btnSaveOrder);
	}
	public void gobacktoHomeMenu(){
		pageutil.performClick(btn_HomeMenu);
		
	}

}
