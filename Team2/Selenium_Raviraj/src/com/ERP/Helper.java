package com.ERP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Helper {
	
	public WebDriver driver;
	
  
  public void login() throws Exception {
	  
	driver.findElement(By.xpath(".//*[@id='topbar']/div/div/div[3]/div[1]/div/button")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("admin");
	driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("admin");
    new Select(driver.findElement(By.xpath(".//*[@id='user_language']"))).selectByVisibleText("English");
    driver.findElement(By.xpath(".//*[@id='user_login']/ul/li[4]/input")).click();
  }
  
  
  public void Item_Master_Navigation() throws Exception
  {
	 driver.findElement(By.xpath(".//*[@id='dashborad_menu']/li[1]/a/i")).click();
	 Thread.sleep(3000);
	 driver.findElement(By.xpath(".//*[@id='path_by_module']/div/div[2]/ul[2]/li/ul/li[1]/a") ).click();
	 
	  
  }
  @BeforeTest
  public void beforeTest() {
	
	  driver = new FirefoxDriver();
	  driver.get("http://localhost/erp/");
	 
  }

  @AfterTest
  public void afterTest() {
	
  }

}
