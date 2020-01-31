package com.crm.qa.tests;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.internal.reflect.MethodMatcherException;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LogonPage;
import com.crm.qa.pages.RegistrationPage;

import com.crm.qa.util.TestUtil1;

public class RegistrationTest extends TestBase
//extends TestBase
{
	LogonPage loginpage;

	RegistrationPage registerpage1;
	TestUtil1 testUtil;
	WebDriverWait wait;
	//String sheetName = "Login";
  //static ReadAvacticsExcel rd1;
  public RegistrationTest() throws IOException, InterruptedException
  {
	 
      super();
      initialization();
      registerpage1=new RegistrationPage();
  }
  
	//String sheetName = "registration";
	
	  @Test(dataProvider ="AvacticsLoginData")
	  public void RegistrationTest1(String email1,String password1,String password2,String firstname1,String lastname1,String zipcode1,String city1,String address3
				,String address4,String contact) throws InterruptedException,MethodMatcherException 
	  {
		  System.out.println("...."+email1);
		 
		  registerpage1.registration(email1, password1, password2, firstname1, lastname1, zipcode1, city1, address3, address4, contact);
	  
		 // registerpage.clickbutton();
	  }
	  
		 @Test(priority = 1)
		 public  void test1() 
		 {
	  String expectedmsg = "Account created successfully. You are now registered.";
	    System.out.println(")))))))))))))))))))))))"+expectedmsg);
    		 
	    Assert.assertEquals(registerpage1.validatesucessmsg(), expectedmsg);
		 }
    
		 @Test(priority = 2)
		 public  void test2() 
		 {
			 
      String expectedmsg1="This account name is already taken. Please choose a different account name.";
      Assert.assertEquals(registerpage1.validateduplicateemail(), expectedmsg1);
		 }
		 @Test(priority =3)
		 public  void test3() 
		 {
      String expectedmsg2="The password you entered is incorrect. Please enter the correct password.";
      Assert.assertEquals(registerpage1.validateinvalidpwd(), expectedmsg2);
		 }
		 @Test(priority =4)
		 public  void test4() 
		 {
      String expectedmsg3="Invalid data in field 'E-mail'.";
      Assert.assertEquals(registerpage1.validateinvalidemail(), expectedmsg3);
		 }
      
		 
	  
	@BeforeMethod
	public void setUp() throws InterruptedException, IOException 
	{
		
		 
		 System.out.println("1");
		 registerpage1.clickbutton();
		 
		//registerpage1=new RegistrationPage();
			 // rt1.get();
		testUtil = new TestUtil1();
		
	}

	
	
	@DataProvider (name="AvacticsLoginData")
	  public static Object[][] getLoginData() throws InvalidFormatException 
	  {
		//rd1=new ReadAvacticsExcel();
		
		System.out.println("11111111111111111111");
		Object data[][]=TestUtil1.getTestData("LoginData");
				 // ReadAvacticsExcel.getDataFromXLSUsingJXL("E:\\Test.xls", "LoginData1", "StartAndEnd");
		  System.out.println("....................tryty............."+data.length);
	        return data;
	  }


	@AfterMethod
	public void tearDown(){
	
		//driver.quit();
	}
	
	
	
	
}
