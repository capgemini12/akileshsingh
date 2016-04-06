package Datadriven;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import jxl.Sheet;
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

public class Output_input_stream {
	public WebDriver driver;
	public String str;
  @Test
  public void f() throws Exception, IOException {
	  DateFormat df=new SimpleDateFormat("yyyy-mm-dd hh-mm-ss a");
	  Date d= new Date();
	  String time=df.format(d);
	  FileInputStream fi= new FileInputStream("D:\\workspace_Team2\\ERP_Team2_Seleniumautomation\\TestData\\login..xls");
	  Workbook wb=Workbook.getWorkbook(fi);
	  Sheet s=wb.getSheet(0);
	  
	 // FileOutputStream
	  
	  FileOutputStream fo=new FileOutputStream("D:\\workspace_Team2\\ERP_Team2_Seleniumautomation\\Result\\"+time+"results.xls");
	  WritableWorkbook wb1= Workbook.createWorkbook(fo);
	  WritableSheet ws= wb1.createSheet("result", 0);
	  for(int i=1; i<s.getRows();i++)
	  {
		  try 
		  {
			  if(s.getCell(2,i).getContents().equalsIgnoreCase("text Box"))
			  {
				  driver.findElement(By.id(s.getCell(0,i).getContents())).sendKeys(s.getCell(3,i).getContents());
				  Thread.sleep(1000);
			  }
			  else if(s.getCell(2,i).getContents().equalsIgnoreCase("Drop Down"))
			  {
				  new Select(driver.findElement(By.id(s.getCell(0,i).getContents()))).selectByVisibleText(s.getCell(3,i).getContents());
				  Thread.sleep(1000);
			  }
			  else if(s.getCell(2,i).getContents().equalsIgnoreCase("Button"))
			  {
				  driver.findElement(By.name(s.getCell(0,i).getContents())).click();
				  Thread.sleep(1000);
			  }
			  else if (s.getCell(2,i).getContents().equalsIgnoreCase("link"))
			  {
				  driver.findElement(By.xpath(s.getCell(0,i).getContents())).click();
				  Thread.sleep(2000);
			  }
			  str="pass";
		} 
		  catch (Exception e) 
		  {
			 str="fail"; 
		  }
		  
		  Label result=new Label(4,i,str);
		  ws.addCell(result);
		  for(int j=0;j<s.getColumns();j++)
		  {
			  System.out.println(s.getCell(j,i).getContents());
			  Label l=new Label(j,i,s.getCell(j,i).getContents());
			  ws.addCell(l);
		  }
		  
		 
	  }    // i for loop
	  Label OR=new Label(0,0,"ObjectRepo");
	  Label DisName=new Label(1,0,"DisplayName");
	  Label OBType=new Label(2,0,"Object Type");
	  Label TData=new Label(3,0,"TestData");
	  Label Rs= new Label(4,0,"Result");
	  ws.addCell(OR);
	  ws.addCell(DisName);
	  ws.addCell(OBType);
	  ws.addCell(TData);
	  ws.addCell(Rs); 
	  wb1.write();
	  wb1.close();
	  
	 
  }
  
  @BeforeTest
  public void beforeTest() throws Exception {
	  driver=new FirefoxDriver();
	  driver.get("http://localhost/erp/");
	  driver.manage().window().maximize();
	  driver.findElement(By.xpath(".//*[@id='topbar']/div/div/div[3]/div[1]/div/button")).click();
	  Thread.sleep(2000);

  }

  @AfterTest
  public void afterTest() {
  }

}
