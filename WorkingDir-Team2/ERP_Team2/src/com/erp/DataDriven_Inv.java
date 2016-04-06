package com.erp;

//import java.awt.Label;
import java.io.FileOutputStream;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DataDriven_Inv extends Helper{
	public static int var1=0;
  @Test
  public void Btn_Text_Loc() throws Exception
  {

	  click_Login();
	 // login_Dashboard();
	  String path = "D:\\WorkingDir-Team2\\ERP_Team2\\InputLocators\\InputLoc.xls";
	  FileOutputStream fo = new FileOutputStream(path);
	  WritableWorkbook wb = Workbook.createWorkbook(fo);
	  WritableSheet ws = wb.createSheet("Login", 0);
	  
	  
	  List<WebElement> t1 = driver.findElements(By.tagName("input"));
	  for(int j=0;j<t1.size();j++)
	  {
		  System.out.println("List Elements: "+t1.get(j).getText());	 
	  }
	 
	  for(int i=0; i<t1.size(); i++)
	  {
		  if(t1.get(i).getAttribute("value").equalsIgnoreCase(""))
			{
			  String check = t1.get(i).getAttribute("name");
		       
		       if((check.equals("username")) || (check.equals("password")))
		       {
		    	   System.out.println(check);
		    	   System.out.println("in check---->");
			      
			         Label or2 = new Label(0,i+1,check);
			         Label ot2 = new Label(1,i+1,"Textbox");
			         ws.addCell(or2);
			         ws.addCell(ot2);
			         var1++;
			         
			   }
			}
		         
		  else if(t1.get(i).getAttribute("value").equalsIgnoreCase("Log in"))
		  {
			  Label or3 = new Label(0, i+1, t1.get(i).getAttribute("name"));
			  Label ot3 = new Label(1,i+1,"Button");
			  ws.addCell(or3);
		      ws.addCell(ot3);
		      var1++;
		  }
	  }
	  
	  List<WebElement> s = driver.findElements(By.tagName("select")); 
	  for(int j=0;j<s.size();j++)
	  {
		  if(s.get(j).getAttribute("name").equalsIgnoreCase("user_language[]"))
				  {
			        Label or1 = new Label(0,var1+1,s.get(j).getAttribute("name"));
			        Label ot1 = new Label(1, var1+1,"Dropdown" );
			        ws.addCell(or1);
			        ws.addCell(ot1);
			        var1++;
				  }
	  }
	  wb.write();
	  wb.close();
	  
	  
	  
  }
  
  }


