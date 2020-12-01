package com.webtest.demo;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
public class Admin_Base_Login extends BaseTest{

	@BeforeClass
	public void loginFirst() throws Exception {
		webtest.open("http://localhost:86/index.php/admin");
	}

	//空的用户名和正确密码，登陆失败，控制台输出“用户名错误！”
	@Test(priority=1)
	public void loginTest1()throws Exception{
		webtest.type("id=user_name", "");
		webtest.type("id=user_passwd", getExcel(3, 2));
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(1000);
		assertEquals(true, webtest.isTextPresent("后台首页"));
	}
	
	//空的用户名和错误的密码，登陆失败，控制台输出“用户名错误！”
	@Test(priority=2)
	public void loginTest2() throws Exception{
		webtest.type("id=user_name", "");
		webtest.type("id=user_passwd", getExcel(3, 3));
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(1000);
		assertEquals(true, webtest.isTextPresent("后台首页"));
	}
	
	//正确用户名和空的密码，登陆失败，控制台输出“密码不正确”
	@Test(priority=3)
	public void loginTest3()throws Exception{
		webtest.type("id=user_name",getExcel(3, 1));
		webtest.type("id=user_passwd", "");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(1000);
		assertEquals(true, webtest.isTextPresent("后台首页"));
	}
	
	//错误用户名和空的密码，登陆失败，控制台输出“用户名错误！”
	@Test(priority=4)
	public void loginTest4() throws Exception{
		webtest.type("id=user_name", getExcel(3, 4));
		webtest.type("id=user_passwd", "");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(1000);
		assertEquals(true, webtest.isTextPresent("后台首页"));
	}
	
	//空的用户名和空的密码，登录失败，控制台输出“用户名错误！”

	@Test(priority=5)

	public void loginTest5() throws Exception{
		webtest.type("id=user_name", "");
		webtest.type("id=user_passwd", "");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(1000);
		assertEquals(true, webtest.isTextPresent("后台首页"));

	}
	
	//错误用户名和错误的密码，登录失败，控制台输出“用户名错误！”

	@Test(priority=6)

	public void loginTest6() throws Exception{
		webtest.type("id=user_name", getExcel(3, 4));
		webtest.type("id=user_passwd", getExcel(3, 3));
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(1000);
		assertEquals(true, webtest.isTextPresent("后台首页"));

	}
	
	//正确用户名和错误的密码，登录失败，控制台输出“密码不正确”

	@Test(priority=7)

	public void loginTest7() throws Exception{
		webtest.type("id=user_name", getExcel(3, 1));
		webtest.type("id=user_passwd", getExcel(3, 3));
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(1000);
		assertEquals(true, webtest.isTextPresent("后台首页"));

	}

	//错误用户名和正确密码，登录失败，控制台输出“用户名错误！”

	@Test(priority=8)

	public void loginTest8() throws Exception{
		webtest.type("id=user_name", getExcel(3, 4));
		webtest.type("id=user_passwd", getExcel(3, 2));
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(1000);
		assertEquals(true, webtest.isTextPresent("后台首页"));

	}
	
	//正确用户名和正确密码，登录成功，控制台输出“登录成功！”
	@Test(priority=9)
	public void loginTest9()throws Exception{
		webtest.type("id=user_name", "admin");
		webtest.type("id=user_passwd", "123456");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(1000);
		assertEquals(true, webtest.isTextPresent("后台首页"));
	}
}
