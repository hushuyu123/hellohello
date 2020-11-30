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
 * 前台：用户中心
 * 
 * @author 胡淑玉
 *
 */
public class Admin_Front_UserCenter extends BaseTest {
	@BeforeClass
	public void login() throws InterruptedException {
		webtest.open("http://localhost:86/user/login");
		webtest.type("name=user_name", "admin2");
		webtest.type("name=user_password", "admin2");
		webtest.type("name=captcha_code", "11111");
		Thread.sleep(2000);
		webtest.click("xpath=//button[contains(text(),'会员登录')]");
		Thread.sleep(2000);
		webtest.click("xpath=//a[contains(text(),'用户中心')]");
	}

	@DataProvider(name = "newaddress")
	public Object[][] new_address() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\data.xlsx", "Sheet1");
	}

	@DataProvider(name = "updateaddress")
	public Object[][] update_address() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\data.xlsx", "Sheet2");
	}

	@DataProvider(name = "updateinfo")
	public Object[][] data_info() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\data.xlsx", "Sheet4");
	}

	@DataProvider(name = "updatepwd")
	public Object[][] data_pwd() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\data.xlsx", "Sheet3");
	}
	@DataProvider(name = "shopback")
	public Object[][] shop_back() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\data.xlsx", "Sheet5");
	}

	// 1-我的订单-有效订单-立即付款
	@Test
	public void test_pay() throws InterruptedException {
		webtest.click("xpath=//a[text()='我的订单']");
		webtest.click("xpath=//button[text()='立即付款']");
		Thread.sleep(2000);
		webtest.click("xpath=//button[text()='点击支付']");
		webtest.click("name=payment_code");
		webtest.type("id=state_info", "infooooooooooooooooo");
		webtest.click("xpath=//button[contains(text(),'提交支付凭证')]");
		boolean flag = webtest.isTextPresent("支付凭证提交完成，等待管理员审核");
		assertEquals(flag, true);
	}

	// 2-我的订单-有效订单-再次购买
	@Test
	public void test_buy_again1() {
		webtest.click("xpath=//a[text()='我的订单']");
		webtest.click("xpath=//button[text()='再次购买']");
		webtest.click("xpath=//a[text()='关闭']");
	}

	// 3-我的订单-有效订单-取消订单
	@Test
	public void test_cancel() throws InterruptedException {
		webtest.click("xpath=//a[text()='我的订单']");
		webtest.click("xpath=//button[text()='取消订单']");
		Thread.sleep(2000);
		webtest.alertAccept();
		boolean flag = webtest.isTextPresent("暂时无订单！");
		assertEquals(flag, true);
	}

	// 4-我的订单-付款中-再次购买
	@Test
	public void test_buy_again2() {
		webtest.click("xpath=//a[text()='我的订单']");
		webtest.click("xpath=//a[text()='付款中']");
		webtest.click("xpath=//button[text()='再次购买']");
		webtest.click("xpath=//a[text()='关闭']");

	}

	// 5-我的订单-已付款-再次购买
	@Test
	public void test_buy_again3() {
		webtest.click("xpath=//a[text()='我的订单']");
		webtest.click("xpath=//a[text()='已付款']");
		webtest.click("xpath=//button[text()='再次购买']");
		webtest.click("xpath=//a[text()='关闭']");
	}

	// 6-我的订单-未发货-取消订单
	@Test
	public void test_cancel2() throws InterruptedException {
		webtest.click("xpath=//a[text()='我的订单']");
		webtest.click("xpath=//a[text()='未发货']");
		webtest.click("xpath=//button[text()='取消订单']");
		Thread.sleep(2000);
		webtest.alertAccept();
		Thread.sleep(2000);
		boolean flag = webtest.isTextPresent("暂时无订单");
		assertEquals(flag, true);
	}

	// 7-我的订单-未发货-再次购买
	@Test
	public void test_buy_again4() {
		webtest.click("xpath=//a[text()='我的订单']");
		webtest.click("xpath=//a[text()='未发货']");
		webtest.click("xpath=//button[text()='再次购买']");
		webtest.click("xpath=//a[text()='关闭']");
	}

	// 8-我的订单-已发货-确认收货
	@Test
	public void test_ok() throws InterruptedException {
		webtest.click("xpath=//a[text()='我的订单']");
		webtest.click("xpath=//a[text()='已发货']");
		webtest.click("xpath=//button[text()='确认收货']");
		Thread.sleep(2000);
		webtest.runJs("window.scrollBy(0,700)");
		Thread.sleep(2000);
		webtest.click("xpath=//button[contains(text(),'确认收货')]");
		webtest.alertAccept();
	}

	// 8-我的订单-已发货-再次购买
	@Test
	public void test_buy_again5() {
		webtest.click("xpath=//a[text()='我的订单']");
		webtest.click("xpath=//a[text()='已发货']");
		webtest.click("xpath=//button[text()='再次购买']");
		webtest.click("xpath=//a[text()='关闭']");
	}

	// 9-我的订单-交易完成-再次购买
	@Test
	public void test_buy_again6() {
		webtest.click("xpath=//a[text()='我的订单']");
		webtest.click("xpath=//a[text()='交易完成']");
		webtest.click("xpath=//button[text()='再次购买']");
		webtest.click("xpath=//a[text()='关闭']");
	}

	// 10-我的订单-交易完成-评价
	@Test
	public void test_pingjia() throws InterruptedException {
		webtest.click("xpath=//a[text()='我的订单']");
		webtest.click("xpath=//a[text()='交易完成']");
		webtest.click("xpath=//a[contains(text(),'尚未评价')]");
		Thread.sleep(2000);
		webtest.click("name=goods_evaluation");
		webtest.type("id=comment_body", "不错");
		webtest.click("xpath=//button[contains(text(),'点击提交')]");
	}

	// 11-我的订单-退货订单-删除订单
	@Test
	public void test_delete1() throws InterruptedException {
		webtest.click("xpath=//a[text()='我的订单']");
		webtest.click("xpath=//a[text()='退货订单']");
		webtest.click("xpath=//button[contains(text(),'删除订单')]");
		Thread.sleep(2000);
		webtest.alertAccept();
	}

	// 12-我的订单-退货订单-再次购买
	@Test
	public void test_buy_again7() {
		webtest.click("xpath=//a[text()='我的订单']");
		webtest.click("xpath=//a[text()='退货订单']");
		webtest.click("xpath=//button[text()='再次购买']");
		webtest.click("xpath=//a[text()='关闭']");
	}

	// 13-我的订单-无效订单-删除订单
	@Test
	public void test_delete2() throws InterruptedException {
		webtest.click("xpath=//a[text()='我的订单']");
		webtest.click("xpath=//a[text()='无效订单']");
		webtest.click("xpath=//button[contains(text(),'删除订单')]");
		Thread.sleep(2000);
		webtest.alertAccept();
	}

	// 14-我的订单-无效订单-再次购买
	@Test
	public void test_buy_again8() {
		webtest.click("xpath=//a[text()='我的订单']");
		webtest.click("xpath=//a[text()='无效订单']");
		webtest.click("xpath=//button[text()='再次购买']");
		webtest.click("xpath=//a[text()='关闭']");
	}

	// 15-我的订单-搜索
	@Test
	public void test_search() {
		webtest.click("xpath=//a[text()='我的订单']");
		webtest.type("name=search_order_sn", "1606032931730001");
		webtest.click("xpath=//button[contains(text(),'搜索')]");
		boolean flag = webtest.isTextPresent("南极人(NanJiren)家纺 简约全棉四件套床上用品纯棉斜纹双人被套床单式4件套");
		assertEquals(flag, true);

	}

	// 16-我的收藏-删除
	@Test
	public void test_collection_delete() throws InterruptedException {
		webtest.click("xpath=//a[text()='我的收藏']");
		webtest.click("xpath=//a[contains(text(),'删除')]");
		webtest.alertAccept();
		Thread.sleep(2000);
		boolean flag = webtest.isTextPresent("苹果");
		assertEquals(flag, false);
	}

	// 17-我的咨询-删除
	@Test
	public void test_ask() {
		webtest.click("xpath=//a[text()='我的咨询']");
		webtest.click("xpath=//a[contains(text(),'删除')]");
		webtest.alertAccept();
	}

	// 18-账户余额—充值
