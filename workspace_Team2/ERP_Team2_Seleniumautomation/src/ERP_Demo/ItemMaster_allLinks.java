package ERP_Demo;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class ItemMaster_allLinks {
	public WebDriver driver;
  @Test
  public void item_masterall_links() throws Exception {
	  driver.findElement(By.xpath(".//*[@id='topbar']/div/div/div[3]/div[1]/div/button")).click();
	  Thread.sleep(2000);
	 driver.findElement(By.id("username")).sendKeys("admin");
	 driver.findElement(By.id("password")).sendKeys("admin");
	 new Select(driver.findElement(By.name("user_language[]"))).selectByVisibleText("English");
	  driver.findElement(By.name("submitLogin")).click();
	  Thread.sleep(5000);
	  
	  // Dash board Item master
	  
	  driver.findElement(By.xpath(".//*[@id='dashborad_menu']/li[1]/a/i")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(".//*[@id='path_by_module']/div/div[2]/ul[2]/li/ul/li[1]/a")).click();
	  Thread.sleep(1000);
	  
	  for(int i=22; i<=39; i++)
	  {
		  driver.findElement(By.id("ui-id-"+i)).click();
	  }
	  
	  /*List<WebElement> web = driver.findElements(By.tagName("a"));	  
	  System.out.println(web.size());
	  
	  try {
		  for(int i=0;i<web.size();i++)
		  {
			  if(web.get(i).getAttribute("class").equals("ui-tabs-anchor"))
			 
			  {
				  if(web.get(i).getText().equalsIgnoreCase("Inventory"))
				  {					  
					  driver.findElement(By.xpath("html/body/div[3]/div[3]/div[1]/div/form/div[2]/div/ul/li[2]/a")).click();
				  }
				  else
				  {
					  Thread.sleep(1000);
					  String str11 = web.get(i).getText();
					  System.out.println("Link Name is:"+web.get(i).getText());				 
					  driver.findElement(By.linkText(str11)).click();
				  }
				 
			  }
		  }
		
	} catch (Exception e) {
		// TODO: handle exception
	}*/
	  
	  
	  
		  /*if(!(web.get(i)).equals(""))
		  {
		  
		 System.out.println("Link Locators----"+web.get(i).toString());
		// System.out.println("Values of Link Text------"+ web.get(i).getText());
		String ss = web.get(i).getAttribute("class");
		  System.out.println("string value is-----"+ss);
		 // System.out.println("text value is------"+web.get(i).getText());
		  
		  
		  if(ss.equalsIgnoreCase("ui-tabs-anchor"))
		   {
			  String ss1 =  web.get(i).getText();
			  
			  
			   System.out.println("ss1 value is: "+ ss1);
			   Thread.sleep(2000);
			   driver.findElement(By.linkText(ss1)).click();
			   Thread.sleep(3000);
		   //}
		   }  */
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
