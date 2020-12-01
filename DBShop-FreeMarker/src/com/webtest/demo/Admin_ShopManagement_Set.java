package com.webtest.demo;


import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;

public class Admin_ShopManagement_Set extends BaseTest{

	@BeforeClass
	public void admin() {
		webtest.open("http://localhost:86/admin/home");
		webtest.type("name=user_name", "admin");
		webtest.type("name=user_passwd", "123456");
		webtest.click("xpath=//button[contains(text(),'后台登录')]");
	}
    @DataProvider(name="testData5")
    public Object[][] data2() throws IOException{
    	ExcelDataProvider excel = new ExcelDataProvider();
    	return excel.getTestDataByExcel("data\\da.xlsx","sreach");
    }
    @DataProvider(name="testData10")
    public Object[][] data7() throws IOException{
    	ExcelDataProvider excel = new ExcelDataProvider();
    	return excel.getTestDataByExcel("data\\da.xlsx","test26");
    }
    @DataProvider(name="testData13")
    public Object[][] data10() throws IOException{
    	ExcelDataProvider excel = new ExcelDataProvider();
    	return excel.getTestDataByExcel("data\\da.xlsx","conten");
    }
    
	//44,输入商品名称进行搜索
    //45,输入商品ID范围查找商品
    //46，输入商品货号查找商品
	@Test(dataProvider = "testData5")
	public void test46(String name,String start_id,String end_id, String id) {
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
		webtest.click("xpath=//a[contains(text(),'管理商品')]");
		webtest.type("name=goods_name", name);
		webtest.type("name=start_goods_id", start_id);
		webtest.type("name=end_goods_id", end_id);
		webtest.type("name=goods_item", id);
		webtest.click("xpath=//button[contains(@onclick,'edit_type')]");
		
		boolean flag=webtest.isDisplayed("class=icon-arrow-left");
		assertTrue(flag);
	}

	//47,预览商品
	@Test
	public void test47() {
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
		webtest.click("xpath=//a[contains(text(),'管理商品')]");
		webtest.click("xpath=//a[contains(text(),'商品预览')]");
		
	}

	//48,属性值设置
	@Test(dataProvider = "testData10")
	public void test48(String input1,String input2) throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'商品属性')]");
		webtest.click("xpath=//a[contains(@href,'/admin/goods/attribute')]");
		webtest.click("xpath=//a[contains(text(),'属性值设置')]");
		webtest.typeAndClear("id=value_name", input1);
		webtest.typeAndClear("id=value_sort",input2);
		webtest.click("xpath=//button[contains(text(),'保存属性值')]");
		
	}	
	
	//49,商品索引设置
	@Test
	public void test49() {
		boolean flag=false;
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
		webtest.click("xpath=//a[contains(text(),'商品索引')]");
		webtest.click("id=goods_index");
		webtest.click("xpath=//button[contains(text(),'点击更新商品索引')]");
		webtest.getAlert();
		if(webtest.getAlertTest() != null) {
			flag = true;
		}	
		webtest.alertAccept();
		webtest.click("xpath=//button[contains(text(),'保存索引设置')]");
		
		assertTrue(flag);
	}
	
	//50,商品咨询回复
	@Test(dataProvider = "testData13")
	public void test50(String content) {
		admin();
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
		webtest.click("xpath=//a[contains(text(),'商品咨询')]");
		webtest.click("xpath=//a[contains(text(),'咨询回复')]");	
		webtest.type("id=reply_ask_content", content);
		webtest.click("xpath=//button[contains(text(),'回复商品咨询')]");	
		
		boolean flag=webtest.isDisplayed("xpath=//*[contains(text(),'回复内容：')]");
		assertTrue(flag);
	}
}
