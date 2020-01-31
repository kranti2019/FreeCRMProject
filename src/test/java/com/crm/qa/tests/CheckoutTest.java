package com.crm.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CheckoutPage;
import com.crm.qa.pages.LogonPage;

public class CheckoutTest extends TestBase
{
	LogonPage loginpage;
	CheckoutPage checkoutpage;
	public CheckoutTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test()
	  public void  CheckoutTest1() throws Exception
	  {
		checkoutpage.clickbutton1();
		checkoutpage.clickbutton2();
    	checkoutpage.verifyBillingAdd();
    	checkoutpage.clickbutton3();
    	
//		checkoutpage.verifyShippingAdd();
		//checkoutpage.clickbutton1();
    	//Billing Address Verification
    	 String expectedmsg1="vijay kaple";
         Assert.assertEquals(checkoutpage.validateinvalidBillingadd(), expectedmsg1);
         String expectedmsg2="vijay.kaple@gmail.com";
         Assert.assertEquals(checkoutpage.validateinvalidBillingadd1(), expectedmsg2);
		  
     	//Shipping Address Verification
         String expectedmsg3="vijay kaple";
         Assert.assertEquals(checkoutpage.validateinvalidShippingadd(), expectedmsg3);
         String expectedmsg4="Maharashtra 411021";
         Assert.assertEquals(checkoutpage.validateinvalidShippingadd1(), expectedmsg4);
	  }
	 
	 
		  @BeforeMethod
		  public void setUp() throws InterruptedException, IOException
		  {
			 initialization();
			 System.out.println("1");
			  
			// LoginPageTest test=new LoginPageTest();
			/* loginpage=new LogonPage();
			 checkoutpage=loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));*/
			  
		  }
		 
			
	  }


