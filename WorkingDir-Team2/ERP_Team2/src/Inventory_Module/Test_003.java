package Inventory_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Test_003 {
	public WebDriver driver;
	@BeforeTest
	  public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("http://localhost/erp/");
		driver.manage().window().maximize();
	  }
	@Test
  public void f() throws Exception {
		driver.findElement(By.xpath(".//*[@id='topbar']/div/div/div[3]/div[1]/div/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		WebElement dropdown = driver.findElement(By.xpath(".//*[@id='user_language']"));
		Select sel = new Select(dropdown);
		sel.selectByVisibleText("English");
		driver.findElement(By.name("submitLogin")).click();
		
  }
  

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
