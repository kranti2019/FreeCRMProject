package com.crm.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LogonPage;

public class HomePageTest extends TestBase
{

	public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	/*LogonPage loginpage;
	HomePage homepage;
	public HomePageTest() throws IOException
	{
		super();
		
		// TODO Auto-generated constructor stub
	}
	 @BeforeMethod
	  public void setUp() throws InterruptedException, IOException
	  {
		 initialization();
		 System.out.println("1");
		  
		// LoginPageTest test=new LoginPageTest();
		 loginpage=new LogonPage();
		 homepage=loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
		  
	  }
	   @Test(priority=1)
	  
	   public void clickApparel() throws IOException
	   {
		  homepage.apparel();
	   }
	   @Test(priority=2)
	   public void userNameTest()
	   {
		   boolean flag1=homepage.validateHomepage();
		   Assert.assertTrue(flag1);
	   }
	   
	   @AfterMethod
	   public void tearDown()
	   {

	   driver.quit();
	   }*/
	}

	  


