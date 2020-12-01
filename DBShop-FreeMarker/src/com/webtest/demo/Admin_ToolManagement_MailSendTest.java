package com.webtest.demo;

import static org.testng.Assert.assertEquals;

import java.util.Random;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.webtest.core.BaseTest;

public class Admin_ToolManagement_MailSendTest extends BaseTest {

	@BeforeClass
	public void loginFirst() throws Exception {
		webtest.open("http://localhost:86/index.php/admin");

		webtest.type("id=user_name", "admin");
		webtest.type("id=user_passwd", "123456");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[contains(text(),'工具管理')]");
		webtest.click("xpath=//a[contains(text(),'邮件发送')]");
	}

	// 不选收件人类别 填写收件人 不填标题
	@Test(priority = 1)
	public void MailSend1() throws Exception {
		// 填写收件人
		webtest.type("id=send_user", getExcel(4, 1));
		Thread.sleep(1000);

		// 填写内容
		int random = new Random().nextInt(200000000);
		webtest.type("id=ueditor_0", String.valueOf(random));
		Thread.sleep(1000);

		// 点击发送邮件
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		assertEquals(false, webtest.isTextPresent("选择收件人类别！"));
	}

	// 不选收件人类别 填收件人 填写标题
	@Test(priority = 2)
	public void MailSend2() throws Exception {
		// 填写邮件标题
		int random1 = new Random().nextInt(200000000);
		webtest.type("xpath=//*[@id=\"mail_subject\"]", String.valueOf(random1));
		Thread.sleep(1000);

		// 填写内容
		int random2 = new Random().nextInt(200000000);
		webtest.type("id=ueditor_0", String.valueOf(random2));
		Thread.sleep(1000);

		// 点击发送
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		// 断言
		assertEquals(false, webtest.isTextPresent("选择收件人类别！"));
	}

	// 不选收件人类别 不填收件人 不填标题
	@Test(priority = 3)
	public void MailSend3() throws Exception {
		// 点击刷新
		webtest.click("xpath=//a[@class=\"btn btn-small btn-warning\"]");
		Thread.sleep(1000);

		// 填写内容
		int random = new Random().nextInt(200000000);
		webtest.type("id=ueditor_0", String.valueOf(random));
		Thread.sleep(1000);

		// 点击发送
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		// 断言
		assertEquals(false, webtest.isTextPresent("选择收件人类别！"));
	}

	// 不选收件人类别 不填收件人 填标题
	@Test(priority = 4)
	public void MailSend4() throws Exception {
		// 填写邮件标题
		int random1 = new Random().nextInt(200000000);
		webtest.type("xpath=//*[@id=\"mail_subject\"]", String.valueOf(random1));
		Thread.sleep(1000);

		// 填写内容
		int random = new Random().nextInt(200000000);
		webtest.type("id=ueditor_0", String.valueOf(random));
		Thread.sleep(1000);

		// 点击发送
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		// 断言
		assertEquals(false, webtest.isTextPresent("选择收件人类别！"));
	}

	// 选择普通会员 收件人自动弹出 不填标题
	@Test(priority = 5)
	public void MailSend5() throws Exception {
		// 点击刷新
		webtest.click("xpath=//a[@class=\"btn btn-small btn-warning\"]");
		Thread.sleep(1000);

		// 选择收件人类别下拉框
		webtest.click("xpath=//*[@id=\"send_user_type\"]");
		Thread.sleep(1000);

		// 选择普通会员
		webtest.click("xpath=//option[@value=\"1\"]");
		Thread.sleep(1000);

		// 填写内容
		int random = new Random().nextInt(200000000);
		webtest.type("id=ueditor_0", String.valueOf(random));
		Thread.sleep(1000);

		// 点击发送
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		// 断言
		assertEquals(false, webtest.isTextPresent("请填写邮件标题！"));
	}

	// 选择普通会员 收件人 填标题
	@Test(priority = 6)
	public void MailSend6() throws Exception {
		// 点击刷新
		webtest.click("xpath=//a[@class=\"btn btn-small btn-warning\"]");
		Thread.sleep(1000);

		// 选择收件人类别下拉框
		webtest.click("xpath=//*[@id=\"send_user_type\"]");
		Thread.sleep(1000);

		// 选择普通会员
		webtest.click("xpath=//option[@value=\"1\"]");
		Thread.sleep(1000);
		// 填写标题
		int random1 = new Random().nextInt(200000000);
		webtest.type("xpath=//*[@id=\"mail_subject\"]", String.valueOf(random1));
		Thread.sleep(1000);

		// 填写内容
		int random2 = new Random().nextInt(200000000);
		webtest.type("id=ueditor_0", String.valueOf(random2));
		Thread.sleep(1000);

		// 点击发送
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		// 断言
		assertEquals(true, webtest.isTextPresent("选择收件人类别！"));
	}

