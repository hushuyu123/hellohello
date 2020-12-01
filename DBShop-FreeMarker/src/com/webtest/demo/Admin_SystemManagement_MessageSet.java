package com.webtest.demo;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
public class Admin_SystemManagement_MessageSet extends BaseTest{
	@BeforeClass
	public void login() throws IOException, InterruptedException {
		adminLogin();
		Thread.sleep(2000);
		webtest.click("xpath=//a[contains(text(),'系统管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'消息提醒设置')]");
		webtest.click("link=电子邮件提醒设置");
		Thread.sleep(2000);
	}
	
	
	@Test(priority = 1)  //26.消息提醒设置的邮件管理设置中的基本信息的管理员接收邮箱1设为空
	public void demo2() throws IOException, InterruptedException {

		webtest.typeAndClear("id=admin_receive_email", "");
		webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent("管理员接收邮件不能为空"));
	}
	
//	@Test(priority = 1,dataProvider = "message2",dataProviderClass = NSDataProvider.class )  //27.消息提醒设置的邮件管理设置中的基本信息的管理员接收邮箱1设为“123456789”
	public void demo3(String mail) throws IOException, InterruptedException {
	
		webtest.typeAndClear("xpath=//label[contains(text(),'管理员接收邮箱1')]/../div/input", mail);
		webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent("请正确填写邮件地址"));
	}
	
	
//	@Test(priority = 1)  //28.消息提醒设置的邮件管理设置中的提交订单的消息内容中将‘网站名称’按钮点击10次
	public void demo4() throws IOException, InterruptedException {
		
		webtest.click("xpath=//a[contains(text(),'提交订单')]");
		for(int i=0;i<10;i++) {
			webtest.click("xpath=//button[contains(text(),'网站名称')]");
		}
		webtest.click("xpath=//button[@type='submit']");
	
	}
	
	
//	@Test(priority = 1,dataProvider = "message3",dataProviderClass = NSDataProvider.class )  //29.消息提醒设置的邮件管理设置中的提交订单的消息内容中将‘网站名称’按钮点击10次保存后再刷新页面
	public void demo5(String text) throws IOException, InterruptedException {

		webtest.click("xpath=//a[contains(text(),'提交订单')]");
		webtest.typeAndClear("id=submit_order", text);
		for(int i=0;i<10;i++) {
			webtest.click("xpath=//button[contains(text(),'网站名称')]");
		}
		String oldString = webtest.getText("id=submit_order");
		webtest.click("xpath=//button[@type='submit']");
		webtest.click("xpath=//a[contains(text(),'刷新')]");
		webtest.click("xpath=//a[contains(text(),'提交订单')]");
		String newString = webtest.getText("id=submit_order");
		assertEquals(oldString, newString);
		
	}
	
	
}
