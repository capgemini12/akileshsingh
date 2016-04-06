package Inventory_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Test_005 {
	WebDriver driver;

  @Test
  public void f() throws Exception{
	  driver.findElement(By.xpath(".//*[@id='topbar']/div/div/div[3]/div[1]/div/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.xpath(".//*[@id='user_login']/ul/li[4]/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='dashborad_menu']/li[1]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='path_by_module']/div/div[2]/ul[1]/li[1]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='item_number']")).sendKeys("ma");
		Thread.sleep(1000);
		String str = driver.findElement(By.xpath(".//*[@id='ui-id-40']")).getText();
		System.out.println(str);
		String s[] = str.split("\n");
		System.out.println("string length is " + s.length);
		for(int i=0;i<s.length;i++){
			if(s[i].equalsIgnoreCase("MAKE_001")){
				System.out.println(s[i]);
				driver.findElement(By.xpath(".//*[@id='item_number']")).clear();
				driver.findElement(By.xpath(".//*[@id='item_number']")).sendKeys(s[i]);
				
			}
		}
		
  }
  @BeforeTest
  public void beforeTest() {
		  driver = new FirefoxDriver();
			driver.get("http://localhost/erp/");
			driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