//	@Test(dataProvider = "account")
	@Test
	public void test1() throws InterruptedException, IOException {
		webtest.click("xpath=//a[text()='账户余额']");
		webtest.click("xpath=//a[text()='充值']");
		// 收货人姓名
		webtest.click("id=payment_code");
		webtest.type("id=pay_change_num", "222");
		Thread.sleep(2000);
		// 提交
		//webtest.click("xpath=//button[contains(text(),'立刻充值')]");
		webtest.click("xpath=//button[contains(text(),'关闭')]");
		Thread.sleep(2000);
	}

	// 19-账户余额—提现
//	@Test(dataProvider = "account")
	@Test
	public void test_draw_money() throws InterruptedException, IOException {
		webtest.click("xpath=//a[text()='账户余额']");
		webtest.click("xpath=//a[text()='提现']");
		// 收货人姓名
		webtest.type("id=money_change_num", "222");
		webtest.type("id=bank_name", "支付宝");
		webtest.type("id=bank_account", "工商银行");
		webtest.type("id=bank_card_number", "8888");
		Thread.sleep(2000);
		// 提交
		webtest.click("xpath=//button[contains(text(),'申请提现')]");
		Thread.sleep(2000);
		webtest.click("xpath=//button[contains(text(),'关闭')]");
		Thread.sleep(2000);
	}

	// 20-账户余额—搜索
	@Test
	public void test_money_search() throws InterruptedException, IOException {
		webtest.click("xpath=//a[text()='账户余额']");
		webtest.type("name=search_content", "退款");
		webtest.click("xpath=//button[contains(text(),'搜索')]");
		Thread.sleep(2000);
		boolean flag = webtest.isTextPresent("1604909731800001");
		assertEquals(flag, true);

	}

	// 21-账户信息—修改账户信息
	@Test(dataProvider = "updateinfo")
	public void test_update_info(String email, String sex, String phone, String birthday) throws InterruptedException {
		webtest.click("xpath=//a[text()='账户信息']");
		// 电子信箱
		webtest.type("id=user_email", email);
		// 电子信箱
		webtest.click("class=span2");
		webtest.click("xpath=//option[contains(text()," + "'" + sex + "'" + ")]");
		// 手机号码
		webtest.type("id=user_phone", phone);
		// 生日
		webtest.type("id=user_birthday", birthday);
		Thread.sleep(2000);
		// 提交
		webtest.click("xpath=//button[contains(text(),'保存修改')]");
	}

	// 22-账户信息-密码修改
	@Test(dataProvider = "updatepwd")
	public void test_update_pwd(String oldpwd, String newpwd, String pwdcon) {
		webtest.click("xpath=//a[text()='账户信息']");
		webtest.click("xpath=//a[text()='密码修改']");
		webtest.type("id=old_user_password", oldpwd);
		webtest.type("id=user_password", newpwd);
		webtest.type("id=user_password_con", pwdcon);
		webtest.click("xpath=//button[contains(text(),'保存修改')]");
		boolean flag = webtest.isTextPresent("会员密码修改成功");
		assertEquals(flag, true);

	}

	// 23-收货地址—添加收货地址
	@Test(dataProvider = "newaddress")
	public void test_add_address(String name, String province, String city, String area, String address, String code,
			String phone, String tel_code, String tel_phone, String tel_ext) throws InterruptedException, IOException {
		webtest.click("xpath=//a[contains(text(),'收货地址')]");
		webtest.click("xpath=//a[contains(text(),'添加收货地址')]");
		// 收货人姓名
		webtest.type("id=true_name", name);
		// 省市区
		webtest.click("id=show_address_area");
		webtest.click("xpath=//option[contains(text()," + "'" + province + "'" + ")]");
		webtest.click("class=db_show_area valid");
		webtest.click("xpath=//option[contains(text()," + "'" + city + "'" + ")]");
		webtest.click("class=db_show_area valid");
		webtest.click("xpath=//option[contains(text()," + "'" + area + "'" + ")]");
		// 街道地址
		webtest.type("id=address", address);
		// 邮政编码
		webtest.type("id=zip_code", code);
		// 手机号码
		webtest.type("id=mod_phone", phone);
		// 电话
		webtest.type("id=tel_area_code", tel_code);
		webtest.type("id=tel_phone", tel_phone);
		webtest.type("id=tel_ext", tel_ext);
		Thread.sleep(2000);
		// 提交
		webtest.click("xpath=//button[contains(text(),'保存修改')]");
		boolean flag = webtest.isTextPresent(name);
		assertEquals(flag, true);
	}

	// 24-收货地址—修改收货地址
	@Test(dataProvider = "updateaddress")
	public void test_update_address(String name, String province, String city, String area, String address, String code,
			String phone, String tel_code, String tel_phone, String tel_ext) throws InterruptedException {

		webtest.click("xpath=//a[contains(text(),'收货地址')]");
		webtest.click("xpath=//a[contains(text(),'修改')]");
		// 收货人姓名
		webtest.type("id=true_name", name);
		// 省市区
		webtest.click("id=show_address_area");
		webtest.click("xpath=//option[contains(text()," + "'" + province + "'" + ")]");
		webtest.click("class=db_show_area valid");
		webtest.click("xpath=//option[contains(text()," + "'" + city + "'" + ")]");
		webtest.click("class=db_show_area valid");
		webtest.click("xpath=//option[contains(text()," + "'" + area + "'" + ")]");
		// 街道地址
		webtest.type("id=address", address);
		// 邮政编码
		webtest.type("id=zip_code", code);
		// 手机号码
		webtest.type("id=mod_phone", phone);
		// 电话
		webtest.type("id=tel_area_code", tel_code);
		webtest.type("id=tel_phone", tel_phone);
		webtest.type("id=tel_ext", tel_ext);
		Thread.sleep(2000);
		// 提交
		webtest.click("xpath=//button[contains(text(),'保存修改')]");
		boolean flag = webtest.isTextPresent("userrrrrrrrrrr");
		assertEquals(flag, true);
	}

	// 25-收货地址—删除收货地址
	@Test
	public void test_delete_address() throws InterruptedException {

		webtest.click("xpath=//a[contains(text(),'收货地址')]");
		webtest.click("xpath=//a[contains(text(),'删除')]");
		Thread.sleep(2000);
		webtest.alertAccept();
		Thread.sleep(2000);
		boolean flag = webtest.isTextPresent("admin2");
		assertEquals(flag, false);
	}

	// 26-退货申请-添加退货申请
	@Test(dataProvider="shopback")
	public void test_back(String no,String text) throws InterruptedException {
		webtest.click("xpath=//a[text()='退货申请']");
		webtest.click("xpath=//a[contains(text(),'点此申请退货')]");
		webtest.type("id=order_sn", no);
		webtest.click("id=search-order");
		webtest.type("id=refund_info", text);
		webtest.click("xpath=//button[contains(text(),'申请退货')]");
		webtest.alertAccept();
		Thread.sleep(2000);
	}

	// 27-退货申请-删除
	@Test
	public void test_delete_back() throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'退货申请')]");
		webtest.click("xpath=//a[contains(text(),'删除')]");
		webtest.alertAccept();
		Thread.sleep(2000);
		boolean flag = webtest.isTextPresent("1604911430460001");
		assertEquals(flag, false);
	}

	// 28-用户退出
	@Test
	public void test_out() {
		webtest.click("xpath=//a[contains(text(),'用户退出')]");
	}

}
