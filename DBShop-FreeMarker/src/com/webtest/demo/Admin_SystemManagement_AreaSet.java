package com.webtest.demo;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;
public class Admin_SystemManagement_AreaSet extends BaseTest{
	@BeforeClass
	public void login() throws IOException {
		adminLogin();
	}

	public void first() throws InterruptedException,IOException {
		Thread.sleep(2000);
		webtest.click("xpath=//a[contains(text(),'系统管理')]");
		webtest.click("xpath=//a[contains(text(),'地区管理')]");
		
	}
	
	@Test //30.地区管理中删除北京市
	public void demo1() throws IOException, InterruptedException {
		
		first();
		webtest.click("xpath=//td[contains(text(),'北京市')]/../td[5]/a[2]");
		webtest.alertAccept();
		assertTrue(webtest.isTextPresent("地区删除失败，该地区还有下级地区存在"));
	}
	
	
	@Test(dataProvider = "area1",dataProviderClass = NSDataProvider.class ) //31.地区管理中将北京市的地区排序改为‘2’
	public void demo2(String sort) throws IOException, InterruptedException {
		
		first();
		webtest.click("xpath=//td[contains(text(),'北京市')]/../td[5]/span");
		webtest.typeAndClear("id=edit_region_sort1",sort);
		webtest.click("xpath=//button[contains(text(),'保存')]");
	}
	
	
	@Test(dataProvider = "area2",dataProviderClass = NSDataProvider.class ) //32.在西城区的下级地区中添加地区
	public void demo3(String name) throws IOException, InterruptedException {
		
		first();
		webtest.click("xpath=//td[contains(text(),'北京市')]/../td[5]/a");
		webtest.click("xpath=//td[contains(text(),'西城区')]/../td[5]/a");
		webtest.click("xpath=//a[contains(text(),'添加地区')]");
		webtest.typeAndClear("id=region_name", name);
		webtest.click("xpath=//button[contains(text(),'保存')]");
	}

	
	
	@Test //33.在西城区的下级地区中添加地区，其中地区名称为空
	public void demo4() throws IOException, InterruptedException {
		
		first();
		webtest.click("xpath=//td[contains(text(),'北京市')]/../td[5]/a");
		webtest.click("xpath=//td[contains(text(),'西城区')]/../td[5]/a");
		webtest.click("xpath=//a[contains(text(),'添加地区')]");
		webtest.typeAndClear("id=region_name", "");
		webtest.click("xpath=//button[contains(text(),'保存')]");
		assertTrue(webtest.isTextPresent("请输入地区名称"));
		webtest.click("class=close");
	}
	

	
	
	@Test //34.将西城区下添加的地区删除
	public void demo5() throws IOException, InterruptedException {
		first();
		webtest.click("xpath=//td[contains(text(),'北京市')]/../td[5]/a");
		webtest.click("xpath=//td[contains(text(),'西城区')]/../td[5]/a");
		webtest.click("id=select_checkbox_state_1");
		webtest.selectByVisibleText("id=allEdit","删除");
		webtest.click("xpath=//button[contains(text(),'提交操作')]");
		webtest.alertAccept();
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("提交操作"));
	}
	

	
	
	@Test(dataProvider = "area2",dataProviderClass = NSDataProvider.class ) //35.在西城区的下级地区中添加地区，其中地区排序为空
	public void demo6(String name) throws IOException, InterruptedException {
		
		first();
		webtest.click("xpath=//td[contains(text(),'北京市')]/../td[5]/a");
		webtest.click("xpath=//td[contains(text(),'西城区')]/../td[5]/a");
		webtest.click("xpath=//a[contains(text(),'添加地区')]");
		webtest.typeAndClear("id=region_name",name);
		webtest.typeAndClear("id=region_sort", "");
		
		
		webtest.click("xpath=//button[contains(text(),'保存')]");
		String sort = webtest.getText("xpath=//td[contains(text(),'A县')]/../td[4]");
		System.out.println("排序为空保存后地区排序为："+sort);
		assertEquals("255", sort);
	}
	
	
	@Test(priority = 2,dataProvider = "message1",dataProviderClass = NSDataProvider.class )  //25.消息提醒设置的手机短信提醒设置中，将管理员手机号填写为“11111111”
	public void demo1_message(String phone) throws IOException, InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//a[contains(text(),'系统管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'消息提醒设置')]");
		webtest.click("link=手机短信提醒设置");
		webtest.typeAndClear("id=admin_phone", phone);
		webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent("手机号填写不正确"));
	}
	
	
}
