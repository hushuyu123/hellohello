package com.webtest.pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.webtest.core.BaseTest;



public class LoginPage extends BaseTest{
	private String name = "user_name";
	private String pwd = "user_passwd";
	private String forLogin = "btn";
	
	public void login(WebDriver driver,String admin,String admin2020)throws Exception {
		driver.findElement(By.id(name)).sendKeys(admin);
		driver.findElement(By.id(pwd)).sendKeys(admin2020);
		//点击登录
		driver.findElement(By.className(forLogin)).click();
		Thread.sleep(3000);
		
	}
	
	public boolean isLoginSuccess(WebDriver driver)throws Exception {
		boolean flag = true;
		try {

			if (driver.findElement(By.id("user_passwd")).isDisplayed()) {
				flag = false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return flag;
	}
	
	public boolean loginStatus(WebDriver driver)throws Exception {
		if (isAlertPresent(driver)) {
			Reporter.log(driver.switchTo().alert().getText());
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
			driver.navigate().refresh();
			return false;
		}
		else if (!(isLoginSuccess(driver))) {
			Reporter.log("用户名错误！");
			System.out.println("用户名错误！");
			driver.navigate().refresh();
			Thread.sleep(3000);
			return false;
		}
		else {
			Reporter.log("登陆成功!");
			System.out.println("登陆成功！");
			return true;
		}
		
	}
	
	public boolean isAlertPresent(WebDriver driver) throws Exception {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public boolean isLoginPage(WebDriver driver) throws Exception {
		boolean flag = false;
		try {
			if (driver.findElement(By.className(forLogin)).getAttribute("value").equals("后台登录")) {
				flag = true;
				return flag;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return flag;
		}
		return flag;
		
	}
}
