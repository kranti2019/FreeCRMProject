package com.crm.qa.tests;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LogonPage;
import com.crm.qa.pages.ShoppingCart;

public class ShoppingCartTest  extends TestBase
{
ShoppingCart shoppingcart;
LogonPage loginpage;
	public ShoppingCartTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Test()
	  public void ShoppingcartTest1() throws Exception
	  {
		  shoppingcart.clickbutton();
		  
		  
	  }
	 
	 
		  @BeforeMethod
		  public void setUp() throws InterruptedException, IOException
		  {
			 initialization();
			 System.out.println("1");
			  
			// LoginPageTest test=new LoginPageTest();
			 loginpage=new LogonPage();
			 //shoppingcart=loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
			  
		  }
		 
			
	  }


