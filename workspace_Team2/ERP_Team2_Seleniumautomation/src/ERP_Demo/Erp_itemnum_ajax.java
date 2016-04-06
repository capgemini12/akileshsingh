package ERP_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Erp_itemnum_ajax {
	public WebDriver driver;
  @Test
  public void ItemNum_Ajax() throws Exception {
	  driver.findElement(By.xpath("html/body/div[1]/div/div/div[3]/div[1]/div/button")).click();
	  Thread.sleep(2000);
	 driver.findElement(By.id("username")).sendKeys("admin");
	 driver.findElement(By.id("password")).sendKeys("admin");
	 new Select(driver.findElement(By.name("user_language[]"))).selectByVisibleText("English");
	  driver.findElement(By.name("submitLogin")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath(".//*[@id='dashborad_menu']/li[1]/a")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath(".//*[@id='path_by_module']/div/div[2]/ul[2]/li/ul/li[1]/a")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.id("item_number")).sendKeys("ma");
	  Thread.sleep(1000);
	  String str;
	  str=driver.findElement(By.xpath(".//*[@id='ui-id-40']")).getText();
	  System.out.println(str);
	  String s[]=str.split("\n");
	  System.out.println("String Length"+s.length);
	  for(int i=0;i<s.length;i++)
	  {
		if(s[i].equalsIgnoreCase("MAKE_001"))
		{
			System.out.println(s[i]);
			Thread.sleep(4000);
			driver.findElement(By.xpath(".//*[@id='item_number']")).clear();
			//driver.findElement(arg0)
			 // Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='item_number']")).sendKeys(s[i]);
		}
	  }
	  
	  
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
