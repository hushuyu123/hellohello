package com.webtest.demo;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Admin_ToolManagement_FriendlyLinkTest extends BaseTest {

	@BeforeClass
	public void loginFirst() throws Exception {
		webtest.open("http://localhost:86/index.php/admin");

		webtest.type("id=user_name", "admin");
		webtest.type("id=user_passwd", "123456");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(1000);

		webtest.click("xpath=//a[contains(text(),'工具管理')]");
		webtest.click("xpath=//a[contains(text(),'友情链接')]");
	}

	// 不填写网站名称，不填写网站地址
	@Test(priority = 1)
	public void AddFriendlyLink1() throws Exception {
		// 添加链接
		webtest.click("xpath=//a[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		// 保存
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		// false
		assertEquals(true, webtest.isTextPresent("添加友情链接"));
	}

	// 填写网站名称,填写正确网站地址
	@Test(priority = 2)
	public void AddFriendlyLink2() throws Exception {
		// 刷新
		webtest.click("xpath=//a[@class=\"btn btn-small btn-warning\"]");
		Thread.sleep(1000);

		// 广告名称
		int random = new Random().nextInt(200000000);
		webtest.type("xpath=//*[@id=\"links_webname\"]", String.valueOf(random));
		Thread.sleep(1000);

		// 添加地址
		webtest.type("xpath=//*[@id=\"links_url\"]", getExcel(2, 1));
		Thread.sleep(1000);

		// 点击保存
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		// true
		assertEquals(true, webtest.isTextPresent("添加友情链接"));
	}

	// 填写网站名称，填写错误网站地址
	@Test(priority = 3)
	public void AddFriendlyLink3() throws Exception {
		// 点击添加
		webtest.click("xpath=//a[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		int random = new Random().nextInt(200000000);
		webtest.type("xpath=//*[@id=\"links_webname\"]", String.valueOf(random));
		Thread.sleep(1000);

		// 添加地址
		webtest.type("xpath=//*[@id=\"links_url\"]", getExcel(2, 2));
		Thread.sleep(1000);

		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		// false
		assertEquals(true, webtest.isTextPresent("添加友情链接"));
	}

	// 填写网站名称，不填写网站地址
	@Test(priority = 4)
	public void AddFriendlyLink4() throws Exception {
		// 刷新
		webtest.click("xpath=//a[@class=\"btn btn-small btn-warning\"]");
		Thread.sleep(1000);

		int random = new Random().nextInt(200000000);
		webtest.type("xpath=//*[@id=\"links_webname\"]", String.valueOf(random));
		Thread.sleep(1000);

		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		// false
		assertEquals(true, webtest.isTextPresent("添加友情链接"));
	}

	// 不填写网站名称，填写正确网站地址
	@Test(priority = 5)
	public void AddFriendlyLink5() throws Exception {
		webtest.click("xpath=//a[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		// 添加地址
		webtest.type("xpath=//*[@id=\"links_url\"]", getExcel(2, 1));
		Thread.sleep(1000);

		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);
		// false
		assertEquals(true, webtest.isTextPresent("添加友情链接"));
	}

	// 不填写网站名称，填写错误网站地址
	@Test(priority = 6)
	public void AddFriendlyLink6() throws Exception {
		// 刷新
		webtest.click("xpath=//a[@class=\"btn btn-small btn-warning\"]");
		Thread.sleep(1000);

		// 添加地址
		webtest.type("xpath=//*[@id=\"links_url\"]", getExcel(2, 2));
		Thread.sleep(1000);

		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		// false
		assertEquals(true, webtest.isTextPresent("添加友情链接"));
	}

	// 禁用友情链接
	@Test(priority = 7)
	public void DisableLink() throws Exception {
		// 点击刷新
		webtest.click("xpath=//a[@class=\"btn btn-small btn-warning\"]");
		Thread.sleep(1000);

		// 填写名称
		int random = new Random().nextInt(200000000);
		webtest.type("xpath=//*[@id=\"links_webname\"]", String.valueOf(random));
		Thread.sleep(1000);

		// 添加地址
		webtest.type("xpath=//*[@id=\"links_url\"]", getExcel(2, 1));
		Thread.sleep(1000);

		// 禁用
		webtest.click("xpath=//label[contains(text(),'禁用')]");
		Thread.sleep(1000);

		// 保存
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		// true
		assertEquals(true, webtest.isTextPresent("禁用"));
	}
}
