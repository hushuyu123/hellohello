package com.webtest.pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
public class HomePage {

	//点击CMS-管理文章
		public void managementArticles(WebDriver driver) throws Exception {
			driver.findElement(By.xpath("//a[contains(text(),'CMS管理')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'管理文章')]")).click();
			Thread.sleep(3000);
		}
		
		
		//点击CMS-管理文章分类
		public void managementKind(WebDriver driver) throws Exception {
			driver.findElement(By.xpath("//a[contains(text(),'CMS管理')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'管理文章分类')]")).click();
			Thread.sleep(3000);
		}
		

		//点击工具管理-导航设置
		public void navigation(WebDriver driver) throws Exception{
			driver.findElement(By.xpath("//a[contains(text(),'工具管理')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'导航设置')]")).click();
			Thread.sleep(3000);
		}
		
		
		//点击工具管理-友情链接
		public void links(WebDriver driver) throws Exception{
			driver.findElement(By.xpath("//a[contains(text(),'工具管理')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'友情链接')]")).click();
			Thread.sleep(3000);
		}
		
		
		

		//点击工具管理-邮件发送
		public void messageSend(WebDriver driver) throws Exception{
			driver.findElement(By.xpath("//a[contains(text(),'工具管理')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'邮件发送')]")).click();
			Thread.sleep(3000);
		}
		
		public boolean isMailSendsuccess1(WebDriver driver)throws Exception{
			boolean flag = false;
			try {
				if (driver.findElement(By.xpath("//*[@class=\"alert alert-success\"]")).isDisplayed()) {
					flag=true;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			
			return flag;
		}
		
		//点击工具管理-广告管理-电脑端广告
		public void ComputerAdvertising(WebDriver driver) throws Exception{
			driver.findElement(By.xpath("//a[contains(text(),'工具管理')]")).click();
			
			WebElement e1 = driver.findElement(By.xpath("//a[contains(text(),'广告管理')]"));
			
			Actions builder = new Actions(driver);
			builder.moveToElement(e1).perform();
			driver.findElement(By.xpath("//a[contains(text(),'电脑端广告(PC)')]")).click();
		}
		
		//点击工具管理-备份数据库
		public void operationLog(WebDriver driver) throws Exception{
			driver.findElement(By.xpath("//a[contains(text(),'工具管理')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'数据库备份')]")).click();
			Thread.sleep(3000);
		}
		
		public boolean isBackupSuccess(WebDriver driver)throws Exception{
			boolean flag = false;
			try {
				if (driver.findElement(By.xpath("//*[@class=\"alert alert-success\"]")).isDisplayed()) {
					flag=true;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			
			return flag;
		}
		
		public boolean isTextPresent(String pattern,WebDriver driver) {

			String text = driver.getPageSource();
			text = text.trim();
			if (text.contains(pattern)) {
				return true;
			}
			return false;
		}
}
