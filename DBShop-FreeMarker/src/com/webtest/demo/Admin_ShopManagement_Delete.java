package com.webtest.demo;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.URL;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;

public class Admin_ShopManagement_Delete extends BaseTest{

	@BeforeClass
	public void admin() {
		webtest.open("http://localhost:86/admin/home");
		webtest.type("name=user_name", "admin");
		webtest.type("name=user_passwd", "123456");
		webtest.click("xpath=//button[contains(text(),'后台登录')]");
	}
	//24,删除商品
	@Test
	public void test24() throws InterruptedException {
		boolean flag = false;
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
		webtest.click("xpath=//a[contains(text(),'管理商品')]");
		webtest.click("xpath=//a[contains(text(),'删除')]");
		
		webtest.getAlert();
		if(webtest.getAlertTest() != null) {
			flag = true;
		}	
		webtest.alertAccept();
		assertTrue(flag);
	}
	
	//25,删除商品分类
	@Test
	public void test25() throws InterruptedException {
		boolean flag = false;
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'管理分类')]");
		webtest.click("link=商品分类");
		webtest.click("xpath=//a[contains(text(),'删除分类')]");
		webtest.getAlert();
		if(webtest.getAlertTest() != null) {
			flag = true;
		}	
		webtest.alertAccept();
		assertTrue(flag);
		Thread.sleep(3000);
	}
	//26,删除侧边显示
	@Test
	public void test26() throws InterruptedException {
		boolean flag = false;
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'管理分类')]");
		webtest.click("link=前台侧边设置");
		webtest.click("xpath=//a[contains(text(),'删除')]");
		webtest.getAlert();
		if(webtest.getAlertTest() != null) {
			flag = true;
		}	
		webtest.alertAccept();
		assertTrue(flag);
		Thread.sleep(3000);
	}
	
	//27,删除属性分组
	@Test
	public void test27() throws InterruptedException {
		boolean flag = false;
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'商品属性')]");
		webtest.click("link=属性分组");
		webtest.click("xpath=//a[contains(text(),'删除')]");	
		webtest.getAlert();
		if(webtest.getAlertTest() != null) {
			flag = true;
		}	
		webtest.alertAccept();
		assertTrue(flag);
		Thread.sleep(3000);
	}
	
	//28，删除商品品牌
	@Test
	public void test28() throws InterruptedException{
		boolean flag = false;
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
		webtest.click("xpath=//a[contains(text(),'商品品牌')]");
		webtest.click("xpath=//a[contains(text(),'删除')]");	
		webtest.getAlert();
		if(webtest.getAlertTest() != null) {
			flag = true;
		}	
		webtest.alertAccept();
		assertTrue(flag);
		Thread.sleep(3000);
	}
	
	//29，删除评价
	@Test
	public void test29() throws InterruptedException {
		boolean flag = false;
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
		webtest.click("xpath=//a[contains(text(),'商品评价')]");
		webtest.click("xpath=//a[contains(text(),'编辑查看')]");	
		webtest.click("xpath=//a[contains(text(),'删除')]");	
		webtest.getAlert();
		if(webtest.getAlertTest() != null) {
			flag = true;
		}	
		webtest.alertAccept();
		assertTrue(flag);
		Thread.sleep(3000);
	}
	
	//30,咨询删除
	@Test
	public void test30() throws InterruptedException {
		boolean flag = false;
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
		webtest.click("xpath=//a[contains(text(),'商品咨询')]");
		webtest.click("xpath=//a[contains(text(),'删除')]");	
		webtest.getAlert();
		if(webtest.getAlertTest() != null) {
			flag = true;
		}	
		webtest.alertAccept();
		assertTrue(flag);
		Thread.sleep(3000);
	}
	
	//31，删除标签组信息
	@Test
	public void test31() throws InterruptedException{
		boolean flag = false;
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'商品标签')]");
		webtest.click("xpath=//a[contains(@href,'/admin/goods/tag/tagGroup')]");
		webtest.click("xpath=//a[contains(text(),'删除')]");	
		webtest.getAlert();
		if(webtest.getAlertTest() != null) {
			flag = true;
		}	
		webtest.alertAccept();
		assertTrue(flag);
		Thread.sleep(3000);
	}
	
	//32，删除普通商品标签
	@Test
	public void test32() throws InterruptedException {
		boolean flag = false;
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'商品标签')]");
		webtest.click("link=普通商品标签");
		webtest.click("xpath=//a[contains(text(),'删除')]");	
		webtest.getAlert();
		if(webtest.getAlertTest() != null) {
			flag = true;
		}	
		webtest.alertAccept();
		assertTrue(flag);
		Thread.sleep(3000);
	}
	
	//34,删除特定商品标签
	@Test
	public void test34() throws InterruptedException { 
		boolean flag = false;
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'商品标签')]");
		webtest.click("link=特定商品标签");
		webtest.click("xpath=//a[contains(text(),'删除')]");	
		webtest.getAlert();
		if(webtest.getAlertTest() != null) {
			flag = true;
		}	
		webtest.alertAccept();
		assertTrue(flag);
		Thread.sleep(3000);
	}
	
	//33,删除商品标签内商品信息
	@Test
	public void test33() throws InterruptedException {
		boolean flag = false;
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'商品标签')]");
		webtest.click("link=特定商品标签");
		webtest.click("xpath=//a[contains(text(),'编辑')]");	
		webtest.click("xpath=//a[contains(@href,'tag_b')]");
		webtest.click("xpath=//a[contains(text(),'删除')]");
		if(webtest.getAlertTest() != null) {
			flag = true;
		}
		assertTrue(flag);
		webtest.click("xpath=//button[contains(text(),'保存标签信息')]");
		Thread.sleep(3000);
	}	
}
