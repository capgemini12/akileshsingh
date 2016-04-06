package datadriven;

import java.io.FileInputStream;
import java.util.Set;

import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Driver_Multisheets {
	public WebDriver driver;
	Sheet s;
  @Test
  public void f() throws Exception{
	  FileInputStream fi=new FileInputStream("D:\\workspace_Team4\\SeleniumAutomation\\Testdata\\Driver_Multisheets.xls");
	  Workbook w=Workbook.getWorkbook(fi);
	  for(int j=0;j<w.getNumberOfSheets();j++){
		  s=w.getSheet(j);
		  for(int i=0;i<s.getRows();i++){
 if(s.getCell(2, i).getContents().equalsIgnoreCase("URL")){
	 driver.get(s.getCell(0, i).getContents());
			  }
 else if(s.getCell(2, i).getContents().equalsIgnoreCase("link")){
	 driver.findElement(By.linkText(s.getCell(0, i).getContents())).click();
 }
 else if(s.getCell(2, i).getContents().equalsIgnoreCase("Text box")){
	 driver.findElement(By.name(s.getCell(0, i).getContents())).sendKeys(s.getCell(3, i).getContents());
 }
 else if(s.getCell(2, i).getContents().equalsIgnoreCase("drop down")){
	 new Select(driver.findElement(By.xpath(s.getCell(0, i).getContents()))).selectByVisibleText(s.getCell(3, i).getContents());
 }
 else if(s.getCell(2, i).getContents().equalsIgnoreCase("Button")){
	 driver.findElement(By.xpath(s.getCell(0, i).getContents())).click();
 }
 else if(s.getCell(2, i).getContents().equalsIgnoreCase("wait")){
	 Thread.sleep(2000);
 }
 else if(s.getCell(2, i).getContents().equalsIgnoreCase("image")){
	 driver.findElement(By.xpath(s.getCell(0, i).getContents())).click();
 }
 else if(s.getCell(2, i).getContents().equalsIgnoreCase("popup")){
	 Set<String> windows = driver.getWindowHandles();
	 Object win[]=windows.toArray();
	 driver.switchTo().window(win[1].toString());
 }
 else if(s.getCell(2, i).getContents().equalsIgnoreCase("main")){
	 Set<String> windows = driver.getWindowHandles();
	 Object win[]=windows.toArray();
	 driver.switchTo().window(win[0].toString());
 }
		  }
	  }
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
