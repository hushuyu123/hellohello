package com.webtest.demo;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;

public class Admin_OperationManagement extends BaseTest {
	/*
	 * 运营管理模块
	 * 
	 */
	@DataProvider(name = "Data")
	public Object[][] word() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\AddData2.xls", "Sheet1");
	}

	@Test(dataProvider = "Data")
	public void test1(String add1, String add2, String add3, String add4, String add5, String add6)
			throws InterruptedException {
		testLogin();
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'运营管理')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'优惠促销规则')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'添加新规则')]");
		webtest.type("name=promotions_name", add1);
		webtest.type("name=promotions_info", add2);
		webtest.type("name=promotions_start_time", add3);
		webtest.type("name=promotions_end_time", add4);
		webtest.click("xpath=//a[@href='#promotions_c']");
		webtest.type("name=shopping_amount", add5);
		webtest.type("name=shopping_discount", add6);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag=webtest.isTextPresent("优惠促销规则");
		assertEquals(flag, true);
	}

	@DataProvider(name = "Data1")
	public Object[][] word1() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\AddData2.xls", "Sheet2");
	}
	@Test(dataProvider = "Data1")
	public void test2(String add1, String add2, String add3, String add4, String add5, String add6, String add7,
			String add8, String add9) throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'运营管理')]");
		webtest.click("xpath=//a[contains(text(),'优惠券')]");
		webtest.click("xpath=//a[contains(text(),'添加优惠券')]");
		webtest.type("name=coupon_name", add1);
		webtest.type("name=coupon_info", add2);
		webtest.click("xpath=//a[contains(text(),'优惠规则')]");
		webtest.type("name=shopping_amount",add3);
		webtest.type("name=shopping_discount",add4);
		webtest.click("xpath=//a[contains(text(),'获取规则')]");
		webtest.type("name=get_coupon_start_time", add5);
		webtest.type("name=get_coupon_end_time", add6);
		webtest.type("name=get_shopping_amount", add7);
		webtest.click("xpath=//a[contains(text(),'使用规则')]");
		webtest.type("name=coupon_start_time",add8 );
		webtest.type("name=coupon_end_time", add9);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag=webtest.isTextPresent("添加优惠券");
		assertEquals(flag, true);
	}


	@DataProvider(name = "Data2")
	public Object[][] word2() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\AddData2.xls", "Sheet3");
	}
	@Test(dataProvider = "Data2")
	public void test10(String add1, String add2, String add3, String add4, String add5) throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'运营管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'专题管理')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'专题设置')]");
		webtest.click("xpath=//a[contains(text(),'添加专题')]");
		webtest.type("name=theme_name",add1);
		webtest.type("name=theme_sign",add2);
		webtest.selectByValue("name=theme_template", "default");
		webtest.click("xpath=//a[contains(text(),'搜索引擎优化')]");
		webtest.type("name=theme_extend_name", add3);
		webtest.type("name=theme_keywords", add4);
		webtest.type("name=theme_description",add5);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag=webtest.isTextPresent("添加专题");
		assertEquals(flag, true);
	}
	
	/**
	 * 删除
	 */
	
	@Test
	public void test_delete() {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'运营管理')]");
		webtest.click("xpath=//a[contains(text(),'优惠促销规则')]");
		webtest.click("xpath=//a[@href='/admin/goods/promotions/del/1']");
		webtest.alertAccept();
	}


}
