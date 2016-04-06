package com.erp;

import org.testng.annotations.Test;

public class Inventory extends Helper {

  @Test(description = "Verify Login Button on Home page")
  public void test01() throws Exception {
	    click_Login();
  }
 
  @Test(description = "Create New Account")
  public void test02() throws Exception{
	  newAct_Create();
  }
  
  @Test(description = "Login Into Dashboard")
  public void test03() throws Exception{
	  login_Dashboard();
  }
  @Test(description = "Handle Windows when we click on Item Id")
  public void test04() throws Exception{
	  handle_Windows();
  }
  @Test(description = "Handle Ajax in Item Number")
  public void test05() throws Exception{
	  handle_Ajax();
  }
  @Test(description = "Print all the links on dashboard")
  public void test06() throws Exception{
	  links_Dashboard();
  }
  @Test(description = "Print all the links on Inventory page")
  public void test07() throws Exception{
	  //click_Login();
	  login_Dashboard();
	  links_Inv();
  }
  @Test(description = "Writing to excel")
  public void test08() throws Exception{
	  write_Excel();
  }
  
  
}
