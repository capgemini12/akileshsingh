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

public class Test007 {
	public WebDriver driver;
  @Test
  public void itemmasterall_links() throws Exception {
	  driver.findElement(By.xpath(".//*[@id='topbar']/div/div/div[3]/div[1]/div/button")).click();
	  Thread.sleep(2000);
	 driver.findElement(By.id("username")).sendKeys("admin");
	 driver.findElement(By.id("password")).sendKeys("admin");
	 new Select(driver.findElement(By.name("user_language[]"))).selectByVisibleText("English");
	  driver.findElement(By.name("submitLogin")).click();
	  Thread.sleep(5000);
	  
	  // Dash board Item master
	  
	  driver.findElement(By.xpath(".//*[@id='dashborad_menu']/li[1]/a/i")).click();
	  Thread.sleep(2000);
	 
	  driver.findElement(By.xpath(".//*[@id='path_by_module']/div/div[2]/ul[1]/li[1]/a")).click();
	  Thread.sleep(3000);
	  String b1 = driver.findElement(By.xpath(".//*[@id='tabsHeader']/ul")).getText();
	  System.out.println(b1);
	  String s[] = b1.split("\n");
	  for(int i=0;i<s.length;i++){
		  driver.findElement(By.linkText(s[i])).click();
	  }
	  
	  String b2 = driver.findElement(By.xpath("html/body/div[3]/div[3]/div[1]/div/form/div[2]/div/ul")).getText();
	  System.out.println(b2);
	  String s2[] = b2.split("\n");
	  for(int j=1;j<=s2.length;j++){
		  driver.findElement(By.xpath("html/body/div[3]/div[3]/div[1]/div/form/div[2]/div/ul/li["+j+"]/a")).click();
	  }
	  
	 /* //WebElement str1 = driver.findElement(By.xpath(".//*[@id='erp_form_area']"));
	  List<WebElement> web = driver.findElements(By.tagName("a"));
	  
	  System.out.println(web.size());
	  for(int i=0;i<web.size();i++)
	  {
		  
		 System.out.println("Link Locators----"+web.get(i).getAttribute("class"));
		// System.out.println("Values of Link Text------"+ web.get(i).getText());
		 String cl = web.get(i).getAttribute("class");
		 //String idl = web.get(i).getAttribute("id");
		  System.out.println("string value is-----"+cl);
		  System.out.println("text value is------"+web.get(i).getText());
		  if(cl.equalsIgnoreCase("ui-tabs-anchor"))
		  {
			  if(driver.findElement(By.xpath(".//*[@id='ui-id-31']")).getText().equalsIgnoreCase("Main"))
			  {
				  //driver.findElement(By.xpath(".//*[@id='ui-id-31']")).click();
				  for(int j=1;j<10;j++)
				  {
					  driver.findElement(By.xpath("html/body/div[3]/div[3]/div[1]/div/form/div[2]/div/ul/li["+j+"]/a")).click();
				  }
			 
			  }  else{
		   	  String ss1 =  web.get(i).getText();
			   System.out.println("ss1 value is: "+ ss1);
			   driver.findElement(By.linkText(ss1)).click();
			   Thread.sleep(3000);
			  }*/
		    
	  } 
  
	  
	  
	  
	 /* String s[] = str2.split("\n");
	 
      for(int i=0;i<s.length;i++){
    	 
	  //String cmp = str2.get(i).getText();
	  System.out.println(s[i]);
      }
			  //equalsIgnoreCase("ui-tabs-anchor"));
      */
	/* // String s[] = str1.split("\n");
	 // for(int i=0;i<s.length;i++){
	  //System.out.println(s[i]);
	  //}
*/	  //WebElements
	  
	 /* String s1 = driver.findElement(By.xpath(".//*[@id='tabsHeader']/ul")).getText();
	  //String s1 = driver.findElement(By.xpath("html/body/div[3]/div[3]/div[1]/div/form/div[1]/div/ul")).getText();
	  System.out.println(s1);*/
	  
	  
	/* String str= driver.findElement(By.xpath(".//*[@id='erp_form_area']")).getText();
	 //String str1=driver.findElement(By.)
	// System.out.println(str.length());
	 System.out.println(str);
	 String s[]=str.split("\n");
	 for(int i=0;i<s.length;i++)
	 {
		if(s[i].equalsIgnoreCase("\n"))
		 {
			 System.out.println(s[i]);
			 driver.findElement(By.linkText(s[i])).click();
		 }
	 
	 }*/
	
  
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
