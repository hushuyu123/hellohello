package com.webtest.demo;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.webtest.core.BaseTest;

public class Admin_ToolManagement_NavigationSetting extends BaseTest {

	@BeforeClass
	public void loginFirst() throws Exception {
		webtest.open("http://localhost:86/index.php/admin");

		webtest.type("id=user_name", "admin");
		webtest.type("id=user_passwd", "123456");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(1000);

		webtest.click("xpath=//a[contains(text(),'工具管理')]");
		webtest.click("xpath=//a[contains(text(),'导航设置')]");
	}

	// 不写导航标题保存导航链接
	@Test(priority = 1)
	public void AddLink1() throws Exception {
		// 点击添加导航链接
		webtest.click("xpath=//a[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		// 点击获取商品品牌地址
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\" and @type=\"button\"]");
		Thread.sleep(1000);

		// 点击保存
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\" and @type=\"submit\"]");
		Thread.sleep(1000);

		// false
		assertEquals(true, webtest.isTextPresent("添加导航链接"));

	}

	// 填写导航标题保存导航链接
	@Test(priority = 2)
	public void AddLink2() throws Exception {
		webtest.click("xpath=//a[@class=\"btn btn-small btn-warning\"]");
		Thread.sleep(1000);

		// 填写导航标题
		int random = new Random().nextInt(200000000);
		webtest.type("xpath=//*[@id=\"navigation_title\"]", String.valueOf(random));
		Thread.sleep(1000);

		// 点击获取商品品牌地址
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\" and @type=\"button\"]");
		Thread.sleep(1000);

		// 点击保存
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\" and @type=\"submit\"]");
		Thread.sleep(1000);

		// true
		assertEquals(true, webtest.isTextPresent("添加导航链接"));
	}

}
