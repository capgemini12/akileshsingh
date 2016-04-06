package datadriven;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Set;

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

public class Driver_Results {
	public WebDriver driver;
	String str;
  @Test
  public void f() throws Exception {
	  DateFormat df=new SimpleDateFormat("yyyy_MMM_dd hh_mm_ss");
	  Date d=new Date(0);
	  String time=df.format(d);
	  
	  
FileInputStream fi=new FileInputStream("D:\\workspace_Team4\\SeleniumAutomation\\Testdata\\Driver.xls");
Workbook w=Workbook.getWorkbook(fi);
Sheet s=w.getSheet(0);

FileOutputStream fo=new FileOutputStream("D:\\workspace_Team4\\SeleniumAutomation\\Result\\Driver_Results"+time+".xls");
WritableWorkbook wb=Workbook.createWorkbook(fo);
WritableSheet ws=wb.createSheet("Result", 0);

for(int i=0;i<s.getRows();i++){
	try{
	if(s.getCell(2, i).getContents().equalsIgnoreCase("Text box")){
		driver.findElement(By.name(s.getCell(0, i).getContents())).sendKeys(s.getCell(3, i).getContents());
	}
	else if(s.getCell(2, i).getContents().equalsIgnoreCase("Button")){
		driver.findElement(By.xpath(s.getCell(0, i).getContents())).click();
	}
	
	else if(s.getCell(2, i).getContents().equalsIgnoreCase("link")){
		driver.findElement(By.linkText(s.getCell(0, i).getContents())).click();
	}
	else if(s.getCell(2, i).getContents().equalsIgnoreCase("URL")){
		driver.get(s.getCell(0, i).getContents());
	}
	else if(s.getCell(2, i).getContents().equalsIgnoreCase("wait")){
		Thread.sleep(3000);
	}
	else if(s.getCell(2, i).getContents().equalsIgnoreCase("drop down")){
		new Select(driver.findElement(By.xpath(s.getCell(0, i).getContents()))).selectByVisibleText(s.getCell(3, i).getContents());
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
	 str="Pass";
	
	}catch(Exception e){str="Fail";}
  Label result=new Label(6,i,str);
  ws.addCell(result);
  for(int j=0;j<s.getColumns();j++){
	  System.out.println(s.getCell(j, i).getContents());
	  Label l=new Label(j, i, s.getCell(j, i).getContents());
	  ws.addCell(l);
  }
  

}
Label ob=new Label(0, 0, "Object Repository");
Label dn=new Label(1, 0, "Display Name");
Label ot=new Label(2, 0, "Object Type");
Label td1=new Label(3, 0, "Testdata1");
Label td2=new Label(4, 0, "Testdata2");
Label td3=new Label(5, 0, "Testdata3");
Label res=new Label(6, 0, "Result");
ws.addCell(ob);
ws.addCell(dn);
ws.addCell(ot);
ws.addCell(td1);
ws.addCell(td2);
ws.addCell(td3);
ws.addCell(res);

wb.write();
wb.close();
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
