package com.webtest.demo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;
public class Admin_SystemManagement_StockControl extends BaseTest{
	@BeforeClass
	public void login() throws IOException, InterruptedException {
		adminLogin();
		Thread.sleep(2000);
		webtest.click("xpath=//a[contains(text(),'系统管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'状态设置')]");
		webtest.click("xpath=//a[contains(text(),'库存状态')]");
	}
	
	
	@Test(dataProvider = "stock1",dataProviderClass = NSDataProvider.class ) //36.库存状态管理中把有货的库存状态排序填写为‘aaaa’
	public void demo1(String sort) throws IOException, InterruptedException {

		webtest.click("xpath=//td[contains(text(),'有货状态')]/../td[5]/a");
		webtest.typeAndClear("id=state_sort", sort);
		webtest.click("xpath=//button[@type='submit']");
		String new_sort=webtest.getText("xpath=//td[contains(text(),'有货状态')]/../td[4]");
		assertEquals("aaaa",new_sort);
		
	}
	
	@Test(dataProvider = "stock2",dataProviderClass = NSDataProvider.class ) //37.库存状态管理中把有货的库存状态名称填写为‘123’
	public void demo2(String name) throws IOException, InterruptedException {
		
		webtest.click("xpath=//td[contains(text(),'有货状态')]/../td[5]/a");
		webtest.typeAndClear("id=stock_state_name", name);
		webtest.click("xpath=//button[@type='submit']");
		String new_name=webtest.getText("xpath=//td[contains(text(),'有货状态')]/../td[2]");
		assertEquals("123  (默认)",new_name);
		
	}
	
	
	@Test //38.库存状态管理中把有货的库存状态名称填写为空
	public void demo3() throws IOException, InterruptedException {
		
		webtest.click("xpath=//td[contains(text(),'有货状态')]/../td[5]/a");
		webtest.typeAndClear("id=stock_state_name", "");
		webtest.click("xpath=//button[@type='submit']");
		
		assertTrue(webtest.isTextPresent("库存状态名称不能为空"));
		
	}
	
}
