package com.webtest.demo;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

/**
 * 
 * 后台：销售管理
 * @author 胡淑玉
 *
 */
public class Admin_SaleManagement extends BaseTest {
	@BeforeClass
	public void login() throws InterruptedException {
		webtest.open("http://localhost:86/admin");
		webtest.type("name=user_name", "admin");
		webtest.type("name=user_passwd", "123456");
		Thread.sleep(2000);
		webtest.click("class=btn");
		Thread.sleep(2000);
	}

	// 1-订单管理-将待付款的订单改为已付款
	@Test
	public void test_gopay_pay() throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'销售管理')]");
		webtest.click("xpath=//a[contains(text(),'订单管理')]");
		webtest.click("id=order_state");
		webtest.click("xpath=//option[contains(text(),'待付款')]");
		Thread.sleep(3000);
		webtest.click("xpath=//button[1]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'编辑查看')]");
		webtest.click("xpath=//a[contains(text(),'付款操作')]");
		webtest.click("class=span2");
		webtest.click("xpath=//option[contains(text(),'已付款')]");
		Thread.sleep(2000);
		webtest.click("xpath=//button[contains(text(),'提交保存')]");
		webtest.click("xpath=//a[contains(text(),'返回订单列表')]");
		Thread.sleep(2000);
		boolean flag = webtest.isTextPresent("已付款");
		assertEquals(flag, true);
	}

	// 2-订单管理-将付款中的订单改为已付款
	@Test
	public void test_paying_pay() throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'销售管理')]");
		webtest.click("xpath=//a[contains(text(),'订单管理')]");
		webtest.click("id=order_state");
		webtest.click("xpath=//option[contains(text(),'付款中')]");
		Thread.sleep(3000);
		webtest.click("xpath=//button[1]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'编辑查看')]");
		webtest.click("xpath=//a[contains(text(),'付款操作')]");
		webtest.click("class=span2");
		webtest.click("xpath=//option[contains(text(),'已付款')]");
		Thread.sleep(2000);
		webtest.click("xpath=//button[contains(text(),'提交保存')]");
		webtest.click("xpath=//a[contains(text(),'返回订单列表')]");
		Thread.sleep(2000);
		boolean flag = webtest.isTextPresent("已付款");
		assertEquals(flag, true);
	}

	// 3-订单管理-对已付款做退款处理
	@Test
	public void test_refund() throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'销售管理')]");
		webtest.click("xpath=//a[contains(text(),'订单管理')]");
		webtest.click("id=order_state");
		webtest.click("xpath=//option[contains(text(),'已付款')]");
		Thread.sleep(3000);
		webtest.click("xpath=//button[1]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'编辑查看')]");
		webtest.click("xpath=//a[contains(text(),'退款处理')]");
		webtest.type("id=state_info", "退款");
		webtest.click("xpath=//button[contains(text(),'提交保存')]");
		webtest.click("xpath=//a[contains(text(),'返回订单列表')]");
		Thread.sleep(2000);
		boolean flag = webtest.isTextPresent("已取消");
		assertEquals(flag, true);
	}

	// 4-订单管理-已付款的做发货操作
	@Test
	public void test_deliver() throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'销售管理')]");
		webtest.click("xpath=//a[contains(text(),'订单管理')]");
		webtest.click("id=order_state");
		webtest.click("xpath=//option[contains(text(),'已付款')]");
		Thread.sleep(3000);
		webtest.click("xpath=//button[1]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'编辑查看')]");
		webtest.click("xpath=//a[contains(text(),'发货操作')]");
		webtest.type("id=express_number", "125863302211");
		webtest.type("id=state_info", "发货");
		webtest.click("xpath=//button[contains(text(),'点击发货')]");
		webtest.click("xpath=//a[contains(text(),'返回订单列表')]");
	}

	// 5-订单管理-对已发货的做退货退款
	@Test
	public void test_back() throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'销售管理')]");
		webtest.click("xpath=//a[contains(text(),'订单管理')]");
		webtest.click("id=order_state");
		webtest.click("xpath=//option[contains(text(),'已发货')]");
		Thread.sleep(3000);
		webtest.click("xpath=//button[1]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'编辑查看')]");
		webtest.click("xpath=//a[contains(text(),'退货退款')]");
		webtest.type("id=state_info", "退货退款");
		webtest.click("xpath=//button[contains(text(),'提交保存')]");
		webtest.click("xpath=//a[contains(text(),'返回订单列表')]");
	}

	// 6-订单管理-对已发货的做完成订单
	@Test
	public void test_finish() throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'销售管理')]");
		webtest.click("xpath=//a[contains(text(),'订单管理')]");
		webtest.click("id=order_state");
		webtest.click("xpath=//option[contains(text(),'已发货')]");
		Thread.sleep(3000);
		webtest.click("xpath=//button[1]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'编辑查看')]");
		webtest.click("xpath=//a[contains(text(),'完成订单')]");
		webtest.type("id=state_info", "完成订单");
		webtest.click("xpath=//button[contains(text(),'点击完成订单')]");
		webtest.click("xpath=//a[contains(text(),'返回订单列表')]");
	}

	// 7-订单管理-删除已取消的订单
	@Test
	public void test_delete1() throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'销售管理')]");
		webtest.click("xpath=//a[contains(text(),'订单管理')]");
		webtest.click("id=order_state");
		webtest.click("xpath=//option[contains(text(),'已取消')]");
		Thread.sleep(2000);
		webtest.click("xpath=//button[1]");
		Thread.sleep(2000);
		webtest.click("xpath=//a[contains(text(),'编辑查看')]");
		Thread.sleep(1000);
		webtest.click("xpath=//a[contains(text(),'删除订单')]");
		webtest.alertAccept();

	}

	// 8-订单管理-编辑查看-订单打印（跳转到另一个界面，待解决）
	@Test
	public void test_print() {
		webtest.click("xpath=//a[contains(text(),'销售管理')]");
		webtest.click("xpath=//a[contains(text(),'订单管理')]");
		webtest.click("xpath=//a[contains(text(),'打印订单')]");
		webtest.switchWidow(2);
		webtest.click("id=print_button");

	}

	// 9-订单管理-根据订单号搜索
	@Test
	public void test_search_byno() throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'销售管理')]");
		webtest.click("xpath=//a[contains(text(),'订单管理')]");
		webtest.type("name=order_sn", "1606090905300001");
		Thread.sleep(2000);
		webtest.click("xpath=//button[1]");
		Thread.sleep(2000);
		boolean flag = webtest.isTextPresent("18");
		assertEquals(flag, false);
	}

	// 10-订单管理-根据购买人搜索
	@Test
	public void test_search_by_buyer() throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'销售管理')]");
		webtest.click("xpath=//a[contains(text(),'订单管理')]");
		webtest.type("name=buyer_name", "admin1");
		Thread.sleep(2000);
		webtest.click("xpath=//button[1]");
		Thread.sleep(2000);
		boolean flag = webtest.isTextPresent("18");
		assertEquals(flag, false);
	}

	// 11-订单管理-根据收货人搜索
	@Test
	public void test_search_by_delivery() throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'销售管理')]");
		webtest.click("xpath=//a[contains(text(),'订单管理')]");
		webtest.type("name=delivery_name", "admin2");
		Thread.sleep(2000);
		webtest.click("xpath=//button[1]");
		Thread.sleep(2000);
		boolean flag = webtest.isTextPresent("18");
		assertEquals(flag, false);
	}
	// 12-订单管理-根据订单状态搜索

	// 13-订单管理-根据支付方式搜索（多个支付方式）
	@Test
	public void test_search_by_pay_code() throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'销售管理')]");
		webtest.click("xpath=//a[contains(text(),'订单管理')]");
		webtest.click("name=pay_code");
		Thread.sleep(2000);
		webtest.click("xpath=//option[contains(text(),'支付宝支付')]");
		Thread.sleep(2000);
		webtest.click("xpath=//button[1]");
		Thread.sleep(2000);
		boolean flag = webtest.isTextPresent("微信支付");
		assertEquals(flag, false);
	}

	// 14-订单管理-根据订单总额搜索
	@Test
	public void test_search_by_price() throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'销售管理')]");
		webtest.click("xpath=//a[contains(text(),'订单管理')]");
		webtest.type("id=order_start_price", "222");
		webtest.type("id=order_end_price", "111111");
		Thread.sleep(2000);
		webtest.click("xpath=//button[1]");
		Thread.sleep(2000);
		boolean flag = webtest.isTextPresent("31904");
		assertEquals(flag, true);
	}

	// 15-订单管理-根据下单时间搜索
	@Test
	public void test_search_by_time() throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'销售管理')]");
		webtest.click("xpath=//a[contains(text(),'订单管理')]");
		webtest.type("id=search_start_time", "2020-11-02 09:00:00");
		webtest.type("id=search_end_time", "2020-11-26 18:00:00");
		Thread.sleep(2000);
		webtest.click("xpath=//button[1]");
		Thread.sleep(2000);
		boolean flag = webtest.isTextPresent("31904");
		assertEquals(flag, true);
	}

	// 16-订单管理-高级搜索
	@Test
	public void test_search_detail() throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'销售管理')]");
		webtest.click("xpath=//a[contains(text(),'订单管理')]");
		webtest.click("xpath=//button[2]");
		
		webtest.click("xpath=(//input[@name=order_state])[last()]");
