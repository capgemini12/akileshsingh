package ERP_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class OrgID_17 {
	public WebDriver driver;
  @Test
  public void f() throws Exception {
	  driver.findElement(By.xpath(".//*[@id='topbar']/div/div/div[3]/div[1]/div/button")).click();
	  Thread.sleep(2000);
	 driver.findElement(By.id("username")).sendKeys("admin");
	 driver.findElement(By.id("password")).sendKeys("admin");
	 new Select(driver.findElement(By.name("user_language[]"))).selectByVisibleText("English");
	  driver.findElement(By.name("submitLogin")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("html/body/div[3]/div[3]/div[1]/div/div/div/form/div/div/div[1]/ul/li[1]/a")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("html/body/div[3]/div[3]/div[1]/div/div/div/div[2]/ul[2]/li/ul/li[1]/a")).click();
	  Thread.sleep(3000);
	 new Select(driver.findElement(By.xpath("html/body/div[3]/div[3]/div[1]/div/form/div[1]/div/div/div[1]/ul/li[1]/select"))).selectByVisibleText("MAS");
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("http://localhost/erp/");
	  
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
