package com.webtest.demo;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;

public class Admin_CustomerManagement extends BaseTest {
	@DataProvider(name = "testData1")
	public Object[][] words1() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\AddData.xls", "Sheet1");
	}

	@DataProvider(name = "testData2")
	public Object[][] words2() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\AddData.xls", "Sheet2");
	}

	@DataProvider(name = "testData3")
	public Object[][] words3() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\AddData.xls", "Sheet8");
	}

	@DataProvider(name = "testData4")
	public Object[][] words4() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\AddData.xls", "Sheet4");
	}

	@DataProvider(name = "testData5")
	public Object[][] words5() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\AddData.xls", "Sheet7");
	}

	@DataProvider(name = "testData6")
	public Object[][] words6() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\AddData.xls", "Sheet6");
	}

	/*
	 * 
	 * 客户管理模块
	 */
	// 实现管理客户中的添加新顾客
	@Test(dataProvider = "testData1")
	public void test1(String add1, String add2, String add3, String add4) throws InterruptedException {
		testLogin();
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'管理客户')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'添加新客户')]");
		webtest.selectByValue("name=group_id", "1");
		webtest.type("name=user_name", add1);
		webtest.type("name=user_email", add2);
		webtest.type("name=user_password", add3);
		webtest.type("name=user_password_con", add4);
		Thread.sleep(3000);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("添加新客户");
		assertEquals(flag, true);
	}

	// 实现客户扩展信息中的添加扩展信息
	@Test(dataProvider = "testData2")
	public void test2_addradio(String add1, String add2, String add3) throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'客户扩展信息')]");
		webtest.click("xpath=//a[contains(text(),'添加扩展信息')]");
		webtest.type("name=field_name", add1);
		webtest.type("name=field_title", add2);
		webtest.selectByValue("name=field_type", "radio");
		webtest.type("name=field_radio_checkbox_select", add3);
		webtest.click("xpath=//input[@value='2']");
		webtest.click("xpath=//label[contains(text(),'关闭')]");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("添加扩展信息");
		assertEquals(flag, true);
	}

	@Test(dataProvider = "testData3")
	public void test3_addcheckbox(String add1, String add2, String add3) throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'客户扩展信息')]");
		webtest.click("xpath=//a[contains(text(),'添加扩展信息')]");
		webtest.type("name=field_name", add1);
		webtest.type("name=field_title", add2);
		webtest.selectByValue("name=field_type", "checkbox");
		webtest.type("name=field_radio_checkbox_select", add3);
		webtest.click("xpath=//input[@value='2']");
		webtest.click("xpath=//label[contains(text(),'关闭')]");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("添加扩展信息");
		assertEquals(flag, true);
	}

	@Test(dataProvider = "testData4")
	public void test4_addselect(String add1, String add2, String add3) throws InterruptedException {
		testLogin();
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'客户扩展信息')]");
		webtest.click("xpath=//a[contains(text(),'添加扩展信息')]");
		webtest.type("name=field_name", add1);
		webtest.type("name=field_title", add2);
		Thread.sleep(3000);
		webtest.selectByValue("name=field_type", "select");
		webtest.type("name=field_radio_checkbox_select", add3);
		webtest.click("xpath=//label[contains(text(),'关闭')]");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("添加扩展信息");
		assertEquals(flag, true);
	}

	@Test(dataProvider = "testData5")
	public void test5_addtext(String add1, String add2) throws InterruptedException {
		System.out.println(add1);
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'客户扩展信息')]");
		webtest.click("xpath=//a[contains(text(),'添加扩展信息')]");
		webtest.type("name=field_name", add1);
		webtest.type("name=field_title", add2);
		webtest.selectByValue("name=field_type", "text");
		webtest.click("xpath=//input[@value='2']");
		webtest.click("xpath=//label[contains(text(),'关闭')]");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("添加扩展信息");
		assertEquals(flag, true);

	}

	@Test(dataProvider = "testData6")
	public void test6_addtextarea(String add1, String add2) throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'客户扩展信息')]");
		webtest.click("xpath=//a[contains(text(),'添加扩展信息')]");
		webtest.type("name=field_name", add1);
		webtest.type("name=field_title", add2);
		webtest.selectByValue("name=field_type", "textarea");
		webtest.click("xpath=//input[@value='2']");
		webtest.click("xpath=//label[contains(text(),'关闭')]");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("添加扩展信息");
		assertEquals(flag, true);
	}

	/*
	 * 实现添加客户组
	 */
	@DataProvider(name = "AddData1")
	public Object[][] addData() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("E:\\shixun\\excel\\AddData1.xls", "Sheet1");
	}

	@Test(dataProvider = "AddData1")
	public void test4(String add1, String add2, String add3) throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'管理客户组')]");
		webtest.click("xpath=//a[contains(text(),'添加客户组')]");
		webtest.type("name=user_group_name", add1);
		webtest.type("name=integral_num_start", add2);
		webtest.type("name=integral_num_end", add3);
		webtest.click("name=integral_num_state");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("添加客户 组");
		assertEquals(flag, true);
	}

	/*
	 * 实现添加规则
	 */
	@DataProvider(name = "AddData2")
	public Object[][] addData1() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\AddData1.xls", "Sheet2");
	}

	@Test(dataProvider = "AddData2")
	public void test5(String add1, String add2, String add3, String add4) throws InterruptedException {
		testLogin();
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'管理积分')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'积分规则')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'添加新规则')]");
		webtest.type("name=integral_rule_name", add1);
		webtest.type("name=integral_rule_info", add2);
		webtest.type("name=integral_rule_start_time", "2020-11-20 15:08");
		webtest.type("name=integral_rule_end_time", "2020-12-20 15:80");
		webtest.click("xpath=//a[@href='#integral_rule_c']");
		webtest.type("name=shopping_amount", add3);
		webtest.type("name=integral_num", add4);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("添加新规则");
		assertEquals(flag, true);
	}

	@DataProvider(name = "AddData3")
	public Object[][] addData2() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\AddData1.xls", "Sheet4");
	}

	@Test(dataProvider = "AddData3")
	public void test5_addruleClose(String add1, String add2, String add3, String add4, String add5, String add6)
			throws InterruptedException {
		testLogin();
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'管理积分')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'积分规则')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'添加新规则')]");
		webtest.type("name=integral_rule_name", add1);
		webtest.type("name=integral_rule_info", add2);
		webtest.type("name=integral_rule_start_time", add3);
		webtest.type("name=integral_rule_end_time", add4);
		webtest.selectByValue("name=integral_rule_state", "2");
		webtest.click("xpath=//a[@href='#integral_rule_c']");
		webtest.type("name=shopping_amount", add5);
		webtest.type("name=integral_num", add6);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("添加新规则");
		assertEquals(flag, true);
	}

	/**
	 * 对之前板块实现添加后又进行编辑
	 */
	@DataProvider(name = "Data")
	public Object[][] word() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\AddData1.xls", "Sheet5");
	}

	@Test(dataProvider = "Data")
	public void test_editaddcustom(String add1, String add2, String add3, String add4, String add5, String add6,
			String add7) {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'管理客户')]");
		webtest.click("xpath=//a[@href='/admin/user/edit/1/other/1']");
		webtest.type("name=user_password", add1);
		webtest.type("name=user_password_con", add2);
		webtest.type("name=user_phone", add3);
		webtest.click("xpath=//a[@href='#user_b']");
		webtest.click("xpath=//button[contains(text(),'添加地址')]");
		webtest.type("name=true_name", add4);
		webtest.selectByValue("id=show_address_area", "35");
		webtest.type("name=address", add5);
		webtest.type("name=zip_code", add6);
		webtest.type("name=mod_phone", add7);
		webtest.click("xpath=//button[contains(text(),'修改')]");
		webtest.click("xpath=//button[contains(text(),'保存客户信息')]");
	}

	/*
	 * 实现板块的搜索、添加功能
	 * 
	 */
	// 搜索客户
	@Test
	public void test1_searchByname() throws InterruptedException {
		testLogin();
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'管理客户')]");
		Thread.sleep(3000);
		webtest.type("name=user_name", "qianx8");
		webtest.click("xpath=//button[contains(text(),'搜索')]");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("管理客户 - (客户数：1)");
		assertEquals(flag, true);
	}

	@Test
	public void test1_searchByemail() throws InterruptedException {
		testLogin();
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'管理客户')]");
		Thread.sleep(3000);
		webtest.type("name=user_email", "2591365420@qq.com");
		webtest.click("xpath=//button[contains(text(),'搜索')]");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("管理客户 - (客户数：1)");
		assertEquals(flag, true);
	}

	/**
	 * 管理积分中添加积分规则
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void test2() throws InterruptedException {
		testLogin();
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'管理积分')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'积分规则')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'添加新规则')]");
		webtest.type("name=integral_rule_name", "添加新规则");
		webtest.type("name=integral_rule_info", "添加新规则");
		webtest.type("name=integral_rule_start_time", "2020-11-20 15:08");
		webtest.type("name=integral_rule_end_time", "2020-12-20 15:80");
		webtest.click("xpath=//a[@href='#integral_rule_c']");
		webtest.type("name=shopping_amount", "500");
		webtest.type("name=integral_num", "100");
		webtest.click("xpath=//a[@href='#integral_rule_b']");
		webtest.selectByValue("name=integral_rule_user_type", "user_group");
		webtest.click("xpath=//input[contains(text(),'普通会员')]");
		webtest.click("xpath=//a[@href='#integral_rule_d']");
		webtest.selectByValue("name=integral_rule_goods_type", "class_goods");
		webtest.click("xpath=//label[contains(text(),'家用电器')]");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("添加新规则");
		assertEquals(flag, true);
	}
	
	/**
	 * 实现删除功能
	 */
	@Test
	public void test_detelecustom() {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'管理客户')]");
		webtest.click("xpath=//a[@onclick='user_del_js(1);']");
		webtest.alertAccept();
	}
	@Test
	public void test_deletecustomextends() {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'客户扩展信息')]");
		webtest.click("xpath=//a[@onclick='return field_del_js(1);']");
		webtest.alertAccept();
	}
	@Test
	public void test_deletecustomgroups() {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'管理客户组')]");
		webtest.click("xpath=//a[@onclick='return group_del_js(9);;']");
		webtest.alertAccept();
	}
	@Test
	public void test_deleterule() throws InterruptedException {
		testLogin();
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'管理积分')]");
		webtest.click("xpath=//a[contains(text(),'积分规则')]");
		webtest.click("xpath=//a[@href='/admin/user/integral/delIntegralRule/1']");
		webtest.alertAccept();
	}
}
