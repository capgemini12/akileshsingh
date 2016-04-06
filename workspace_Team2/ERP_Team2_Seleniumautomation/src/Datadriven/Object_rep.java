package Datadriven;

import java.io.FileInputStream;
import jxl.Sheet;
import jxl.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Object_rep {
	public WebDriver driver;
  @Test
  public void step1() throws Exception {
	  
	  FileInputStream fi= new FileInputStream("D:\\workspace_Team2\\ERP_Team2_Seleniumautomation\\TestData\\login.xls");
	  Workbook wb=Workbook.getWorkbook(fi);
	  Sheet s=wb.getSheet(0);
	  for(int i=1; i<s.getRows();i++)
	  {
		  try {
			  if(s.getCell(2,i).getContents().equalsIgnoreCase("text Box"))
			  {
				  driver.findElement(By.id(s.getCell(0,i).getContents())).sendKeys(s.getCell(3,i).getContents());
				  Thread.sleep(3000);
			  }
			  else if(s.getCell(2,i).getContents().equalsIgnoreCase("Drop Down"))
			  {
				  new Select(driver.findElement(By.id(s.getCell(0,i).getContents()))).selectByVisibleText(s.getCell(3,i).getContents());
				  Thread.sleep(2000);
			  }
			  else if(s.getCell(2,i).getContents().equalsIgnoreCase("Button"))
			  {
				  driver.findElement(By.name(s.getCell(0,i).getContents())).click();
				  Thread.sleep(2000);
			  }
			  else if (s.getCell(2,i).getContents().equalsIgnoreCase("link"))
			  {
				  Thread.sleep(2000);
				  driver.findElement(By.xpath(s.getCell(0,i).getContents())).click();
			  }
		} catch (Exception e) {
			
		}
	  }
	  /*  FileOutputStream fo=new FileOutputStream("D:\\workspace_Team2\\ERP_Team2_Seleniumautomation\\Result\\erpresult.xls");
	  WritableWorkbook wb=Workbook.createWorkbook(fo);
	  WritableSheet ws=wb.createSheet("Result1", 0);
	  
	 Label OR=new Label(0,0,"ObjectReository");
	  Label DisName=new Label(1,0,"DisplayName");
	  Label Ob=new Label(2,0,"ObjectType");
	  ws.addCell(OR);
	  ws.addCell(DisName);
	  ws.addCell(Ob);
	  wb.write();
	  wb.close();*/
	  
	  
  }
  @BeforeTest
  public void beforeTest() throws Exception {
	  driver=new FirefoxDriver();
	  driver.get("http://localhost/erp/");
	  driver.manage().window().maximize();
	  driver.findElement(By.xpath(".//*[@id='topbar']/div/div/div[3]/div[1]/div/button")).click();
	  Thread.sleep(2000);
	/* driver.findElement(By.id("username")).sendKeys("admin");
	 driver.findElement(By.id("password")).sendKeys("admin");
	 new Select(driver.findElement(By.name("user_language[]"))).selectByVisibleText("English");
	  driver.findElement(By.name("submitLogin")).click();
	  Thread.sleep(5000);*/
  }

  @AfterTest
  public void afterTest() {
  }

}

