package Com.erp;

import org.testng.annotations.Test;

public class Inventory extends Helper{
	
  @Test(description="Verify login")
  public void testo1() throws Exception {
	  login();
  }
  
  @Test(description="Verify New Account")
  public void testo2() throws Exception {
	 // login();
	  NewAccount();
  }
  @Test(description="userlogin")
  public void testo3() throws Exception {
	  driver.get("http://localhost/erp/extensions/user/user_login.php");
	  Thread.sleep(1000);
	  userlogin();
	 // NewAccount();
  }
  @Test(description="Inventory")
  public void testo4() throws Exception {
	  
	  Thread.sleep(1000);
	  Inventory();
  }
  @Test(description="Handling Ajax")
  public void testo5() throws Exception {
	  
	  Thread.sleep(1000);
	  itemNum_ajax();
  }
  @Test(description="Dashboard_allLink")
  public void testo6() throws Exception {
	  
	  Thread.sleep(5000);
	  Dashboard_allLink();
  }
  @Test(description="Inventory_allLink")
  public void testo7() throws Exception {
	  
		  Thread.sleep(5000);
		  Inventory_allLink();
	
	}
	  
	
  @Test(description="itemmasterall_links")
  public void testo8() throws Exception {
	  Thread.sleep(5000);
	  item_masterall_links();
  }
  @Test(description="Org_ID_17")
  public void testo9() throws Exception {
	  Thread.sleep(5000);
	  Org_ID() ;
  }


}

  
  