	// 选择自定义 不填收件人 不填标题
	@Test(priority = 7)
	public void MailSend7() throws Exception {
		// 点击刷新
		webtest.click("xpath=//a[@class=\"btn btn-small btn-warning\"]");
		Thread.sleep(1000);

		// 选择收件人类别下拉框
		webtest.click("xpath=//*[@id=\"send_user_type\"]");
		Thread.sleep(1000);

		// 选择自定义
		webtest.click("xpath=//option[@value=\"other\"]");
		Thread.sleep(1000);

		// 填写内容
		int random = new Random().nextInt(200000000);
		webtest.type("id=ueditor_0", String.valueOf(random));
		Thread.sleep(1000);

		// 点击发送
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		// 断言
		assertEquals(false, webtest.isTextPresent("选择收件人！"));
	}

	// 选择自定义 不填收件人 填标题
	@Test(priority = 8)
	public void MailSend8() throws Exception {
		// 点击刷新
		webtest.click("xpath=//a[@class=\"btn btn-small btn-warning\"]");
		Thread.sleep(1000);

		// 选择收件人类别下拉框
		webtest.click("xpath=//*[@id=\"send_user_type\"]");
		Thread.sleep(1000);

		// 选择自定义
		webtest.click("xpath=//option[@value=\"other\"]");
		Thread.sleep(1000);

		// 填写标题
		int random1 = new Random().nextInt(200000000);
		webtest.type("xpath=//*[@id=\"mail_subject\"]", String.valueOf(random1));
		Thread.sleep(1000);

		// 填写内容
		int random = new Random().nextInt(200000000);
		webtest.type("id=ueditor_0", String.valueOf(random));
		Thread.sleep(1000);

		// 点击发送
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		// 断言
		assertEquals(false, webtest.isTextPresent("选择收件人！"));
	}

	// 选择自定义 填写收件人 不填标题
	@Test(priority = 9)
	public void MailSend9() throws Exception {
		// 点击刷新
		webtest.click("xpath=//a[@class=\"btn btn-small btn-warning\"]");
		Thread.sleep(1000);

		// 选择收件人类别下拉框
		webtest.click("xpath=//*[@id=\"send_user_type\"]");
		Thread.sleep(1000);

		// 选择自定义
		webtest.click("xpath=//option[@value=\"other\"]");
		Thread.sleep(1000);

		// 填写收件人
		webtest.type("id=send_user", getExcel(4, 1));
		Thread.sleep(1000);

		// 填写内容
		int random = new Random().nextInt(200000000);
		webtest.type("id=ueditor_0", String.valueOf(random));
		Thread.sleep(1000);

		// 点击发送
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		// 断言
		assertEquals(false, webtest.isTextPresent("请填写邮件标题！"));
	}

	// 选择自定义 填写收件人 填写标题
	@Test(priority = 10)
	public void MailSend10() throws Exception {
		// 点击刷新
		webtest.click("xpath=//a[@class=\"btn btn-small btn-warning\"]");
		Thread.sleep(1000);

		// 选择收件人类别下拉框
		webtest.click("xpath=//*[@id=\"send_user_type\"]");
		Thread.sleep(1000);

		// 选择自定义
		webtest.click("xpath=//option[@value=\"other\"]");
		Thread.sleep(1000);

		// 填写收件人
		webtest.type("id=send_user", getExcel(4, 1));
		Thread.sleep(1000);

		int random1 = new Random().nextInt(200000000);
		webtest.type("xpath=//*[@id=\"mail_subject\"]", String.valueOf(random1));
		Thread.sleep(1000);

		// 填写内容
		int random = new Random().nextInt(200000000);
		webtest.type("id=ueditor_0", String.valueOf(random));
		Thread.sleep(1000);

		// 点击发送
		webtest.click("xpath=//button[@class=\"btn btn-small btn-primary\"]");
		Thread.sleep(1000);

		// 断言
		assertEquals(true, webtest.isTextPresent("邮件发送成功!"));
	}
}
