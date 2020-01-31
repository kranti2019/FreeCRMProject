package com.crm.qa.tests;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CheckoutPage;
import com.crm.qa.pages.FinalCheckoutPage;
import com.crm.qa.pages.LogonPage;

public class FinalCheckoutTest extends TestBase
{
	LogonPage loginpage;
	FinalCheckoutPage finalcheckoutpage;
	public FinalCheckoutTest() throws IOException 
	{
		super();
		finalcheckoutpage=new FinalCheckoutPage();
		// TODO Auto-generated constructor stub
	}

	@Test()
	public void  CheckoutTest1() throws Exception
	{
		finalcheckoutpage.validateinvalidProductbyValue("Apple MacBook Air");
		
		/*
		finalcheckoutpage.validateinvalidProduct2();
		finalcheckoutpage.validateinvalidProduct3();
		finalcheckoutpage.validateinvalidProduct4();
		finalcheckoutpage.validateinvalidProduct5();*/
	}


	@BeforeMethod
	public void setUp() throws InterruptedException, IOException
	{
		initialization();
		System.out.println("1");

		LoginPageTest test=new LoginPageTest();
		loginpage=new LogonPage();
	     finalcheckoutpage=loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));

	}


}




