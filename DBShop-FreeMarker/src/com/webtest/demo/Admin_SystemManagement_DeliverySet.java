package com.webtest.demo;


import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;

public class Admin_SystemManagement_DeliverySet extends BaseTest{
	@BeforeClass
	public void login() throws IOException, InterruptedException {
		adminLogin();
		Thread.sleep(2000);
		webtest.click("xpath=//a[contains(text(),'系统管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'配送设置')]");
	}
		
	
	@Test  //23.配送设置的动态API将状态设置为开启
	public void demo2() throws IOException, InterruptedException {

		webtest.click("link=动态API");
		webtest.click("xpath=//a[contains(text(),'编辑')]");
		
		webtest.click("xpath=//input[@value='1']");
		webtest.click("xpath=//button[@type='submit']");
		
		
	}
	
	@Test(dataProvider = "delivery",dataProviderClass = NSDataProvider.class )  //24.配送设置的动态API中填写完信息后点击刷新
	public void demo3(String key) throws IOException, InterruptedException {
		
		webtest.click("link=动态API");
		webtest.click("xpath=//a[contains(text(),'编辑')]");
		
		webtest.selectByVisibleText("id=api_type", "企业版");
		webtest.type("id=api_key",key);
		
		webtest.click("xpath=//a[contains(text(),'刷新')]");
		assertFalse(webtest.isTextPresent("123"));
	}
	
	
}
