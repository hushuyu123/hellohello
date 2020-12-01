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
public class Admin_Register extends BaseTest{

	public void loginout() {
		webtest.open("http://localhost:86/user/register");
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'退出')]");
		if(flag) {
			webtest.click("xpath=//a[contains(text(),'退出')]");
		}
	}
	@DataProvider(name="testData1")
    public Object[][] data() throws IOException{
		ExcelDataProvider excel = new ExcelDataProvider();
    	return excel.getTestDataByExcel("data\\da.xlsx","reg");
    }
	
//	1，注册成功
//	2,注册密码超过规定位数
//	3，注册时使用已经存在的会员名
//	4,注册时输入错误验证码
	@Test(dataProvider = "testData1")
	public void test_reg(String name,String pwd,String cpwd,String email,String code) throws InterruptedException {
		loginout();
		webtest.type("name=user_name", name);
		webtest.type("name=user_password", pwd);
		webtest.type("name=user_com_passwd", cpwd);
		webtest.type("name=user_email", email);
		webtest.type("name=captcha_code", code);
		webtest.click("name=agreement");
		webtest.click("xpath=//button[contains(text(),'提交注册用户')]");
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'退出')]");
		assertTrue(flag);
		if(flag) {
			webtest.click("xpath=//a[contains(text(),'退出')]");
		}
	}
	
//	5,不勾选“注册协议”
	@Test
	public void test5_reg(){
		loginout();
		webtest.type("name=user_name", "testuser");
		webtest.type("name=user_password", "12345678");
		webtest.type("name=user_com_passwd", "12345678");
		webtest.type("name=user_email", "25673989@qq.com");
		webtest.type("name=captcha_code", "11111");
		webtest.click("xpath=//button[contains(text(),'提交注册用户')]");
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'退出')]");
		assertTrue(flag);
	}
}
