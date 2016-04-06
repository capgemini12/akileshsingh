package Inventory_Module;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Test008 {
	public WebDriver driver;
  @Test
  public void f() throws Exception {
	  driver.findElement(By.xpath(".//*[@id='topbar']/div/div/div[3]/div[1]/div/button")).click();
	  Thread.sleep(2000);
	 driver.findElement(By.id("username")).sendKeys("admin");
	 driver.findElement(By.id("password")).sendKeys("admin");
	 new Select(driver.findElement(By.name("user_language[]"))).selectByVisibleText("English");
	  driver.findElement(By.name("submitLogin")).click();
	  driver.findElement(By.xpath(".//*[@id='dashborad_menu']/li[1]/a")).click();
	  Thread.sleep(2000);
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for (int j = 0; j < links.size(); j++)
		{
			System.out.println("check j value " +j);
			String i = links.get(j).getAttribute("class");
			if(i.equalsIgnoreCase("list-header"))
			{
			System.out.println(links.get(j).getText());	
			String str = links.get(j).getText();
		
			/*if(str == "On Hand")
			{
				System.out.println("Not printing On Hand");
			}
			else*/
			{
				driver.findElement(By.linkText(str)).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath(".//*[@id='structure']/ul/li[2]/a")).click();
				Thread.sleep(2000);
			}
			
			}
		}
		/*for (int i = 0; i < links.size(); i++)
		{
		 String j = links.get(i).getAttribute("class");
		 if(j.equalsIgnoreCase("list-header"))
		 {
			 driver.findElement(By.linkText(links.get(i).getText())).click();
		 }
		}*/
				
	  
  }
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
		driver.get("http://localhost/erp/");
		driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
