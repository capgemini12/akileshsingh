package Inventory_Module;

//import java.util.Set;


import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Test_004 {
	public WebDriver driver;
  @Test
  public void Alogin() throws Exception {
	  driver.findElement(By.xpath(".//*[@id='topbar']/div/div/div[3]/div[1]/div/button")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath(".//*[@id='user_login']/ul/li[4]/input")).click();
			Thread.sleep(1000);
  }
  @Test
  public void Bchk_window() throws Exception
    {
	   driver.findElement(By.xpath(".//*[@id='dashborad_menu']/li[1]/a/i")).click();
    
     		Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='path_by_module']/div/div[2]/ul[1]/li[1]/a")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='item_id']")).click();
			driver.findElement(By.xpath(".//*[@id='tabsHeader-1']/ul/li[2]/i")).click();
			//Thread.sleep(1000);
			//String str = driver.getWindowHandle();
			Set<String> windows = driver.getWindowHandles();
			System.out.println(windows);
			Object s[] = windows.toArray();
			System.out.println(windows);
			driver.switchTo().window((s[0].toString()));
			//Thread.sleep(1000);
			//driver.switchTo().window(s[1].toString());
			//driver.switchTo().window(str);*/
    }
					
  
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
		driver.get("http://localhost/erp/");
		driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	//  driver.close();
	// driver.quit();
  }

}
