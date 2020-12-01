package com.webtest.demo;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;
public class Admin_SystemManagement_PaySet extends BaseTest {
	@BeforeClass
	public void login() throws IOException {
		adminLogin();
	}
    
	
	public void first() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//a[contains(text(),'系统管理')]");
		webtest.click("xpath=//a[contains(text(),'支付设置')]");
	}
	
	@Test //17.在支付设置中编辑将支付方式名称设为空
	public void demo1() throws IOException, InterruptedException {
		
		first();
		webtest.click("xpath=//table[@class='table table-hover']/tbody/tr[1]/td[9]/a");
		webtest.typeAndClear("name=payment_name", "");
		webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent("支付方式名称不能为空"));
	}
	
	@Test //18.在支付设置中编辑将支付宝支付状态由关闭变为开启
	public void demo2() throws IOException, InterruptedException {
	
		first();
		webtest.click("xpath=//table[@class='table table-hover']/tbody/tr[9]/td[9]/a");
		Thread.sleep(2000);
		webtest.click("xpath=//input[@value='1']");
		webtest.click("xpath=//button[@type='submit']");
		baseLogin();
		webtest.runJs("window.scrollBy(0,600)");
		Thread.sleep(3000);
		webtest.mouseToElementandClick("xpath=//button[@class='add-to-cart cart-1-8']");
		Thread.sleep(2000);
		webtest.click("id=J_miniCart");
		webtest.click("xpath=//a[contains(text(),'去结算')]");
		webtest.click("xpath=//input[@value='下一步']");
		assertTrue(webtest.isTextPresent("支付宝"));
	
	}
	
	
	@Test(dataProvider = "pay1",dataProviderClass = NSDataProvider.class ) //19.在支付设置中编辑将支付手续费改为10%
	public void demo3(String fee) throws IOException, InterruptedException {
		
		first();
		webtest.click("xpath=//table[@class='table table-hover']/tbody/tr[1]/td[9]/a");
		webtest.typeAndClear("id=payment_fee", fee);
		webtest.click("xpath=//button[@type='submit']");
		baseLogin();
		webtest.runJs("window.scrollBy(0,600)");
		Thread.sleep(3000);
		webtest.mouseToElementandClick("xpath=//button[@class='add-to-cart cart-1-8']");
		Thread.sleep(2000);
		webtest.click("id=J_miniCart");
		webtest.click("xpath=//a[contains(text(),'去结算')]");
		webtest.click("xpath=//input[@value='下一步']");
		webtest.runJs("window.scrollBy(0,550)");
		webtest.click("xpath=//div[@id='cart_step']/form/div/div[11]/label[3]/input");
		String goods_fee=webtest.getText("id=goods_total_fee");
		Double goods = Double.valueOf(goods_fee);
		String pay_fee =webtest.getText("id=pay_fee");
		Double pay = Double.valueOf(pay_fee);
		assertEquals(goods*0.1, pay ,0.01);
	
	}
	
	@Test(dataProvider = "pay2",dataProviderClass = NSDataProvider.class ) //20.在支付设置中编辑将支付手续费填入汉字
	public void demo4(String fee) throws IOException, InterruptedException {
		adminLogin();
		first();
		webtest.click("xpath=//table[@class='table table-hover']/tbody/tr[1]/td[9]/a");
		webtest.typeAndClear("id=payment_fee",fee);
		webtest.click("xpath=//button[@type='submit']");
	
		assertTrue(webtest.isTextPresent("只能填写数字或百分比"));
		
	}
	
	@Test  //21.在支付设置中编辑将订单状态设置为订单完成
	public void demo5() throws IOException, InterruptedException {
		adminLogin();
		first();
		webtest.click("xpath=//table[@class='table table-hover']/tbody/tr[1]/td[9]/a");
		webtest.selectByIndex("name=orders_state",6);
		webtest.click("xpath=//button[@type='submit']");
		baseLogin();
		webtest.runJs("window.scrollBy(0,600)");
		Thread.sleep(3000);
		webtest.click("xpath=//button[@class='add-to-cart cart-1-8']");
		Thread.sleep(2000);
		webtest.click("id=J_miniCart");
		webtest.click("xpath=//a[contains(text(),'去结算')]");
		webtest.click("xpath=//input[@value='下一步']");
		webtest.runJs("window.scrollBy(0,550)");
		webtest.click("xpath=//div[@id='cart_step']/form/div/div[11]/label[3]/input");
		webtest.click("xpath=//input[@value='确认订单']");
		Thread.sleep(5000);
		assertFalse(webtest.isElementPresent("xpath=//input[@value='马上去支付']"));
		
	}
	
	@Test  //22.配送管理编辑中将配送状态设置为关闭
	public void demo1_delivery() throws IOException, InterruptedException {
		
		webtest.click("xpath=//a[contains(text(),'系统管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'配送设置')]");
		webtest.click("xpath=//a[contains(text(),'动态API')]/../../li[1]");
		webtest.click("xpath=//table[@class='table table-hover']/tbody/tr/td[7]/a");
		
		webtest.click("xpath=//input[@value='0']");
		webtest.click("xpath=//button[@type='submit']");
		
		baseLogin();
		webtest.runJs("window.scrollBy(0,600)");
		Thread.sleep(3000);
		webtest.click("xpath=//button[@class='add-to-cart cart-1-8']");
		webtest.click("id=J_miniCart");
		webtest.click("xpath=//a[contains(text(),'去结算')]");
		webtest.click("xpath=//input[@value='下一步']");
		webtest.runJs("window.scrollBy(0,550)");
		webtest.click("xpath=//div[@id='cart_step']/form/div/div[11]/label[3]/input");
		webtest.runJs("window.scrollBy(0,800)");
		assertFalse(webtest.isElementPresent("xpath=//input[@value='确认订单']"));
	
	}
}
