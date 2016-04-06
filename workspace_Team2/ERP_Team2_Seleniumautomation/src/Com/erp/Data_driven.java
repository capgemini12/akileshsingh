package Com.erp;

import java.io.FileOutputStream;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Data_driven extends Helper {
	
	 @Test(description="Verify login")
	  public void testo1() throws Exception {
		  login();
	  }
	 
	 @Test(description="Inventory")
	  public void testo4() throws Exception {
		  
		  Thread.sleep(1000);
		  Inventory();
	  }
	 @Test(description="Print xls sjheet")
	 public void Printxls() throws Exception
	 {
		 FileOutputStream fo=new FileOutputStream("D:\\workspace_Team2\\ERP_Team2_Seleniumautomation\\Result\\result.xls");
		  WritableWorkbook wb=Workbook.createWorkbook(fo);
		  WritableSheet ws=wb.createSheet("Result1", 0);
		  Label OR=new Label(0,0,"Locator");
		  Label DisNam=new Label(1,0,"DisplayName");
		  Label OType=new Label(2,0,"ObjectType");
		  ws.addCell(OR);
		  ws.addCell(DisNam);
		  ws.addCell(OType);
		  wb.write();
		  wb.close();
	 }
	 
	 
	 
	 
	 
}
