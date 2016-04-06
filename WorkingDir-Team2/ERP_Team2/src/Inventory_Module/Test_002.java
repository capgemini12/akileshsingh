package Inventory_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Test_002 {
	 public WebDriver driver;
	 @BeforeTest
	  public void beforeTest() throws Exception {
		 driver = new FirefoxDriver();
		 driver.get("http://localhost/erp/");
		 driver.manage().window().maximize();
		 
		 }

	@Test
  public void f() throws Exception {
		driver.findElement(By.xpath(".//*[@id='topbar']/div/div/div[3]/div[1]/div/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='ui-id-2']")).click();
		
		driver.findElement(By.name("first_name[]")).sendKeys("kiran");
		
		driver.findElement(By.name("last_name[]")).sendKeys("puram");
		driver.findElement(By.name("username[]")).sendKeys("kiranpuram");
		driver.findElement(By.name("email[]")).sendKeys("kiran1028@gmail.com");
		driver.findElement(By.id("enteredPassword")).sendKeys("password");
		driver.findElement(By.id("enteredRePassword")).sendKeys("password");
		driver.findElement(By.name("phone[]")).sendKeys("123456");
		driver.findElement(By.name("newUser")).click();
	}
 
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
