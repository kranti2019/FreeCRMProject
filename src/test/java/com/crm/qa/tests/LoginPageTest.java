package com.crm.qa.tests;

import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CheckoutPage;
import com.crm.qa.pages.FinalCheckoutPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LogonPage;
import com.crm.qa.pages.ShoppingCart;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class LoginPageTest extends TestBase 
{
	LogonPage loginpage;
	CheckoutPage sc;
	ShoppingCart sc1;
	FinalCheckoutPage fc;
	
	public LoginPageTest() throws IOException
	{
		
		super();
		initialization();
	}
	
   @BeforeMethod
  public void setUp() throws InterruptedException, IOException
  {
	 System.out.println("1");
	  
	// LoginPageTest test=new LoginPageTest();
	  loginpage=new LogonPage();
	  
  }
   @Test(priority=1)
   public void loginpageTitleTest()
   {
	   String title=loginpage.validateLoginpage();
	   Assert.assertEquals(title, "Avactis Demo Store");
   }
   
   @Test(priority=2)
   public void avacticsLogoTest()
   {
	   boolean flag=loginpage.validateAvacticsLogo();
	   Assert.assertTrue(flag);
   }
   @Test(priority=3)
   public void LoginTest() throws IOException
   {
	   fc=loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
   }
   @AfterMethod
   public void tearDown()
   {

   //	driver.quit();
   }
}

  