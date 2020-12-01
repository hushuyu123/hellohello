package com.webtest.core;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.TestRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.utils.Log;
import com.webtest.utils.ReadProperties;

public class BaseTest {

	public WebDriverEngine webtest;
	private WebDriver driver;
	public String driverType;;

	ExcelDataProvider excel = new ExcelDataProvider();

	public void testLogin() {
		webtest.open("http://localhost:86/admin");
		webtest.type("name=user_name", "admin");
		webtest.type("name=user_passwd", "123456");
		webtest.click("xpath=//button[@type='submit']");

	}

	private WebDriver newWebDriver(String driverType) throws IOException {
		WebDriver driver = null;

		if (driverType.equalsIgnoreCase("firefox")) {
			String firefox_driver = ReadProperties.getPropertyValue("gecko_driver");
			String firefox_path = ReadProperties.getPropertyValue("firefox_path");
			System.setProperty("webdriver.gecko.driver", firefox_driver);
			System.setProperty("webdriver.firefox.bin", firefox_path);
			driver = new FirefoxDriver();

			Log.info("Using Firefox");
		} else if (driverType.equalsIgnoreCase("chrome")) {
			String chrome_path = ReadProperties.getPropertyValue("chrome_path");
			System.setProperty("webdriver.chrome.driver", chrome_path);
			driver = new ChromeDriver();
			Log.info("Using Chrome");

		} else {
			return null;
		}

		return driver;

	}

	@BeforeClass
	public void doBeforeClass() throws Exception {

		driverType = ReadProperties.getPropertyValue("driverType");
		driver = this.newWebDriver(driverType);
		driver.manage().window().maximize();
		Log.info(driverType);
		webtest = new WebDriverEngine(driver);

	}

	@AfterClass
	public void doAfterMethod() {
		if (this.driver != null) {
			this.driver.quit();
		}
		Log.info("Quitted Browser");
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void adminLogin() throws IOException {
		webtest.open("http://localhost:86/admin");
		webtest.type("id=user_name", "admin");
		webtest.type("id=user_passwd", "123456");
		webtest.click("xpath=//button[contains(text(),'后台登录')]");
	}

	public void baseLogin() throws IOException {
		webtest.open("http://localhost:86/");

		webtest.click("xpath=//a[contains(text(),'登录')]");
		webtest.type("id=user_name", "admin2");
		webtest.type("id=user_password", "admin2");
		webtest.type("id=captcha_code", "11111");
		webtest.click("xpath=//button[contains(text(),'会员登录')]");
	}

	
	public String getExcel(int i, int j) throws IOException {
		Object[][] result = excel.getTestDataByExcel("data\\DBShop2.xlsx", "Sheet1");
		return (String) result[i][j];
	}


}
