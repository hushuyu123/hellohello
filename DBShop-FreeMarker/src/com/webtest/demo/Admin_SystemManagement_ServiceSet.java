package com.webtest.demo;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;
public class Admin_SystemManagement_ServiceSet extends BaseTest{
	@BeforeClass
	public void login() throws IOException, InterruptedException {
		adminLogin();
		Thread.sleep(2000);
		webtest.click("xpath=//a[contains(text(),'系统管理')]");
		webtest.mouseToElement("link=在线客服设置");
		Thread.sleep(2000);
		webtest.click("link=在线客服成员");
	}
	
	public void first() throws InterruptedException, IOException{
		if(webtest.isTextPresent("系统管理")==false) {
			adminLogin();
		}
		Thread.sleep(2000);
		webtest.click("xpath=//a[contains(text(),'系统管理')]");
		webtest.mouseToElement("link=在线客服设置");
		Thread.sleep(2000);
		webtest.click("link=在线客服成员");
	}
	

	//44.在线客服设置中添加客服
	@Test(priority = 1,dataProvider = "service1",dataProviderClass = NSDataProvider.class )  
	public void demo1(String name,String account,String sort) throws IOException, InterruptedException, CloneNotSupportedException {

		Thread.sleep(2000);
		webtest.click("xpath=//a[contains(text(),'添加在线客服')]");
		webtest.type("id=online_name", name);
		webtest.selectByIndex("id=online_group_id", 1);
		webtest.selectByIndex("id=online_type", 2);
		webtest.type("id=online_account",  account);
		webtest.typeAndClear("id=online_sort", sort);
		webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent(name));
	}
	
	//45.在线客服设置的在线客服成员中添加在线客服选择通讯工具‘腾讯QQ’
	@Test(priority=2 ,dataProvider = "service2",dataProviderClass = NSDataProvider.class)  
	public void demo2(String name,String account,String sort) throws IOException, InterruptedException, CloneNotSupportedException {

		
		webtest.click("xpath=//a[contains(text(),'添加在线客服')]");
		webtest.type("id=online_name", name);
		webtest.selectByIndex("id=online_group_id", 1);
		webtest.selectByVisibleText("id=online_type", "腾讯QQ");
		webtest.type("id=online_account",  account);
		webtest.typeAndClear("id=online_sort",  sort);
		webtest.click("xpath=//button[@type='submit']");
		
	}
	
	
	@Test(priority=3)  //46.在线客服设置的在线客服成员中删除客服
	public void demo3() throws IOException, InterruptedException {
		

		Thread.sleep(2000);
		webtest.click("xpath=//td[contains(text(),'客服2')]/../td[7]/a[2]");
		webtest.alertAccept();
	}
	
	
	@Test(priority=4)    //47.在线客服设置的在线客服成员中在编辑基本信息中删除客服
	public void demo4() throws IOException, InterruptedException {
		

		Thread.sleep(2000);
		webtest.click("xpath=//td[contains(text(),'客服1')]/../td[7]/a");
		webtest.click("xpath=//td[contains(text(),'删除在线客服')]");
		webtest.alertAccept();
	}
	
	
	@Test(priority=6)    //48.在线客服设置的在线客服成员中将客服的客服状态设置为禁用
	public void demo5() throws IOException, InterruptedException {
		

		Thread.sleep(2000);
		webtest.click("xpath=//td[contains(text(),'客服2')]/../td[7]/a");
		webtest.click("xpath=//input[@value='0']");
		webtest.click("xpath=//button[@type='submit']");
		baseLogin();
		assertFalse(webtest.isTextPresent("客服2"));
		adminLogin();
		
	}
	
	 //49.在线客服设置的在线客服成员中编辑基本信息时不选择客服组名称
	@Test(dataProvider = "service3",dataProviderClass = NSDataProvider.class,priority = 5) 
	public void demo6(String name,String account,String sort) throws IOException, InterruptedException {
		

		Thread.sleep(2000);
		webtest.click("xpath=//a[contains(text(),'添加在线客服')]");
		webtest.typeAndClear("id=online_name", name);
		webtest.selectByVisibleText("id=online_type", "腾讯QQ");
		webtest.type("id=online_account",account);
		webtest.typeAndClear("id=online_sort", sort);
		webtest.click("xpath=//button[@type='submit']");
		
		assertTrue(webtest.isTextPresent("请选择客户组"));
	}
	

	
}
