package Inventory_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Test_006 {
	public WebDriver driver;
  @Test
  public void allLinks_Inventory() throws Exception {
	  driver.findElement(By.xpath(".//*[@id='topbar']/div/div/div[3]/div[1]/div/button")).click();
	  Thread.sleep(2000);
	 driver.findElement(By.id("username")).sendKeys("admin");
	 driver.findElement(By.id("password")).sendKeys("admin");
	 new Select(driver.findElement(By.name("user_language[]"))).selectByVisibleText("English");
	  driver.findElement(By.name("submitLogin")).click();
	  
	  
	  driver.findElement(By.xpath(".//*[@id='sys_menu_left_vertical']/div[2]/ul/li[5]")).click();
	  Thread.sleep(2000);
	 // driver.findElement(By.xpath("html/body/div[3]/div[3]/div[1]/div/div/div/div[2]/ul[2]/li/ul/li[1]/a")).click();
	 //String str1=driver.findElement(By.xpath(".//*[@id='path_by_module']/div/div[2]")).getText();
	 //System.out.println(str1);
	  //List<WebElement> str1=driver.findElements(By.xpath(".//*[@id='sys_menu_left_vertical']/div[2]/ul/li[5]/ul"));
	  
	  String str1 = driver.findElement(By.xpath(".//*[@id='sys_menu_left_vertical']/div[2]/ul/li[5]/ul")).getText();
			  System.out.println(str1.length());
	  System.out.println(str1);
		  String s[]=str1.split("\n");
			 for(int i=0;i<s.length; i++)
			 {
				 System.out.println(s[i]);
				 driver.findElement(By.linkText(s[i])).click();
				 Thread.sleep(2000);
			 }
			  
			
	
		 
	  }
	 // System.out.println(str1);

	 
  

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



