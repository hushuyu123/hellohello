package com.webtest.demo;

import java.io.IOException;
import java.net.URL;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;

public class Admin_ShopManagement_Add extends BaseTest{
	@BeforeClass
	public void admin() {
		webtest.open("http://localhost:86/admin/home");
		webtest.type("name=user_name", "admin");
		webtest.type("name=user_passwd", "123456");
		webtest.click("xpath=//button[contains(text(),'后台登录')]");
	}
	@DataProvider(name="testData4")
    public Object[][] data1() throws IOException{
		ExcelDataProvider excel = new ExcelDataProvider();
    	return excel.getTestDataByExcel("data\\da.xlsx","addgoods");
    }
	@DataProvider(name="testData7")
    public Object[][] data4() throws IOException{
		ExcelDataProvider excel = new ExcelDataProvider();
    	return excel.getTestDataByExcel("data\\da.xlsx","addgoodsort");
    }
	@DataProvider(name="testData8")
    public Object[][] data5() throws IOException{
		ExcelDataProvider excel = new ExcelDataProvider();
    	return excel.getTestDataByExcel("data\\da.xlsx","addgoodsort2");
    }
	@DataProvider(name="testData9")
    public Object[][] data6() throws IOException{
		ExcelDataProvider excel = new ExcelDataProvider();
    	return excel.getTestDataByExcel("data\\da.xlsx","test24");
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
	@DataProvider(name="testData14")
    public Object[][] data11() throws IOException{
		ExcelDataProvider excel = new ExcelDataProvider();
    	return excel.getTestDataByExcel("data\\da.xlsx","test42");
    }
	@DataProvider(name="testData16")
    public Object[][] data13() throws IOException{
		ExcelDataProvider excel = new ExcelDataProvider();
    	return excel.getTestDataByExcel("data\\da.xlsx","goodsmes");
	}
	//13，商品分类中添加商品
	@Test(dataProvider = "testData8")
	public void test13(String goods_name,String goods_item,String goods_price,String goods_shop_price) throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'管理分类')]");
		webtest.click("xpath=//a[contains(text(),'商品分类')]");
		webtest.click("xpath=//a[contains(text(),'商品添加')]");
		//添加
		webtest.type("name=goods_name", goods_name);
		webtest.type("name=goods_item", goods_item);
		webtest.type("name=goods_price", goods_price);
		webtest.type("name=goods_shop_price", goods_shop_price);
		webtest.click("xpath=//button[contains(@onclick,'goods_save_type')]");
		
		boolean flag=webtest.isDisplayed("xpath=//a[contains(@href,'add')]");
		assertTrue(flag);
	}
	

	//14，添加普通商品标签
	@Test(dataProvider = "testData14")
	public void test14(String input1,String input2,String input3) throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'商品标签')]");
		webtest.click("xpath=//a[contains(text(),'普通商品标签')]");
		webtest.click("xpath=//a[contains(@href,'/admin/goods/tag/add')]");
		int Num=Integer.parseInt(input1);
		webtest.selectByIndex("id=tag_group_id", Num);
		webtest.typeAndClear("id=tag_name", input2);
		webtest.typeAndClear("id=tag_sort",input3);
		webtest.click("xpath=//button[contains(text(),'保存标签信息')]");	
		
		boolean flag=webtest.isDisplayed("xpath=//a[contains(@href,'/admin/goods/tag/add')]");
		assertTrue(flag);
	}
	//15，添加属性
	@Test(dataProvider = "testData11")
	public void test15(String attribute_group_id,String attribute_name,String frontside_sort) throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'商品属性')]");
		webtest.click("xpath=//a[contains(@href,'/admin/goods/attribute')]");
		webtest.click("xpath=//a[contains(@href,'/admin/goods/attribute/add')]");
		int Num=Integer.parseInt(attribute_group_id);
		webtest.selectByIndex("id=attribute_group_id",Num);
		webtest.typeAndClear("name=attribute_name", attribute_name);
		webtest.typeAndClear("name=frontside_sort",frontside_sort);
		webtest.click("xpath=//button[contains(text(),'保存属性信息')]");
		
		boolean flag=webtest.isDisplayed("xpath=//a[contains(@href,'/admin/goods/attribute/add')]");
		assertTrue(flag);
	}
		
	
	
    
	//16,添加商品分类
	@Test(dataProvider = "testData7")
	public void test16(String class_name,String class_sort) throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'管理分类')]");
		webtest.click("xpath=//a[contains(text(),'商品分类')]");
		webtest.click("xpath=//a[contains(@href,'/admin/goods/class/add')]");
		webtest.type("id=class_name", class_name);
		webtest.typeAndClear("name=class_sort",class_sort);
		webtest.click("xpath=//button[contains(@onclick,'class_save_type')]");	
		
		boolean flag=webtest.isDisplayed("xpath=//a[contains(@href,'/admin/goods/class/add')]");
		assertTrue(flag);
	}
	
	//17,添加商品属性分组
	@Test(dataProvider = "testData10")
	public void test17(String attribute_group_name,String attribute_group_sort) throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'商品属性')]");
		webtest.click("xpath=//a[contains(text(),'属性分组')]");
		webtest.click("xpath=//a[contains(text(),'添加属性组')]");
		webtest.typeAndClear("name=attribute_group_name", attribute_group_name);
		webtest.typeAndClear("name=attribute_group_sort",attribute_group_sort);
		webtest.click("xpath=//button[contains(text(),'保存属性组信息')]");	

		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'添加属性组')]");
		assertTrue(flag);
	}
	
	//18，添加前台侧边设置
	@Test(dataProvider = "testData9")
	public void test18(String frontside_name,String frontside_sort) throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'管理分类')]");
		webtest.click("xpath=//a[contains(text(),'前台侧边设置')]");
		webtest.click("xpath=//a[contains(@href,'/admin/goods/class/addFrontSide')]");
		webtest.typeAndClear("name=frontside_name", frontside_name);
		webtest.typeAndClear("name=frontside_sort",frontside_sort);
		webtest.click("xpath=//button[contains(text(),'保存侧边显示信息')]");
		
		boolean flag=webtest.isDisplayed("xpath=//a[contains(@href,'/admin/goods/class/addFrontSide')]");
		assertTrue(flag);
	}
	
	//19,商品品牌添加
	@Test(dataProvider = "testData12",priority = 13)
	public void test19(String brand_name,String class_sort,String input) {
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
		webtest.click("xpath=//a[contains(text(),'商品品牌')]");
		webtest.click("xpath=//a[contains(@href,'/admin/goods/brand/add')]");
		webtest.typeAndClear("id=brand_name", brand_name);
		webtest.typeAndClear("id=class_sort",class_sort);
		webtest.runJs("document.querySelector('#ueditor_0').contentDocument.querySelector('body').innerHTML='<h3>"+input+"</h3>'");
		webtest.leaveFrame();
		webtest.click("xpath=//button[contains(text(),'保存品牌')]");	
		
		boolean flag=webtest.isDisplayed("xpath=//a[contains(@href,'/admin/goods/brand/add')]");
		assertTrue(flag);
	}
	
	//22,添加特定商品信息	
	@Test(dataProvider = "testData16")
	public void test22(String input1,String input2) throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'商品标签')]");
		webtest.click("xpath=//a[contains(text(),'特定商品标签')]");
		webtest.click("xpath=//a[contains(@href,'/admin/goods/tag/addSpecTag')]");
		int Num=Integer.parseInt(input1);
		webtest.selectByIndex("id=tag_type", Num);
		webtest.typeAndClear("id=tag_name", input2);
		webtest.click("xpath=//button[contains(text(),'保存标签信息')]");
		
		boolean flag=webtest.isDisplayed("xpath=//a[contains(@href,'/admin/goods/tag/addSpecTag')]");
		assertTrue(flag);
	}
	
	//21,添加商品信息
	//22，只输入商品信息，提示库存不能为空
	//23，只输入商品类别和基本信息
	@Test(dataProvider = "testData4",priority = 1)
	public void test23(String name,String item,String price,String shop_price,String stock){
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
		webtest.click("xpath=//a[contains(text(),'管理商品')]");
		webtest.click("xpath=//a[contains(@href,'add')]");
		//设置商品信息
		webtest.type("name=goods_name", name);
		webtest.type("name=goods_item", item);
		webtest.type("name=goods_price", price);
		webtest.type("name=goods_shop_price", shop_price);
		//设置商品分类
		webtest.click("xpath=//a[contains(@href,'#goods_c')]");
		webtest.click("id=class_id_2");
		webtest.click("id=class_id_14");
		//上传商品图片
		webtest.click("xpath=//a[contains(@href,'#goods_d')]");
		webtest.type("xpath=//*[id='uploadifive-file_upload']/input[@type='file']", "E:\\Test\\photo\\img1.jpg");
		//修改库存
		webtest.click("xpath=//a[contains(@href,'#goods_h')]");
		webtest.typeAndClear("name=goods_stock",stock);
		webtest.click("xpath=//button[contains(@onclick,'goods_save_type')]");
		
		boolean flag=webtest.isDisplayed("xpath=//a[contains(@href,'add')]");
		assertTrue(flag);
    }

}
