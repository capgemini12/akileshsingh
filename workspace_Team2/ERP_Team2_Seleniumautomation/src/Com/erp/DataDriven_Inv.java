package Com.erp;

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
	
	public static int var=0;
  @Test
  public void Btn_Text_Loc() throws Exception
  {
      login();
	 // click_Login();
	 // login_Dashboard();
	  String path = "D:\\workspace_Team2\\ERP_Team2_Seleniumautomation\\Result\\Result1.xls";
	  FileOutputStream fo = new FileOutputStream(path);
	  WritableWorkbook wb = Workbook.createWorkbook(fo);
	  WritableSheet ws = wb.createSheet("Login", 0);
	  
	  
	  List<WebElement> t1 = driver.findElements(By.tagName("input"));
	  	  
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
			         var++;
			   }
			}
		         
		  else if(t1.get(i).getAttribute("value").equalsIgnoreCase("Log in"))
		  {
			  Label or3 = new Label(0, i+1, t1.get(i).getAttribute("name"));
			  Label ot3 = new Label(1,i+1,"Button");
			  ws.addCell(or3);
		      ws.addCell(ot3);
		      var++;
		  }
	  }
	  
	  List<WebElement> s = driver.findElements(By.tagName("select")); 
	  for(int j=var;j<s.size();j++)
	  {
		  if(s.get(j).getAttribute("name").equalsIgnoreCase("user_language[]"))
				  {
			        Label or1 = new Label(0,j+1,s.get(j).getAttribute("name"));
			        Label ot1 = new Label(1, j+1,"Dropdown" );
			        ws.addCell(or1);
			        ws.addCell(ot1);
			        var++;
				  }
	  }
	  wb.write();
	  wb.close();
	  
	  
	  
  }
  
  }