//		webtest.type("name=(order_sn)[last()]");
//		webtest.type("name=order_start_price", "2");
//		webtest.type("name=order_end_price", "3");
//		webtest.type("id=search_start_time", "2020-11-02 09:00:00");
//		webtest.type("id=search_end_time", "2020-11-26 18:00:00");

	}

	// 17-订单管理-多选删除操作
	@Test
	public void test_delete_more() throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'销售管理')]");
		webtest.click("xpath=//a[contains(text(),'订单管理')]");
		webtest.click("id=order_state");
		webtest.click("xpath=//option[contains(text(),'已取消')]");
		Thread.sleep(2000);
		webtest.click("xpath=//button[1]");
		Thread.sleep(2000);
		webtest.click("name=order_id[]");
		webtest.click("id=allEdit");
		webtest.click("xpath=//option[contains(text(),'删除')]");
		webtest.click("xpath=//button[contains(text(),'提交操作')]");
		webtest.alertAccept();
	}

	// 18-发货单-导出Excel文件
	@Test
	public void test_pull() throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'销售管理')]");
		webtest.click("xpath=//a[contains(text(),'发货单')]");
		webtest.click("xpath=//a[contains(text(),'导出发货单')]");
		webtest.type("id=export_start_time", "2020-11-18");
		webtest.type("id=export_end_time", "2020-11-26");

		webtest.click("id=express_id");
		webtest.click("xpath=//option[contains(text(),'顺丰速运')]");
		webtest.click("id=order_ship_state");
		webtest.click("xpath=//option[contains(text(),'已发货')]");

		webtest.submit("xpath=//button[1]");
		Thread.sleep(2000);
