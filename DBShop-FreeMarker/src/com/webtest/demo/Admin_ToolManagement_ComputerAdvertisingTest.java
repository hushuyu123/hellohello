package com.webtest.demo;

import com.webtest.core.BaseTest;
import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Admin_ToolManagement_ComputerAdvertisingTest extends BaseTest {

	@BeforeClass
	public void loginFirst() throws Exception {
		webtest.open("http://localhost:86/index.php/admin");

		webtest.type("id=user_name", "admin");
		webtest.type("id=user_passwd", "123456");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(1000);

		webtest.click("xpath=//a[contains(text(),'工具管理')]");
		WebElement e1 = getDriver().findElement(By.xpath("//a[contains(text(),'广告管理')]"));
		Actions builder = new Actions(getDriver());
		builder.moveToElement(e1).perform();
		webtest.click("xpath=//a[contains(text(),'电脑端广告(PC)')]");
		Thread.sleep(2000);
	}

	// 添加广告 位置不写 名称不写 类型不写
	@Test(priority = 1)
	public void Demo1() throws Exception {
		// 点击首页广告-设置广告
		webtest.click("//tr[1]//td//a[text()='设置广告']");
		Thread.sleep(1000);

		// 点击添加广告
		webtest.click("xpath=//a[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		// 点击保存广告信息
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		assertEquals(true, webtest.isTextPresent("保存广告信息"));
	}

	// 添加广告 位置写 名称不写 类型不写
	@Test(priority = 2)
	public void Demo2() throws Exception {
		// 点击刷新
		webtest.click("xpath=//a[@class=\"btn btn-small btn-warning\"]");
		Thread.sleep(1000);

		// 点击广告位置
		webtest.click("xpath=//*[@id=\"ad_place\"]");
		Thread.sleep(1000);

		// 点击幻灯片1下
		webtest.click("xpath=//option[@value=\"huandengd_1\"]");
		Thread.sleep(1000);

		// 点击保存广告信息
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		assertEquals(true, webtest.isTextPresent("保存广告信息"));
	}

	// 添加广告 位置写 名称写 类型不写
	@Test(priority = 3)
	public void Demo3() throws Exception {
		// 点击刷新
		webtest.click("xpath=//a[@class=\"btn btn-small btn-warning\"]");
		Thread.sleep(1000);

		// 点击广告位置
		webtest.click("xpath=//*[@id=\"ad_place\"]");
		Thread.sleep(1000);

		// 点击幻灯片2下
		webtest.click("xpath=//option[@value=\"huandengd_2\"]");
		Thread.sleep(1000);

		// 填写广告名称
		int random = new Random().nextInt(200000000);
		webtest.type("xpath=//*[@id=\"ad_name\"]", String.valueOf(random));
		Thread.sleep(1000);

		// 点击保存广告信息
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		assertEquals(true, webtest.isTextPresent("保存广告信息"));
	}

	// 添加广告 位置写 名称不写 类型写
	@Test(priority = 4)
	public void Demo4() throws Exception {
		// 点击刷新
		webtest.click("xpath=//a[@class=\"btn btn-small btn-warning\"]");
		Thread.sleep(1000);

		// 点击广告位置
		webtest.click("xpath=//*[@id=\"ad_place\"]");
		Thread.sleep(1000);

		// 点击幻灯片3下
		webtest.click("xpath=//option[@value=\"huandengd_3\"]");
		Thread.sleep(1000);

		// 点击选择广告类型
		webtest.click("xpath=//*[@id=\"ad_type\"]");
		Thread.sleep(1000);

		// 选择文字
		webtest.click("xpath=//option[@value=\"text\"]");
		Thread.sleep(1000);

		// 点击保存广告信息
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		assertEquals(true, webtest.isTextPresent("保存广告信息"));
	}

	// 添加广告 位置写 名称写 类型写
	@Test(priority = 5)
	public void Demo5() throws Exception {
		// 点击刷新
		webtest.click("xpath=//a[@class=\"btn btn-small btn-warning\"]");
		Thread.sleep(1000);

		// 点击广告位置
		webtest.click("xpath=//*[@id=\"ad_place\"]");
		Thread.sleep(1000);

		// 点击幻灯片4下
		webtest.click("xpath=//option[@value=\"huandengd_4\"]");
		Thread.sleep(1000);

		// 填写广告名称
		int random = new Random().nextInt(200000000);
		webtest.type("xpath=//*[@id=\"ad_name\"]", String.valueOf(random));
		Thread.sleep(1000);

		// 点击选择广告类型
		webtest.click("xpath=//*[@id=\"ad_type\"]");
		Thread.sleep(1000);

		// 选择文字
		webtest.click("xpath=//option[@value=\"text\"]");
		Thread.sleep(1000);

		// 点击保存广告信息
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		assertEquals(true, webtest.isTextPresent("保存广告信息"));
	}

	// 添加广告 位置写 名称写30个1 类型写
	@Test(priority = 6)
	public void Demo6() throws Exception {
		// 点击添加广告
		webtest.click("xpath=//a[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		// 点击广告位置
		webtest.click("xpath=//*[@id=\"ad_place\"]");
		Thread.sleep(1000);

		// 点击商品右侧幻灯片
		webtest.click("xpath=//option[@value=\"class_right\"]");
		Thread.sleep(1000);

		// 填写广告名称
		webtest.type("xpath=//*[@id=\"ad_name\"]", getExcel(1, 1));
		Thread.sleep(1000);

		// 点击选择广告类型
		webtest.click("xpath=//*[@id=\"ad_type\"]");
		Thread.sleep(1000);

		// 选择文字
		webtest.click("xpath=//option[@value=\"text\"]");
		Thread.sleep(1000);

		// 点击保存广告信息
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		assertEquals(true, webtest.isTextPresent("保存广告信息"));
	}

	// 添加广告 位置写 名称写30个汉字 类型写
	@Test(priority = 7)
	public void Demo7() throws Exception {
		// 点击刷新
		webtest.click("xpath=//a[@class=\"btn btn-small btn-warning\"]");
		Thread.sleep(1000);

		// 点击广告位置
		webtest.click("xpath=//*[@id=\"ad_place\"]");
		Thread.sleep(1000);

		// 点击首页1f
		webtest.click("xpath=//option[@value=\"floor_1_image\"]");
		Thread.sleep(1000);

		// 填写广告名称
		webtest.type("xpath=//*[@id=\"ad_name\"]", getExcel(1, 2));
		Thread.sleep(1000);

		// 点击选择广告类型
		webtest.click("xpath=//*[@id=\"ad_type\"]");
		Thread.sleep(1000);

		// 选择文字
		webtest.click("xpath=//option[@value=\"text\"]");
		Thread.sleep(1000);

		// 点击保存广告信息
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		assertEquals(true, webtest.isTextPresent("保存广告信息"));
	}

	// 添加广告 位置写 名称写80个汉字 类型写
	@Test(priority = 8)
	public void Demo8() throws Exception {
		// 点击刷新
		webtest.click("xpath=//a[@class=\"btn btn-small btn-warning\"]");
		Thread.sleep(1000);

		// 点击广告位置
		webtest.click("xpath=//*[@id=\"ad_place\"]");
		Thread.sleep(1000);

		// 点击首页2f
		webtest.click("xpath=//option[@value=\"floor_2_image\"]");
		Thread.sleep(1000);

		// 填写广告名称
		webtest.type("xpath=//*[@id=\"ad_name\"]", getExcel(1, 2) + getExcel(1, 3));
		Thread.sleep(1000);

		// 点击选择广告类型
		webtest.click("xpath=//*[@id=\"ad_type\"]");
		Thread.sleep(1000);

		// 选择文字
		webtest.click("xpath=//option[@value=\"text\"]");
		Thread.sleep(1000);

		// 点击保存广告信息
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		assertEquals(true, webtest.isTextPresent("保存广告信息"));
	}

	// 添加广告 位置写 名称写 类型写 禁用
	@Test(priority = 9)
	public void Demo9() throws Exception {
		// 点击刷新
		webtest.click("xpath=//a[@class=\"btn btn-small btn-warning\"]");
		Thread.sleep(1000);

		// 点击广告位置
		webtest.click("xpath=//*[@id=\"ad_place\"]");
		Thread.sleep(1000);

		// 点击首页3f
		webtest.click("xpath=//option[@value=\"floor_3_image\"]");
		Thread.sleep(1000);

		// 填写广告名称
		int random = new Random().nextInt(200000000);
		webtest.type("xpath=//*[@id=\"ad_name\"]", String.valueOf(random));
		Thread.sleep(1000);

		// 点击选择广告类型
		webtest.click("xpath=//*[@id=\"ad_type\"]");
		Thread.sleep(1000);

		// 选择文字
		webtest.click("xpath=//option[@value=\"text\"]");
		Thread.sleep(1000);

		// 点击禁用
		webtest.click("xpath=//label[contains(text(),'禁用')]");
		Thread.sleep(1000);

		// 点击保存广告信息
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		assertEquals(true, webtest.isTextPresent("禁用"));
	}

	// 商品列表页添加广告
	@Test(priority = 10)
	public void Demo10() throws Exception {
		// 返回广告管理
		webtest.click("xpath=//a[@class=\"btn btn-small\"]");
		Thread.sleep(1000);

		// 点击商品列表页广告设置广告
		webtest.click("//tr[2]//td//a[text()='设置广告']");
		Thread.sleep(1000);

		// 点击添加广告
		webtest.click("xpath=//a[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		// 选择广告位置
		webtest.click("xpath=//*[@id=\"ad_place\"]");
		webtest.click("xpath=//option[@value=\"floor_1_image\"]");
		Thread.sleep(1000);

		// 填写广告名称
		int random = new Random().nextInt(200000000);
		webtest.type("xpath=//*[@id=\"ad_name\"]", String.valueOf(random));
		Thread.sleep(1000);

		// 选择广告类型
		webtest.click("xpath=//*[@id=\"ad_type\"]");
		webtest.click("xpath=//option[@value=\"text\"]");
		Thread.sleep(1000);

		// 点击保存
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		assertEquals(true, webtest.isTextPresent("商品列表页广告"));
	}

	// 产品页添加广告
	@Test(priority = 11)
	public void Demo11() throws Exception {
		// 返回广告管理
		webtest.click("xpath=//a[@class=\"btn btn-small\"]");
		Thread.sleep(1000);

		// 点击产品页广告
		webtest.click("//tr[3]//td//a[text()='设置广告']");
		Thread.sleep(1000);

		// 点击添加广告
		webtest.click("xpath=//a[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		// 选择广告位置
		webtest.click("xpath=//*[@id=\"ad_place\"]");
		webtest.click("xpath=//option[@value=\"floor_1_image\"]");
		Thread.sleep(1000);

		// 填写广告名称
		int random = new Random().nextInt(200000000);
		webtest.type("xpath=//*[@id=\"ad_name\"]", String.valueOf(random));
		Thread.sleep(1000);

		// 选择广告类型
		webtest.click("xpath=//*[@id=\"ad_type\"]");
		Thread.sleep(1000);
		webtest.click("xpath=//option[@value=\"text\"]");
		Thread.sleep(1000);

		// 点击保存
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		assertEquals(true, webtest.isTextPresent("商品列表页广告"));
	}
}
