package com.webtest.demo;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
public class Admin_ShopManagement_Edit extends BaseTest{

	@BeforeClass
	public void admin() {
		webtest.open("http://localhost:86/admin/home");
		webtest.type("name=user_name", "admin");
		webtest.type("name=user_passwd", "123456");
		webtest.click("xpath=//button[contains(text(),'后台登录')]");
	}
	
	@DataProvider(name="testData6")
    public Object[][] data3() throws IOException{
		ExcelDataProvider excel = new ExcelDataProvider();
    	return excel.getTestDataByExcel("data\\da.xlsx","edit1");
    }
	@DataProvider(name="testData15")
    public Object[][] data12() throws IOException{
		ExcelDataProvider excel = new ExcelDataProvider();
    	return excel.getTestDataByExcel("data\\da.xlsx","test44");
    }
	@DataProvider(name="testData10")
    public Object[][] data7() throws IOException{
		ExcelDataProvider excel = new ExcelDataProvider();
    	return excel.getTestDataByExcel("data\\da.xlsx","test26");
    }
	@DataProvider(name="testData11")
    public Object[][] data8() throws IOException{
		ExcelDataProvider excel = new ExcelDataProvider();
    	return excel.getTestDataByExcel("data\\da.xlsx","test29");
    }
	@DataProvider(name="testData12")
    public Object[][] data9() throws IOException{
		ExcelDataProvider excel = new ExcelDataProvider();
    	return excel.getTestDataByExcel("data\\da.xlsx","test32");
    }
	@DataProvider(name="testData13")
    public Object[][] data10() throws IOException{	    	
		ExcelDataProvider excel = new ExcelDataProvider();
    	return excel.getTestDataByExcel("data\\da.xlsx","conten");
	}
	    	
	//35，编辑标签组
	@Test
	public void test35() throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'商品标签')]");
		webtest.click("link=商品标签分组");
		webtest.click("xpath=//a[contains(text(),'编辑')]");
		webtest.mouseToElementandClick("xpath=//a[contains(text(),'组内标签')]");
		webtest.click("xpath=//button[contains(@onclick,'tag_group_save_type')]");	
		
	}
	//36,编辑属性分组
	@Test(dataProvider = "testData10")
	public void test36(String attribute_group_name,String attribute_group_sort) throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'商品属性')]");
		webtest.click("link=属性分组");
		webtest.click("xpath=//a[contains(text(),'编辑')]");
		webtest.typeAndClear("name=attribute_group_name", attribute_group_name);
		webtest.typeAndClear("name=attribute_group_sort",attribute_group_sort);
		webtest.click("xpath=//button[contains(text(),'保存属性组信息')]");
		
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'添加属性组')]");
		assertTrue(flag);
	}
	
	//37,编辑普通商品标签
	@Test(dataProvider = "testData15")
	public void test37(String goods) throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'商品标签')]");
		webtest.click("link=普通商品标签");
		webtest.click("xpath=//a[contains(text(),'编辑')]");	
		webtest.click("xpath=//a[contains(@href,'tag_b')]");
		webtest.typeAndClear("id=tag_goods_keyword",goods);
		webtest.click("xpath=//button[contains(text(),'点击添加标签商品')]");
		webtest.click("xpath=//button[contains(text(),'保存标签信息')]");
		
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'添加普通商品标签')]");
		assertTrue(flag);
		
	}
	//38,编辑商品标签内商品
	@Test(dataProvider = "testData15")
	public void test38(String tag_goods_keyword) throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'商品标签')]");
		webtest.click("link=特定商品标签");
		webtest.click("xpath=//a[contains(text(),'编辑')]");	
		webtest.click("xpath=//a[contains(@href,'tag_b')]");
		webtest.typeAndClear("id=tag_goods_keyword", tag_goods_keyword);
		webtest.click("xpath=//button[contains(text(),'点击添加标签商品')]");
		webtest.click("xpath=//button[contains(text(),'保存标签信息')]");
		
		boolean flag=webtest.isDisplayed("xpath=//a[contains(@href,'/admin/goods/tag/addSpecTag')]");
		assertTrue(flag);
	}
	
	//39,编辑普通商品标签
	@Test
	public void test39() throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'商品标签')]");
		webtest.click("link=普通商品标签");
		webtest.click("xpath=//a[contains(text(),'编辑')]");	
		webtest.click("xpath=//a[contains(@href,'tag_b')]");
		webtest.click("xpath=//a[contains(text(),'删除标签')]");
		webtest.getAlert();
		webtest.alertAccept();
		Thread.sleep(3000);
		
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'添加普通商品标签')]");
		assertTrue(flag);
		
	}
	
	//40,编辑商品品牌
	@Test(dataProvider = "testData12")
	public void test40(String brand_title_extend,String brand_keywords,String brand_description){
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
		webtest.click("xpath=//a[contains(text(),'商品品牌')]");
		webtest.click("xpath=//a[contains(text(),'编辑')]");	
		webtest.click("xpath=//a[contains(text(),'搜索引擎优化')]");	
		webtest.type("id=brand_title_extend", brand_title_extend);
		webtest.type("id=brand_keywords", brand_keywords);
		webtest.type("id=brand_description", brand_description);
		webtest.click("xpath=(//button[contains(text(),'保存品牌')])[2]");
		
		boolean flag=webtest.isDisplayed("xpath=//a[contains(@href,'/admin/goods/brand/add')]");
		assertTrue(flag);
	}
	
	
	//41,编辑属性
	@Test(dataProvider = "testData11")
	public void test41(String attribute_group_id,String attribute_name,String frontside_sort) throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'商品属性')]");
		webtest.click("link=属性");
		webtest.click("xpath=//a[contains(text(),'编辑')]");	
		int Num=Integer.parseInt(attribute_group_id);
		webtest.selectByIndex("id=attribute_group_id", Num);
		webtest.typeAndClear("name=attribute_name", attribute_name);
		webtest.typeAndClear("name=frontside_sort",frontside_sort);
		webtest.click("xpath=//button[contains(text(),'保存属性信息')]");	
		
		boolean flag=webtest.isDisplayed("xpath=//a[contains(@href,'/admin/goods/attribute/add')]");
		assertTrue(flag);
		
	}
	
	//42，编辑商品信息
	@Test(dataProvider = "testData6")
	public void test42(String name,String item) {
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
		webtest.click("xpath=//a[contains(text(),'管理商品')]");
		webtest.click("xpath=//a[contains(text(),'编辑')]");
		webtest.typeAndClear("name=goods_name", name);
		webtest.typeAndClear("name=goods_item", item);
		webtest.click("xpath=(//button[contains(@onclick,'goods_save_type')])[2]");
		
		boolean flag=webtest.isDisplayed("xpath=//a[contains(@href,'add')]");
		assertTrue(flag);
	}
	
	//43,编辑查看回复商品评价
	@Test(dataProvider = "testData13")
	public void test43(String content) {
		admin();
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
		webtest.click("xpath=//a[contains(text(),'商品评价')]");
		webtest.click("xpath=//a[contains(text(),'编辑查看')]");	
		webtest.click("xpath=//a[contains(text(),'评价回复')]");	
		webtest.type("id=reply_comment_content", content);
		webtest.click("xpath=//button[contains(text(),'回复商品评价')]");
		
		boolean flag=webtest.isDisplayed("xpath=//*[contains(text(),'回复内容：')]");
		assertTrue(flag);
	}
	
}
