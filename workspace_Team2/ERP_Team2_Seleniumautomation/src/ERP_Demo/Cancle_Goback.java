package ERP_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Cancle_Goback {
	public WebDriver driver;
  @Test
  public void verify_cancle_Goback() throws Exception {
	  driver.findElement(By.xpath("html/body/div[1]/div/div/div[3]/div[1]/div/button")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.id("ui-id-3")).click();
	  driver.findElement(By.id("reset_password_user_name")).sendKeys("akh123");
	  driver.findElement(By.id("reset_password_email")).sendKeys("akhill@gmail.com");
	  //driver.findElement(By.name("resetPassword")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(".//*[@id='ui-id-2']")).click();
  }
  
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("http://localhost/erp/");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
