package ERP_Demo;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Login {
	public WebDriver driver;
  @Test
  public void f() throws Exception {
	  driver.findElement(By.xpath("html/body/div[1]/div/div/div[3]/div[1]/div/button")).click();
	  Thread.sleep(2000);
	 driver.findElement(By.id("username")).sendKeys("admin");
	 driver.findElement(By.id("password")).sendKeys("admin");
	 new Select(driver.findElement(By.name("user_language[]"))).selectByVisibleText("English");
	  driver.findElement(By.name("submitLogin")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("html/body/nav/div/div[2]/ul/li[6]/div/div/button")).click();
	  Thread.sleep(1000);
	  //driver.findElement(By.xpath("html/body/nav/div/div[2]/ul/li[6]/div/div/ul/li[8]/a")).click();
	  
	  //Login with invalid credential
	  
	 driver.findElement(By.xpath(".//*[@id='dashborad_menu']/li[1]/a")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(".//*[@id='path_by_module']/div/div[2]/ul[2]/li/ul/li[1]/a")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(".//*[@id='item_id']")).click();
	  driver.findElement(By.xpath(".//*[@id='tabsHeader-1']/ul/li[2]/i")).click();
	  Thread.sleep(1000);
	  Set<String> windows=driver.getWindowHandles();
	  System.out.println(windows);
	  Object s[]=windows.toArray();
	  System.out.println(s[0].toString());
	  driver.switchTo().window(s[1].toString());
	  driver.switchTo().window(s[0].toString());
	 // driver.findElement(By.xpath("search_submit_btn")).click();
  }
 /* @Test
  public void invalidLogin() throws Exception 
  {
	  try {
		  driver.findElement(By.xpath("html/body/div[1]/div/div/div[3]/div[1]/div/button")).click();
		  Thread.sleep(2000);
		 driver.findElement(By.id("username")).sendKeys("admin@");
		 driver.findElement(By.id("password")).sendKeys("admin1");
		 new Select(driver.findElement(By.name("user_language[]"))).selectByVisibleText("English");
		  driver.findElement(By.name("submitLogin")).click();
		  Thread.sleep(1000);
		
		
	} catch (Exception e) {}
	 
  }*/
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
