package com.webtest.demo;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;
import com.webtest.utils.ReadProperties;
public class Admin_SystemManagement_MoneySet extends BaseTest{
	@BeforeClass
	public void login() throws IOException {
		adminLogin();
	}
	
	public void first() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//a[contains(text(),'系统管理')]");
		webtest.click("xpath=//a[contains(text(),'货币设置')]");
	}
	
	@Test(dataProvider = "money1",dataProviderClass = NSDataProvider.class ) //13.货币设置中添加欧元
	public void demo1(String select,String name,String symbol,String decimal,String rate) throws IOException, InterruptedException {
		
		first();
		webtest.click("xpath=//a[contains(text(),'添加货币')]");
		webtest.click("id=currency_code_chzn");
		webtest.type("class=valid",select);
		
		webtest.type("id=currency_name",name);
		webtest.click("id=currency_code_chzn_o_77");
		webtest.type("id=currency_symbol",symbol);
		webtest.type("id=currency_decimal", decimal);
		webtest.type("id=currency_rate", rate);
		webtest.click("xpath=//button[@type='submit']");
		String baseUrl = ReadProperties.getPropertyValue("base_url");
		webtest.open(baseUrl);
		assertTrue(webtest.isTextPresent("欧元"));
		
		adminLogin();
	}
	
	
	@Test(dataProvider = "money2",dataProviderClass = NSDataProvider.class ) //14.货币设置的货币信息中货币名称为空
	public void demo2(String select,String symbol,String decimal,String rate) throws IOException, InterruptedException {
		
		first();
		webtest.click("xpath=//a[contains(text(),'添加货币')]");
		webtest.click("id=currency_code_chzn");
		webtest.type("class=valid",select);
		
		webtest.type("id=currency_name","");
		webtest.click("id=currency_code_chzn_o_15");
		webtest.type("id=currency_symbol",symbol);
		webtest.type("id=currency_decimal",decimal);
		webtest.type("id=currency_rate", rate);
		webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent("货币名称不能为空"));
	}
	
	
	@Test(dataProvider = "money3",dataProviderClass = NSDataProvider.class )  //15.货币设置的货币信息中小数位数填入汉字
	public void demo3(String select,String name,String symbol,String decimal,String rate) throws IOException, InterruptedException {
		
		first();
		webtest.click("xpath=//a[contains(text(),'添加货币')]");
		webtest.click("id=currency_code_chzn");
		webtest.type("class=valid",select);
		
		webtest.type("id=currency_name",name);   //货币名称
		webtest.click("id=currency_code_chzn_o_77");
		webtest.type("id=currency_symbol",symbol);
		webtest.type("id=currency_decimal", decimal); //小数位数
		webtest.type("id=currency_rate", rate);   //货币汇率
		webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent("小数位数必须为数字"));
	}
	
	
	
	@Test(dataProvider = "money4",dataProviderClass = NSDataProvider.class )  //16.货币设置的货币信息中小数位数填入7
	public void demo4(String select,String name,String symbol,String decimal,String rate) throws IOException, InterruptedException {
		
		first();
		webtest.click("xpath=//a[contains(text(),'添加货币')]");
		webtest.click("id=currency_code_chzn");
		webtest.type("class=valid",select);
		
		webtest.type("id=currency_name",name);   //货币名称
		webtest.click("id=currency_code_chzn_o_77");
		webtest.type("id=currency_symbol",symbol);
		webtest.type("id=currency_decimal", decimal); //小数位数
		webtest.type("id=currency_rate", rate);   //货币汇率
		webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent("位数最大为6"));
	}
	
	@Test   //42.管理员设置中的管理员组的权限设置的全部权限取消
	public void demo4_admin() throws IOException, InterruptedException {
		webtest.click("xpath=//a[contains(text(),'系统管理')]");
		webtest.mouseToElement("link=管理员设置");
		Thread.sleep(3000);
		webtest.click("link=管理员组");
		Thread.sleep(2000);
		webtest.click("xpath=//td[contains(text(),'管理员')]/../td[3]/a");
		webtest.click("xpath=//a[contains(text(),'权限设置')]");
		webtest.click("name=purview[purviewAll]");
		assertEquals(webtest.isChecked("name=purview[purviewAll]"), false);
	}
}
