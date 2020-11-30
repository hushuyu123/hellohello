package com.webtest.demo;
import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
public class Admin_CMSManagement_AddTextKind extends BaseTest{

	@BeforeClass
	public void loginFirst() throws Exception {
		webtest.open("http://localhost:86/index.php/admin");

		webtest.type("id=user_name", "admin");
		webtest.type("id=user_passwd", "123456");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(1000);

		webtest.click("xpath=//a[contains(text(),'CMS管理')]");
		webtest.click("xpath=//a[contains(text(),'管理文章')]");
		Thread.sleep(3000);
	}
	
	//只填写分类名称 不选择分类状态(默认状态)
	@Test(priority=1)
	public void AddKind1()throws Exception{
		//点击添加分类
		webtest.click("xpath=//a[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);
		
		//填写分类名称
		int random = new Random().nextInt(200000000);
		webtest.type("xpath=//*[@id=\"article_class_name\"]", String.valueOf(random));
		Thread.sleep(1000);
		
		//保存分类
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);
		
		assertEquals(true, webtest.isTextPresent("添加文章"));
		
	}
	
	//不填写分类名称，选择默认状态
	@Test(priority=2)
	public void AddKind2()throws Exception{
		//点击添加分类
		webtest.click("xpath=//a[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);
	
		//保存分类
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);
		
		assertEquals(true, webtest.isTextPresent("添加文章"));
	}
	
	//添加分类子类
	@Test(priority=3)
	public void AddKind3()throws Exception{
		//返回
		webtest.click("xpath=//a[@class=\"btn btn-small\"]");
		Thread.sleep(1000);
		
		//点击添加子类
		webtest.click("xpath=//a[text()='添加子类']");
		Thread.sleep(1000);
		
		//填写分类名称
		int random = new Random().nextInt(200000000);
		webtest.type("xpath=//*[@id=\"article_class_name\"]", String.valueOf(random));
		Thread.sleep(1000);
		
		//保存分类
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);
		
		assertEquals(true, webtest.isTextPresent("添加文章"));
		
	}
	
	//删除含文章的分类
	@Test(priority=4)
	public void AddKind4()throws Exception{
		//点击删除
		webtest.click("xpath=//a[text()='删除分类']");
		Thread.sleep(1000);
		
		//弹出框选择确定

		System.out.println(getDriver().switchTo().alert().getText());
		getDriver().switchTo().alert().accept();
		getDriver().switchTo().alert().accept();
		Thread.sleep(1000);
		
		assertEquals(false, webtest.isTextPresent("添加文章"));
	}

	//禁用文章分类
	@Test(priority=5)
	public void AddKind5()throws Exception{
		//点击添加分类
		webtest.click("xpath=//a[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);
		
		//填写分类名称
		int random = new Random().nextInt(200000000);
		webtest.type("xpath=//*[@id=\"article_class_name\"]", String.valueOf(random));
		Thread.sleep(1000);
		
		//禁用
		webtest.click("xpath=//*[@id=\"article_class_state\"]");
		webtest.click("xpath=//option[@value=\"0\"]");
		
		//保存分类
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);
		
		assertEquals(true, webtest.isTextPresent("已禁用"));
		
	}
}
