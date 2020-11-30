package com.webtest.demo;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;
import com.webtest.utils.ReadProperties;
public class Admin_SystemManagement_UserSet extends BaseTest {
	@BeforeClass
	public void login() throws IOException, InterruptedException {
		adminLogin();
	}
	
	//12.可用登录名全部进行勾选
	@Test(priority = 1,dataProvider = "user",dataProviderClass = NSDataProvider.class)   
	public void demo1(String name,String password,String code) throws IOException, InterruptedException {
		
		webtest.click("xpath=//a[contains(text(),'系统管理')]");
		webtest.click("xpath=//a[contains(text(),'客户设置')]");
		webtest.click("xpath=//a[contains(text(),'注册与登录')]");
		if(webtest.isChecked("name=login_email_state")==false) {
			webtest.click("name=login_email_state");
		}
		if(webtest.isChecked("name=login_phone_state")==false) {
			webtest.click("name=login_phone_state");
		}
		webtest.click("xpath=//button[@type='submit']");
		
		String baseUrl = ReadProperties.getPropertyValue("base_url");
		webtest.open(baseUrl);
		
		webtest.click("xpath=//a[contains(text(),'登录')]");
		webtest.type("id=user_name", name);
		webtest.type("id=user_password", password);
		webtest.type("id=captcha_code", code);
		webtest.click("xpath=//button[contains(text(),'会员登录')]");
		assertTrue(webtest.isElementPresent("xpath=//a[contains(text(),'退出')]"));
		
	
	}
	
	@Test  //50.在线客服设置的在线客服分组中将‘1’组的客服组状态禁用
	public void demo7_service() throws IOException, InterruptedException {
		
		webtest.click("xpath=//a[contains(text(),'系统管理')]");
		webtest.mouseToElement("link=在线客服设置");
		Thread.sleep(2000);
		webtest.click("xpath=//a[contains(text(),'在线客服分组')]");
		Thread.sleep(2000);
		webtest.click("xpath=//td[contains(text(),'第一组')]/../td[6]/a");
		webtest.click("xpath=//input[@value='0']");
		webtest.click("xpath=//button[@type='submit']");
		baseLogin();
		assertFalse(webtest.isTextPresent("第一组"));
		adminLogin();
		
	}
}
