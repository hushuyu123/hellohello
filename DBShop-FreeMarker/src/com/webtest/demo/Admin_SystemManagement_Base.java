package com.webtest.demo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;
import com.webtest.utils.ReadProperties;

public class Admin_SystemManagement_Base extends BaseTest {
	@BeforeClass
	public void login() throws IOException {
		adminLogin();
	}

	public void first() throws InterruptedException, IOException {
		if(webtest.isTextPresent("系统设置")==false) {
			adminLogin();
		}
		Thread.sleep(2000);
		webtest.click("xpath=//a[contains(text(),'系统管理')]");
		webtest.click("xpath=//a[contains(text(),'系统设置')]");
		
	}
	
	@Test(dataProvider = "base1",dataProviderClass = NSDataProvider.class)  //1.文件过大
	public void demo1(String file) throws InterruptedException, IOException {  
		first();
		webtest.type("name=shop_logo", file);
		webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent("最大允许'1.95MB'"));

	}
	
	@Test(dataProvider = "base2",dataProviderClass = NSDataProvider.class)  //2.文件不是图片
	public void demo2(String file) throws InterruptedException, IOException { 
		first();
		webtest.type("name=shop_logo",file);
		webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent("扩展名不允许"));

		
	}
	
	@Test  //3.网站名称为空
	public void demo3() throws InterruptedException, IOException {  
		first();
		webtest.typeAndClear("id=shop_name", "");
		webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent("网站名称不能为空"));
	}
	
	@Test  //4.打开暂时关闭选项
	public void demo4() throws InterruptedException, IOException { 
		//进行关闭
		first();
		webtest.runJs("window.scroll(0,document.body.scrollHeight)");
		webtest.click("id=shop_close");
		webtest.click("xpath=//button[@type='submit']");
		webtest.open(ReadProperties.getPropertyValue("base_url").toString());
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("系统升级中"));
		
		//打开，防止干扰其他用例
		adminLogin();
		first();
		webtest.runJs("window.scroll(0,document.body.scrollHeight)");
		webtest.click("id=shop_close");
		webtest.click("xpath=//button[@type='submit']");
		
	}
	
	@Test(dataProvider = "base3",dataProviderClass = NSDataProvider.class)  //5.开启邮件状态
	public void demo5(String mail,String name) throws IOException, InterruptedException { 
		first();
		webtest.click("xpath=//a[contains(text(),'邮件服务器')]");
		if(webtest.isChecked("id=email_service_state")==false) {
			webtest.click("id=email_service_state");
			webtest.typeAndClear("id=send_from_mail",mail);
			webtest.typeAndClear("id=send_name", name);
			webtest.click("xpath=//button[@type='submit']");
		}
	}
	
	
	@Test(dataProvider = "base4",dataProviderClass = NSDataProvider.class)  //6.邮件地址不正确
	public void demo6(String mail,String name) throws IOException, InterruptedException {
		first();
		webtest.click("xpath=//a[contains(text(),'邮件服务器')]");
		webtest.click("id=email_service_state");
		webtest.typeAndClear("id=send_from_mail",mail);
		webtest.typeAndClear("id=send_name", name);
		webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent("请正确填写邮件地址"));
	}
	
	@Test(dataProvider = "base5",dataProviderClass = NSDataProvider.class)  //7.发件人名称为空
	public void demo7(String mail) throws IOException, InterruptedException { 
		first();
		webtest.click("xpath=//a[contains(text(),'邮件服务器')]");
		webtest.click("id=email_service_state");
		webtest.typeAndClear("id=send_from_mail",mail);
		webtest.typeAndClear("id=send_name","");
		webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent("发件人名称不能为空"));
	}
	
	@Test  //8.关闭登录时验证码验证
	public void demo8() throws IOException, InterruptedException { 
		first();
		webtest.click("xpath=//a[contains(text(),'验证码设置')]");
		if(webtest.isChecked("id=user_login_captcha")) {
			webtest.click("id=user_login_captcha");
			webtest.click("xpath=//button[@type='submit']");
		}
		baseLogin();
		assertFalse(webtest.isTextPresent("验证码"));
	
	}
	
	@Test  //9.打开二维码
	public void demo9() throws IOException, InterruptedException { 
		first();
		webtest.click("xpath=//a[contains(text(),'二维码设置')]");
		if(webtest.isChecked("id=shop_QRcode")==false) {
			webtest.click("id=shop_QRcode");
			webtest.click("xpath=//button[@type='submit']");
		}
		baseLogin();
		Thread.sleep(2000);
		assertTrue(webtest.isElementPresent("xpath=//div[@class='header-info']/img"));
		
	}
	
	@Test  //10.打开订单设置中的选择送货时间显示
	public void demo10() throws IOException, InterruptedException { 
		first();
		webtest.click("xpath=//a[contains(text(),'订单设置')]");
		if (webtest.isChecked("id=user_shipping_date")==false) {
			webtest.click("id=user_shipping_date");
			webtest.click("xpath=//button[@type='submit']");
			
		}
		baseLogin();
		webtest.click("id=J_miniCart");
		webtest.click("xpath=//a[contains(text(),'去结算')]");
		webtest.click("xpath=//input[@value='下一步']");
		assertTrue(webtest.isTextPresent("只工作日送货 "));
		
		
	}
	
	@Test(dataProvider = "base6",dataProviderClass = NSDataProvider.class)  //11.在前台底部功能中添加图片和链接地址
	public void demo11(String file,String url) throws IOException, InterruptedException { 
		first();
		webtest.click("xpath=//a[contains(text(),'前台底部')]");
		webtest.type("name=image_1",file);
		webtest.type("name=image_url_1",url);
		webtest.click("xpath=//button[@type='submit']");
		webtest.click("xpath=//a[contains(text(),'前台底部')]");
		assertFalse(webtest.isTextPresent("www.baidu.com"));
	}
	
	
}