//		webtest.alertAccept();
	}

	// 19-退货管理-根据订单编号搜索
	@Test
	public void test_by_no() throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'销售管理')]");
		webtest.click("xpath=//a[contains(text(),'退货管理')]");
		webtest.type("name=order_sn", "1606090905300001");

		webtest.click("xpath=//button[1]");
		Thread.sleep(2000);
		boolean flag = webtest.isTextPresent("返回");
		assertEquals(flag, true);
	}

	// 20-退货管理-根据退款方式搜索
	@Test
	public void test_by_refund_type() throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'销售管理')]");
		webtest.click("xpath=//a[contains(text(),'退货管理')]");
		webtest.click("name=refund_type");
		webtest.click("xpath=//option[contains(text(),'退款到账户余额')]");
		Thread.sleep(2000);
		webtest.click("xpath=//button[1]");
		Thread.sleep(2000);
		boolean flag = webtest.isTextPresent("返回");
		assertEquals(flag, true);
	}

	// 21-退货管理-根据处理状态搜索
	@Test
	public void test_by_refund_state() throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'销售管理')]");
		webtest.click("xpath=//a[contains(text(),'退货管理')]");
		webtest.click("name=refund_state");
		webtest.click("xpath=//option[contains(text(),'等待处理')]");
		Thread.sleep(2000);
		webtest.click("xpath=//button[1]");
		Thread.sleep(2000);
		boolean flag = webtest.isTextPresent("返回");
		assertEquals(flag, true);
	}

	// 22-退货管理-根据申请时间搜索
	@Test
	public void test_by_refund_time() throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'销售管理')]");
		webtest.click("xpath=//a[contains(text(),'退货管理')]");
		webtest.type("id=start_refund_time", "2020-11-19");
		webtest.type("id=end_refund_time", "2020-11-23");
		Thread.sleep(2000);
		webtest.click("xpath=//button[1]");
		Thread.sleep(2000);
		boolean flag = webtest.isTextPresent("返回");
		assertEquals(flag, true);
	}

	// 23-退货管理-根据处理时间搜索
	@Test
	public void test_by_finish_refund_time() throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'销售管理')]");
		webtest.click("xpath=//a[contains(text(),'退货管理')]");
		webtest.type("id=start_finish_refund_time", "2020-11-19");
		webtest.type("id=end_finish_refund_time", "2020-11-23");
		Thread.sleep(2000);
		webtest.click("xpath=//button[1]");
		Thread.sleep(2000);
		boolean flag = webtest.isTextPresent("返回");
		assertEquals(flag, true);
	}

	// 24-退货管理-处理退货
	@Test
	public void test_refund_finish() throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'销售管理')]");
		webtest.click("xpath=//a[contains(text(),'退货管理')]");
		webtest.click("xpath=//a[contains(text(),'处理退货')]");
		Thread.sleep(2000);
		webtest.type("id=refund_price", "222");
		webtest.type("id=re_refund_info", "同意");
		webtest.click("xpath=//button[contains(text(),'提交处理结果')]");

	}
}
