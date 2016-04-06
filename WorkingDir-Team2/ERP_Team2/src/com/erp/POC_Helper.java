package com.erp;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class POC_Helper {
 public WebDriver driver;
 String firstWindow;
 String secondWindow;
	 
 public void erp_Inventory() throws Exception{
	 try {
		 driver.findElement(By.xpath(".//*[@id='topbar']/div/div/div[3]/div[1]/div/button")).click();
		 driver.findElement(By.id("username")).sendKeys("admin");
		 driver.findElement(By.id("password")).sendKeys("admin");
		 driver.findElement(By.name("submitLogin")).click();
		 driver.findElement(By.xpath("html/body/div[3]/div[3]/div[1]/div/div/div/form/div/div/div[1]/ul/li[1]/a/i")).click();
		 driver.findElement(By.xpath("html/body/div[3]/div[3]/div[1]/div/div/div/div[2]/ul[1]/li[1]/a")).click();
	
		 Select sel = new Select(driver.findElement(By.id("org_id")));
		 sel.selectByVisibleText("MAS");
		
		 driver.findElement(By.id("item_id")).click();
		 driver.findElement(By.xpath("html/body/div[3]/div[3]/div[1]/div/form/div[1]/div/div/div[1]/ul/li[2]/i")).click();
		 Thread.sleep(2000);
		 window_Handles();
		
		 driver.findElement(By.name("item_id[]")).sendKeys("1");
		 driver.findElement(By.id("search_submit_btn")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(".//*[@id='tabsLine-0']/table/tbody/tr[10]/td[2]/a")).click();
		 
		 /*Thread.sleep(2000);
		 //driver.findElement(By.id("new_page_button")).click();
		 driver.findElement(By.id("item_number")).click();
		 driver.findElement(By.xpath(".//*[@id='tabsHeader-1']/ul/li[3]/i")).click();
		 window_Handles();
		 driver.findElement(By.id("search_submit_btn")).click();
		 System.out.println("hellooooo");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(".//*[@id='ui-id-31']")).click();*/
		 
		 driver.switchTo().window(firstWindow);
		 new Select(driver.findElement(By.xpath(".//*[@id='item_type']"))).selectByIndex(1);
		 //s.selectByVisibleText("Expense");
		 Select s1 = new Select(driver.findElement(By.xpath(".//*[@id='uom_id']")));
		 s1.selectByVisibleText("HR");
		 Select s2 = new Select(driver.findElement(By.xpath(".//*[@id='item_status']")));
		 s2.selectByVisibleText("Active");
		
		 //String m =  driver.findElement(By.xpath(".//*[@id='ui-id-54']")).getText();
		 driver.findElement(By.linkText("Manufacturing")).click();
		 Select s3 = new Select(driver.findElement(By.xpath(".//*[@id='make_buy']")));	
		 s3.selectByVisibleText("BUY");
		 driver.findElement(By.xpath(".//*[@id='save']")).click();
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	 

 }
 public void window_Handles() throws Exception{
	 Set<String> windows = driver.getWindowHandles();
	 Iterator<String> it = windows.iterator();
	 firstWindow = it.next();
	 secondWindow = it.next();
	 System.out.println(firstWindow + secondWindow);
	 driver.switchTo().window(secondWindow);
	 System.out.println(driver.getWindowHandle());
	 
 }
 
 
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
		driver.get("http://localhost/erp/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
	//  driver.quit();
  }

}
