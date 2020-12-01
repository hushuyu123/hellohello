package com.webtest.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NSDataProvider {

	// 基本设置
	@DataProvider(name = "base1")
	public Object[][] base1() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("data/DBShop.xlsx", "base1");
	}

	@DataProvider(name = "base2")
	public Object[][] base2() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("data/DBShop.xlsx", "base2");
	}

	@DataProvider(name = "base3")
	public Object[][] base3() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("data/DBShop.xlsx", "base3");
	}

	@DataProvider(name = "base4")
	public Object[][] base4() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("data/DBShop.xlsx", "base4");
	}

	@DataProvider(name = "base5")
	public Object[][] base5() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("data/DBShop.xlsx", "base5");
	}

	@DataProvider(name = "base6")
	public Object[][] base6() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("data/DBShop.xlsx", "base6");
	}
	// 客户设置

	@DataProvider(name = "user")
	public Object[][] user() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("data/DBShop.xlsx", "user");
	}

	// 货币设置
	@DataProvider(name = "money1")
	public Object[][] money1() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("data/DBShop.xlsx", "money1");
	}

	@DataProvider(name = "money2")
	public Object[][] money2() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("data/DBShop.xlsx", "money2");
	}

	@DataProvider(name = "money3")
	public Object[][] money3() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("data/DBShop.xlsx", "money3");
	}

	@DataProvider(name = "money4")
	public Object[][] money4() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("data/DBShop.xlsx", "money4");
	}
	// 支付设置

	@DataProvider(name = "pay1")
	public Object[][] pay1() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("data/DBShop.xlsx", "pay1");
	}

	@DataProvider(name = "pay2")
	public Object[][] pay2() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("data/DBShop.xlsx", "pay2");
	}

	// 配送设置
	@DataProvider(name = "delivery")
	public Object[][] delivery() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("data/DBShop.xlsx", "delivery");
	}

	// 消息设置
	@DataProvider(name = "message1")
	public Object[][] message1() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("data/DBShop.xlsx", "message1");
	}

	@DataProvider(name = "message2")
	public Object[][] message2() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("data/DBShop.xlsx", "message2");
	}

	@DataProvider(name = "message3")
	public Object[][] message3() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("data/DBShop.xlsx", "message3");
	}

	// 地区设置
	@DataProvider(name = "area1")
	public Object[][] area1() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("data/DBShop.xlsx", "area1");
	}

	@DataProvider(name = "area2")
	public Object[][] area2() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("data/DBShop.xlsx", "area2");
	}

	// 库存状态
	@DataProvider(name = "stock1")
	public Object[][] stock1() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("data/DBShop.xlsx", "stock1");
	}

	@DataProvider(name = "stock2")
	public Object[][] stock2() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("data/DBShop.xlsx", "stock2");
	}

	// 管理员设置
	@DataProvider(name = "admin1")
	public Object[][] admin1() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("data/DBShop.xlsx", "admin1");
	}

	@DataProvider(name = "admin2")
	public Object[][] admin2() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("data/DBShop.xlsx", "admin2");
	}

	@DataProvider(name = "admin3")
	public Object[][] admin3() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("data/DBShop.xlsx", "admin3");
	}

	// 客服设置
	@DataProvider(name = "service1")
	public Object[][] getExcelDada() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("data/DBShop.xlsx", "service1");
	}

	@DataProvider(name = "service2")
	public Object[][] getExcelDada2() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("data/DBShop.xlsx", "service2");
	}

	@DataProvider(name = "service3")
	public Object[][] getExcelDada3() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("data/DBShop.xlsx", "service3");
	}

//		@DataProvider(name="mysql")
//		public Object[][] getMysqlDada() throws IOException{
//			return new MysqlDataProvider().getTestDataByMysql("SELECT filmname, petname\r\n" + 
//					"FROM `mm_movie` ");
//		}

	@Test(dataProvider = "service1")
	public void testDB(String a, String b, String c) {
		System.out.println(a + " " + b + " " + c);
	}

}
