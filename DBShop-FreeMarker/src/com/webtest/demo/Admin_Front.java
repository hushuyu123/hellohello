package com.webtest.demo;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
/**
 * 前台：首页
 * @author 胡淑玉
 *
 */
public class Admin_Front extends BaseTest {
	@BeforeClass
	public void login() throws InterruptedException {
		webtest.open("http://localhost:86/user/login");
		webtest.type("name=user_name", "admin2");
		webtest.type("name=user_password", "admin2");
		webtest.type("name=captcha_code", "11111");
		Thread.sleep(2000);
		webtest.click("xpath=//button[contains(text(),'会员登录')]");
		Thread.sleep(2000);
	}
	
	//1-直接加入购物车
	@Test
	public void test_add() throws InterruptedException {
		webtest.click("xpath=//span[text()='1F']");
		webtest.click("xpath=//span[text()='加入购物车']");
		Thread.sleep(2000);
		boolean flag = webtest.isTextPresent("已成功加入购物车");
		assertEquals(flag, true);
	}
	//2-点击商品加入购物车
	@Test
	public void test_add_byclick() throws InterruptedException {
		webtest.click("xpath=//span[text()='1F']");
		webtest.click("class=product-img");
		Thread.sleep(2000);
		webtest.click("id=add_cart_submit");
		webtest.click("xpath=//button[contains(text(),'加入购物车')]");
		webtest.click("xpath=//a[contains(text(),'继续购物')]");
		
	}
	
	//3-搜索商品-加入购物车
//	@Test(dataProvider = "data")
	@Test
	public void test_sraech_add() throws InterruptedException, IOException {

		webtest.type("class=search-text", "手机");
		Thread.sleep(2000);
		webtest.submit("class=search-btn");
		Thread.sleep(2000);
		webtest.click("class=item-thumb");
		Thread.sleep(2000);
		webtest.click("xpath=//button[contains(text(),'+')]");
		webtest.click("xpath=//button[contains(text(),'加入购物车')]");
		webtest.click("xpath=//a[contains(text(),'继续购物')]");
		
	}

	//4-收藏商品
	@Test
	public void test_good_collect() throws InterruptedException, IOException {
		webtest.click("xpath=//span[text()='1F']");
		webtest.click("class=product-img");
		Thread.sleep(2000);
		webtest.click("class=goods-collect-btn");
		webtest.click("xpath=//a[contains(text(),'关闭')]");
	}
	
	//5-商品咨询
	@Test
	public void test_good_ask() throws InterruptedException, IOException {

		webtest.click("xpath=//span[text()='1F']");
		webtest.click("class=product-img");
		Thread.sleep(2000);
		webtest.runJs("window.scrollBy(0,500)");
		Thread.sleep(2000);
		webtest.click("xpath=//a[contains(text(),'商品咨询')]");
		webtest.type("id=goods_ask_content", "为什么为什么");
		webtest.click("xpath=//button[contains(text(),'提交咨询')]");
		boolean flag = webtest.isTextPresent("OK");
		assertEquals(flag, true);
	}
	
	//6-购物车-去结算
	@Test
	public void test_buy() {
		webtest.click("id=J_miniCart");
		webtest.click("xpath=//a[text()='去结算']");
		webtest.runJs("window.scrollBy(0,300)");
		webtest.click("class=btn-large");
		webtest.runJs("window.scrollBy(0,700)");
		webtest.click("class=btn-large");
		webtest.click("class=btn-primary");
		boolean flag = webtest.isTextPresent("支付完成");
		assertEquals(flag, true);
	}
	
	

}
