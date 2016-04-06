package ERP_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class All_Module_Name {
	public WebDriver driver;
	@Test
	 public void Test01() throws Exception 
	  {
		  driver.findElement(By.xpath(".//*[@id='topbar']/div/div/div[3]/div[1]/div/button")).click();
		  Thread.sleep(2000);
		 driver.findElement(By.id("username")).sendKeys("admin");
		 driver.findElement(By.id("password")).sendKeys("admin");
		 new Select(driver.findElement(By.name("user_language[]"))).selectByVisibleText("English");
		  driver.findElement(By.name("submitLogin")).click();
		  Thread.sleep(5000);
		 // driver.findElement(By.xpath(".//*[@id='dashborad_menu']/li[2]/a")).click();
		  
	  }
	 @Test
  public void Test02() throws Exception {
		 //List<WebElement> str=driver.findElements(By.tagName("a"));
		/* List<WebElement> str=driver.findElements(By.xpath("html/body/div[3]/div[3]/div[1]/div/div/div/form/div/div"));
		 System.out.println(str.size());	
		 for(int i=0;i<str.size();i++)
		 {
		if(!str.get(i).getText().equalsIgnoreCase(""))
			 
		 System.out.println(str.get(i).getText());
		str.get(i).click();
		Thread.sleep(3000);
		//driver.findElement(By.linkText(str.get(i).getText().;
		
		*/
			
		// }
		// System.out.println(str.size());
		 
	String str=driver.findElement(By.xpath("html/body/div[3]/div[3]/div[1]/div/div/div/form/div/div")).getText();
	System.out.println(str);
	String s[]=str.split("\n");
	for(int i=0;i<s.length;i++)
	{
		if(!s[i].equalsIgnoreCase(""))
		{
			System.out.println(s[i]);
			Thread.sleep(2000);
			driver.findElement(By.linkText(s[i])).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("html/body/div[3]/div[3]/div[1]/div/div/div/div[1]/ul/li[1]/a")).click();
			Thread.sleep(2000);
		}
	}


  }
  @BeforeTest
  public void beforeTest() throws Exception {
	  driver=new FirefoxDriver();
	  driver.get("http://localhost/erp/");
	  
	  driver.manage().window().maximize();
	//  Thread.sleep(3000);
  }

  @AfterTest
  public void afterTest() {
  }

}
