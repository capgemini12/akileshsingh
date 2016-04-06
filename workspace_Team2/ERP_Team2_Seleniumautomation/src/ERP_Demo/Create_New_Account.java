package ERP_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Create_New_Account {
	 public WebDriver driver;
  @Test(description="Account")
  public void Test01() throws Exception {
	  driver.findElement(By.xpath("html/body/div[1]/div/div/div[3]/div[1]/div/button")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.id("ui-id-2")).click();
	  driver.findElement(By.name("first_name[]")).sendKeys("akhilesh");
	  driver.findElement(By.name("last_name[]")).sendKeys("singh");
	  driver.findElement(By.name("username[]")).sendKeys("akh123");
	  driver.findElement(By.name("email[]")).sendKeys("akhill@gmail.com");
	  driver.findElement(By.id("enteredPassword")).sendKeys("akh123");
	  driver.findElement(By.id("enteredRePassword")).sendKeys("akh123");
	  driver.findElement(By.name("phone[]")).sendKeys("9300317404");
	  driver.findElement(By.name("newUser")).click();
	  Thread.sleep(2000);
  }
  @Test(description="password reset")
  public void Test02() throws Exception {
	  try {
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(".//*[@id='topbar']/div/div/div[3]/div[1]/div/button")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.id("ui-id-3")).click();
		  driver.findElement(By.id("reset_password_user_name")).sendKeys("akhilesh");;
		  driver.findElement(By.id("reset_password_email")).sendKeys("akhil@gmail.com");
		  driver.findElement(By.name("resetPassword")).click();
		  driver.findElement(By.xpath(".//*[@id='myModal']/div[2]/div/div[2]/button")).click();
		  
	} catch (Exception e) {}
	  
  }
  @Test(description="Role Request")
  public void Test03() throws Exception {
	  try {
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(".//*[@id='topbar']/div/div/div[3]/div[1]/div/button")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.id("ui-id-4")).click();
		  /*driver.findElement(By.id("reset_password_user_name")).sendKeys("akhilesh");;
		  driver.findElement(By.id("reset_password_email")).sendKeys("akhil@gmail.com");
		  driver.findElement(By.name("resetPassword")).click();
		  driver.findElement(By.xpath(".//*[@id='myModal']/div[2]/div/div[2]/button")).click();*/
		  
	} catch (Exception e) {}
	  
  }
  @BeforeTest
  public void beforeTest() throws Exception {
	  driver=new FirefoxDriver();
	  driver.get("http://localhost/erp/");
	 
  }

  @AfterTest
  public void afterTest() {
	   driver.quit();
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	  //driver.close();
  }

}
