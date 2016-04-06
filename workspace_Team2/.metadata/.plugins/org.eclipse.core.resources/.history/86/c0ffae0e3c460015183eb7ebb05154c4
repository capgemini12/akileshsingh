package com.dataDriven;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
public class Inventory 
{
	
	public WebDriver driver;
    public String str;	
	
	public String timestamp()
	{
		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy hh-mm-ss");
		Date d = new Date();
		String time = df.format(d);
		return time;
	}
	
  @Test
  public void verify_testData() throws Exception
  {
 	 FileInputStream fis = new FileInputStream("D:\\ERPAutomation\\Inventory_inputs.xls");
 	 Workbook wb = Workbook.getWorkbook(fis);
 	 Sheet s = wb.getSheet(2);
 	 
 	 FileOutputStream fos =  new FileOutputStream("D:\\ERPAutomation\\Inventory_output"+timestamp()+".xls");
 	  WritableWorkbook wb1 = Workbook.createWorkbook(fos);
 	  WritableSheet ws1 = wb1.createSheet("Item Creation", 0);
  	for(int k=3; k<s.getColumns(); k++)
 	{
 		 for(int i=1; i<s.getRows(); i++)
 		  {		
 			  try
 			  {
 				  if(s.getCell(2,i).getContents().equalsIgnoreCase("url"))
 				  {
 				  driver.get(s.getCell(3,i).getContents());
 				  Thread.sleep(1000);
 				  }
 				  else if(s.getCell(2,i).getContents().equalsIgnoreCase("button"))
 				  {
 				  driver.findElement(By.xpath(s.getCell(0,i).getContents())).click();
 				  Thread.sleep(2000);
 				  }
 				  else if(s.getCell(2, i).getContents().equalsIgnoreCase("link"))
 				  {
 				  driver.findElement(By.linkText(s.getCell(0,i).getContents())).click();
 				  Thread.sleep(2000);
 				  }
 				  else if(s.getCell(2,i).getContents().equalsIgnoreCase("textbox"))
 				  {
 				  driver.findElement(By.id(s.getCell(0,i).getContents())).sendKeys(s.getCell(k,i).getContents());
 				  Thread.sleep(2000);
 				  }
 				  else if(s.getCell(2,i).getContents().equalsIgnoreCase("drop down"))
 				  {
 				  new Select(driver.findElement(By.id(s.getCell(0,i).getContents()))).selectByVisibleText(s.getCell(k,i).getContents());
 				 Thread.sleep(2000);
 				  }
 				  else if(s.getCell(2,i).getContents().equalsIgnoreCase("childwindow"))
 				  {
 					  Set<String> windows= driver.getWindowHandles();
 					  Object o[] = windows.toArray();
 					  driver.switchTo().window(o[1].toString());
 				  }
 				  else if(s.getCell(2, i).getContents().equalsIgnoreCase("mainwindow"))
				  {
 					Set<String> windows= driver.getWindowHandles();
					  Object o[] = windows.toArray();
					  driver.switchTo().window(o[0].toString());
				  }
 				  str="pass";
 			  }
 			  catch(Exception e)
 			  {
 				str="fail";
 			  }
 			 
 			 
 			 System.out.println();
 			 for(int j=0; j<s.getColumns(); j++)
 			 {
 				 System.out.print(s.getCell(j,i).getContents()+"\t\t");
 				 Label l1 = new Label(j,i, s.getCell(j,i).getContents());
 				 ws1.addCell(l1);
 			 }
 			 Label l2 = new Label(5,i,str);
 			 ws1.addCell(l2);
 			 
 		  }
 		  Label OR = new Label(0,0,"Object Repository");
 		  ws1.addCell(OR);
 		  Label DN = new Label(1,0,"Display Name");
 		  ws1.addCell(DN);
 		  Label OT = new Label(2,0,"Object type");
 		  ws1.addCell(OT);
 		  Label TD = new Label(3,0,"Testdata");
 		  ws1.addCell(TD);
 		  Label TD1 = new Label(4,0,"Testdata");
 		  ws1.addCell(TD1);
 		  Label Result = new Label(5,0,"Result");
		  ws1.addCell(Result);
 		  wb1.write();
 		  wb1.close();
 	   }
 	 
 	 }
  @BeforeTest
  public void beforeTest() 
  {
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
  
  }

}
