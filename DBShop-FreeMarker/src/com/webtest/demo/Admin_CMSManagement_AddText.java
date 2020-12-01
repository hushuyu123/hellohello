package com.webtest.demo;
import static org.testng.Assert.assertEquals;

import java.util.Random;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
public class Admin_CMSManagement_AddText extends BaseTest{

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

	// 添加文章时只选择下拉框，不填写文章标题
	@Test(priority = 1)
	public void addAtrticle1() throws Exception {
		
		// 点击添加文章
		webtest.click("xpath=//a[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		// 找到下拉框标签
		webtest.click("xpath=//*[@id=\"article_class_id\"]");
		webtest.click("xpath=//option[@value=\"2\"]");
		Thread.sleep(1000);

		// 根据规则随机生成文本框内容
		int random = new Random().nextInt(200000000);
		webtest.type("xpath=//*[@id=\"article_writer\"]", String.valueOf(random));
		Thread.sleep(1000);

		// 点击保存
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		assertEquals(true, webtest.isTextPresent("添加文章"));
	}

	// 添加文章时只写文章标题不填写下拉框
	@Test(priority = 2)
	public void addAtrticle2() throws Exception {
		// 刷新
		webtest.click("xpath=//a[@class=\"btn btn-small btn-warning\"]");
		Thread.sleep(1000);

		// 输入标题
		int random1 = new Random().nextInt(200000000);
		webtest.type("xpath=//*[@id=\"article_title\"]", String.valueOf(random1));
		Thread.sleep(1000);

		// 根据规则随机生成文本框内容
		int random2 = new Random().nextInt(200000000);
		webtest.type("xpath=//*[@id=\"article_writer\"]", String.valueOf(random2));
		Thread.sleep(1000);

		// 点击保存
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		// driver.findElement(By.xpath("/html/body/div[1]/div/ul[2]/li[3]/a")).click();
		assertEquals(true, webtest.isTextPresent("添加文章"));
	}

	// 添加文章时填写标题和下拉框
	@Test(priority = 3)
	public void addAtrticle3() throws Exception {
		// 刷新
		webtest.click("xpath=//a[@class=\"btn btn-small btn-warning\"]");
		Thread.sleep(1000);

		// 输入标题
		int random1 = new Random().nextInt(200000000);
		webtest.type("xpath=//*[@id=\"article_title\"]", String.valueOf(random1));
		Thread.sleep(1000);

		// 找到下拉框标签
		webtest.click("xpath=//*[@id=\"article_class_id\"]");
		webtest.click("xpath=//option[@value=\"2\"]");
		Thread.sleep(1000);

		// 根据规则随机生成文本框内容
		int random2 = new Random().nextInt(200000000);
		webtest.type("xpath=//*[@id=\"article_writer\"]", String.valueOf(random2));
		Thread.sleep(1000);

		// 点击保存
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		// driver.findElement(By.xpath("/html/body/div[1]/div/ul[2]/li[3]/a")).click();
		assertEquals(true, webtest.isTextPresent("添加文章"));
	}

	// 禁用
	@Test(priority = 4)
	public void addAtrticle4() throws Exception {
		// 点击添加文章
		webtest.click("xpath=//a[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		// 输入标题
		int random1 = new Random().nextInt(200000000);
		webtest.type("xpath=//*[@id=\"article_title\"]", String.valueOf(random1));
		Thread.sleep(1000);

		// 找到下拉框标签
		webtest.click("xpath=//*[@id=\"article_class_id\"]");
		webtest.click("xpath=//option[@value=\"2\"]");
		Thread.sleep(1000);

		// 根据规则随机生成文本框内容
		int random2 = new Random().nextInt(200000000);
		webtest.type("xpath=//*[@id=\"article_writer\"]", String.valueOf(random2));
		Thread.sleep(1000);

		// 禁用
		webtest.click("xpath=//label[contains(text(),'禁用')]");
		Thread.sleep(1000);

		// 点击保存
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		assertEquals(true, webtest.isTextPresent("禁用"));

	}
}
