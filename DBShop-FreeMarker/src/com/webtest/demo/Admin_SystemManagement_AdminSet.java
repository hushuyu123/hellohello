package com.webtest.demo;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;
public class Admin_SystemManagement_AdminSet extends BaseTest{
	@BeforeClass
	public void login() throws IOException, InterruptedException {
		adminLogin();
		Thread.sleep(2000);
		webtest.click("xpath=//a[contains(text(),'系统管理')]");
		webtest.mouseToElement("link=管理员设置");
		Thread.sleep(3000);
		webtest.click("link=管理员");
	}
	
	
	@Test(dataProvider = "admin1",dataProviderClass = NSDataProvider.class ) //39.管理员设置中的管理员的基本信息，将登录密码填入‘123’
	public void demo1(String password,String con) throws IOException, InterruptedException {

		Thread.sleep(2000);
		webtest.click("xpath=//td[contains(text(),'admin')]/../td[6]/a");
		webtest.typeAndClear("id=admin_password", password);
		webtest.typeAndClear("id=admin_password_con", con);
		webtest.click("xpath=//button[@type='submit']");
		
		assertTrue(webtest.isTextPresent("至少输入6位密码"));
	}
	


	@Test(dataProvider = "admin2",dataProviderClass = NSDataProvider.class ) //40.管理员设置中的管理员的基本信息，将登录密码填入21个1
	public void demo2(String password,String con) throws IOException, InterruptedException {

		Thread.sleep(2000);
		webtest.click("xpath=//td[contains(text(),'admin')]/../td[6]/a");
		webtest.typeAndClear("id=admin_password", password);
		webtest.typeAndClear("id=admin_password_con", con);
		webtest.click("xpath=//button[@type='submit']");
		
		assertTrue(webtest.isTextPresent("密码最长为20位"));
	}
	
	@Test(dataProvider = "admin3",dataProviderClass = NSDataProvider.class )  //41.管理员设置中的管理员的基本信息，将登录密码和确认密码输入不一致
	public void demo3(String password,String con) throws IOException, InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//td[contains(text(),'admin')]/../td[6]/a");
		webtest.typeAndClear("id=admin_password", password);
		webtest.typeAndClear("id=admin_password_con", con);
		webtest.click("xpath=//button[@type='submit']");
		
		assertTrue(webtest.isTextPresent("两次输入的密码不一致"));
	}
	
	
	@Test   //43.点击管理员设置中的管理员下的管理员组的‘管理员’链接
	public void demo5() throws IOException, InterruptedException {

		webtest.click("xpath=//a[contains(text(),'返回管理员列表')]");
		Thread.sleep(2000);
		webtest.click("link=管理员");
		assertTrue(webtest.isTextPresent("编辑管理员组"));
	}
	
	
	
}
