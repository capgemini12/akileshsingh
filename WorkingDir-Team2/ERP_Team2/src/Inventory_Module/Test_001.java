package Inventory_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Test_001{
	public WebDriver driver;
	  @BeforeTest
	  public void beforeTest() {
		  driver = new FirefoxDriver();
			driver.get("http://localhost/erp/");
			driver.manage().window().maximize();
		  
	  }
  @Test
  public void f() throws Exception{
	  driver.findElement(By.xpath(".//*[@id='topbar']/div/div/div[3]/div[1]/div/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='cancelLogin']")).click();
  }


  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
