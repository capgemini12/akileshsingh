package com.erp;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Helper {
	public WebDriver driver;
	public String firstWindow;
	public String secondWindow;
	public String str;
	
	public void click_Login() throws Exception{
		driver.findElement(By.xpath(".//*[@id='topbar']/div/div/div[3]/div[1]/div/button")).click();
		//Thread.sleep(2000);
		//To check cancel login button functionality
		//driver.findElement(By.xpath(".//*[@id='cancelLogin']")).click();
	}
	
	public void newAct_Create() throws Exception{
		
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
	
	public void login_Dashboard() throws Exception{
		//driver.findElement(By.xpath(".//*[@id='topbar']/div/div/div[3]/div[1]/div/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		WebElement dropdown = driver.findElement(By.xpath(".//*[@id='user_language']"));
		Select sel = new Select(dropdown);
		sel.selectByVisibleText("English");
		driver.findElement(By.name("submitLogin")).click();
		 driver.findElement(By.xpath(".//*[@id='dashborad_menu']/li[1]/a/i")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(".//*[@id='path_by_module']/div/div[2]/ul[1]/li[1]/a")).click();
		
		
	}
	
	public void handle_Windows() throws Exception{
		driver.findElement(By.xpath(".//*[@id='dashborad_menu']/li[1]/a/i")).click();
	    Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='path_by_module']/div/div[2]/ul[1]/li[1]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='item_id']")).click();
		driver.findElement(By.xpath(".//*[@id='tabsHeader-1']/ul/li[2]/i")).click();
		//Thread.sleep(1000);
		//Set<String> windows = driver.getWindowHandles();
		//System.out.println(windows);
		//Object s[] = windows.toArray();
		//System.out.println(windows);
		windows_Handler();
		driver.switchTo().window(firstWindow);
		//driver.switchTo().window((s[0].toString()));
	}
	public void handle_Ajax() throws Exception{
		driver.findElement(By.xpath(".//*[@id='item_number']")).sendKeys("ma");
		Thread.sleep(1000);
		String str = driver.findElement(By.xpath(".//*[@id='ui-id-40']")).getText();
		System.out.println(str);
		String s[] = str.split("\n");
		System.out.println("string length is " + s.length);
		for(int i=0;i<s.length;i++)
		{
			if(s[i].equalsIgnoreCase("MAKE_001"))
			{
				System.out.println(s[i]);
				driver.findElement(By.xpath(".//*[@id='item_number']")).clear();
				driver.findElement(By.xpath(".//*[@id='item_number']")).sendKeys(s[i]);
			}	
		}
				
	   }
	
	public void links_Dashboard() throws Exception{
		
		String str = driver.findElement(By.xpath("html/body/div[3]/div[3]/div[1]/div/div/div/form/div/div")).getText();
		System.out.println(str.length());
		String s[] = str.split("\n");
		for(int i=0;i<s.length;i++){
			driver.findElement(By.linkText(s[i])).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("html/body/div[3]/div[3]/div[1]/div/div/div/div[1]/ul/li[1]/a")).click();
			Thread.sleep(2000);
			//System.out.println("Element : "+ s[i]);
		}
		
	}
	public void links_Inv() throws Exception{
	
		 driver.findElement(By.xpath(".//*[@id='sys_menu_left_vertical']/div[2]/ul/li[5]")).click();
		  Thread.sleep(2000);
		
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
	public void windows_Handler() throws Exception{
		 Set<String> windows = driver.getWindowHandles();
		 Iterator<String> it = windows.iterator();
		 System.out.println("Total no of windows :"+ windows.size());
		 firstWindow = it.next();
		 if((windows.size())>1)
		 {
		 secondWindow = it.next();
		 System.out.println("windows are---:" + firstWindow + secondWindow);
		 driver.switchTo().window(secondWindow);
		 }
		 else
		 {
			 driver.switchTo().window(firstWindow);
		 }
		// driver.switchTo().window(secondWindow);
		// System.out.println(driver.getWindowHandle());
		 
	 }
	 public void write_Excel() throws Exception{
		 
		 
	 }
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
		driver.get("http://localhost/erp/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
	// driver.quit();
  }

}
