package Com.erp;

import java.io.FileInputStream;
import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DataDriven_Script extends Helper
{
	public WebDriver driver;
  @Test
  public void Read_Excel() throws Exception 
  {
	  FileInputStream fis = new FileInputStream("D:\\WorkingDir-Team2\\ERP_Team2\\Results\\Input.xls");
	  Workbook wb = Workbook.getWorkbook(fis);
	  Sheet s = wb.getSheet(0);
	  for(int i=1;i<s.getRows();i++)
	 {
		  try
		  {
			  
					  if(s.getCell(2,i).getContents().equalsIgnoreCase("Link"))
					  {
			          System.out.println("In Links");
			         // windows_Handler();
			          System.out.println(driver.getWindowHandle());
			          driver.findElement(By.xpath(s.getCell(0,i).getContents())).click();
		              }
		  else if(s.getCell(2, i).getContents().equalsIgnoreCase("Button"))
		  {
			  System.out.println("In Button");
			  driver.findElement(By.name(s.getCell(0, i).getContents())).click();
		  }
		  else if(s.getCell(2, i).getContents().equalsIgnoreCase("Textbox"))
		  {
			  System.out.println("In textbox");
			 driver.findElement(By.name(s.getCell(0, i).getContents())).clear();
			 Thread.sleep(2000);
			 driver.findElement(By.name(s.getCell(0, i).getContents())).sendKeys(s.getCell(3, i).getContents());	  
		  }
		  else if(s.getCell(2, i).getContents().equalsIgnoreCase("Dropdown"))
		  {
			  System.out.println("In Dropdown");
			//  windows_Handler();
			  new Select(driver.findElement(By.id(s.getCell(0, i).getContents()))).selectByVisibleText(s.getCell(3, i).getContents());
			  
		  }else if(s.getCell(2, i).getContents().equalsIgnoreCase("wait"))
		  {
			  Thread.sleep(3000);
		  }
		  } catch (Exception e) {
				// TODO: handle exception
			}		  
	  }
	  
	  
  }
}
