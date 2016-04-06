package Datadriven;

import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Pageobj_model {
	public WebDriver driver;
  @Test
  public void Test01() throws Exception {
		 driver.findElement(By.id("username")).sendKeys("admin");
		 driver.findElement(By.id("password")).sendKeys("admin");
		 new Select(driver.findElement(By.name("user_language[]"))).selectByVisibleText("English");
		  driver.findElement(By.name("submitLogin")).click();
		  Thread.sleep(5000);

  }
  @Test
  public void Test02() throws Exception
  {
	  DateFormat df=new SimpleDateFormat("yyyy-mm-dd hh-mm-ss a");
	  Date d= new Date();
	  String time=df.format(d);
	  
	  FileOutputStream fo=new FileOutputStream("D:\\workspace_Team2\\ERP_Team2_Seleniumautomation\\pageobj\\"+time+"res2.xls");
	  WritableWorkbook wb=Workbook.createWorkbook(fo);
	  WritableSheet ws=wb.createSheet("res", 0);
	  Thread.sleep(2000);
	  String str=driver.findElement(By.xpath(".//*[@id='tabsHeader']/div")).getText();
	 // Thread.sleep(4000);
	  System.out.println(str);
	  String s[]=str.split("\n");
	  for(int i=1;i<s.length;i++)
	  {
		 // System.out.println(s[i]);
		Label l=new Label(0,i,s[i-1]);
		ws.addCell(l);
		 Label l1 = new Label(1,i,s[i-1]);
		 ws.addCell(l1);
		 Label l2 = new Label(2,i,"link");
		 ws.addCell(l2);
	  }
  
	  
	  Label or=new Label(0,0,"object_Repo");
	  Label  Ds=new Label(1,0,"Display name");
	  Label ObType=new Label(2,0,"object type");
	  ws.addCell(or);
	  ws.addCell(Ds);
	  ws.addCell(ObType);
	  wb.write();
	  wb.close();
	 

  }
  @BeforeTest
  public void beforeTest() throws Exception {
	  driver=new FirefoxDriver();
	  driver.get("http://localhost/erp/");
	  driver.manage().window().maximize();
	  driver.findElement(By.xpath(".//*[@id='topbar']/div/div/div[3]/div[1]/div/button")).click();
	  Thread.sleep(2000);
		 // driver.findElement(By.xpath(".//*[@id='dashborad_menu']/li[1]/a")).click();
		  //Thread.sleep(1000);
		 // driver.findElement(By.xpath(".//*[@id='path_by_module']/div/div[2]/ul[2]/li/ul/li[1]/a")).click();
		  //Thread.sleep(1000);	
  }
 

  @AfterTest
  public void afterTest() {
  }

}
