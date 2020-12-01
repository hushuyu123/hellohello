package com.webtest.demo;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
public class Admin_Front_Login extends BaseTest{
	public void loginout() {
		webtest.open("http://localhost:86/user/login");
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'退出')]");
		if(flag) {
			webtest.click("xpath=//a[contains(text(),'退出')]");
		}
	}
	@DataProvider(name="testData2" )
    public Object[][] data() throws IOException{
		ExcelDataProvider excel = new ExcelDataProvider();
    	return excel.getTestDataByExcel("data\\da.xlsx","login");
    }
	
	//测试用例6,登录成功
	//测试用例7,登入时输入错误密码
	//测试用例8，登录时输入错误验证码
    @Test(dataProvider = "testData2",priority = 1)
	public void testLogin(String name,String pwd,String code) throws InterruptedException {
    	webtest.open("http://localhost:86/user/login");
		webtest.type("name=user_name", name);
		webtest.type("name=user_password", pwd);
		webtest.type("name=captcha_code", code);
		webtest.click("xpath=//button[contains(text(),'会员登录')]");
		
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'退出')]");
		assertTrue(flag);
		if(flag) {
			webtest.click("xpath=//a[contains(text(),'退出')]");
		}
	}
    
    
    @DataProvider(name="testData3")
    public Object[][] data2() throws IOException{
    	ExcelDataProvider excel = new ExcelDataProvider();
    	return excel.getTestDataByExcel("data\\da.xlsx","findpwd");
    }
//	 9，找回密码成功
//  10,找回密码时，使用错误用户名
//  11,找回密码时，使用错误邮箱
    @Test(dataProvider = "testData3",priority = 2)
	public void testFindPwd(String name,String email,String code) throws InterruptedException {
    	loginout();
   		webtest.click("xpath=//a[contains(text(),'会员忘记密码')]");
   		webtest.type("name=user_name", name);
   		webtest.type("name=user_email", email);
   		webtest.type("name=captcha_code", code);
   		webtest.click("xpath=//button[contains(text(),'提交找回密码')]");
   		
   		boolean flag=webtest.isDisplayed("xpath=//div//h4[contains(text(),'已经向您的邮箱')]");
		assertTrue(flag);
	}
    
    @Test
	public void test13() throws InterruptedException {
    	webtest.open("http://localhost:86/admin/home");
		webtest.type("name=user_name", "admin");
		webtest.type("name=user_passwd", "12345678");
		webtest.click("xpath=//button[contains(text(),'后台登录')]");
		
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'退出系统')]");
		assertTrue(flag);
		
	}

}
