package com.ERP;

import org.testng.annotations.Test;

public class Inventory extends Helper {
  @Test(description="Login")
  public void test01() throws Exception {
	  
	  login();
	    
  }
  
  @Test(description="Navigation to Item Master")
  public void test02() throws Exception
  
  {
	  Item_Master_Navigation();
	  
	   
  }
  
  
}
