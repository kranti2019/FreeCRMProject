package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class RegistrationPage extends TestBase 
{
	//Page Factory - OR:
		//private WebDriver driver;
		WebDriverWait wait;
		

		@FindBy (xpath = "//a[contains(.,'My Account')]")
		private WebElement myacc;
		
		
		@FindBy (xpath = "//button[contains(.,'Register')]")
		private WebElement register;
		//button[contains(.,'Register')]
		
		@FindBy (name = "customer_info[Customer][Email]")
		@CacheLookup
		private WebElement email;

//		@FindBy (name = "customer_info[Customer][Password]]")
	    @FindBy (xpath="//input[@name='customer_info[Customer][Password]']")
	    private WebElement password;

		@FindBy (name = "customer_info[Customer][RePassword]")
		private WebElement repassword;

		@FindBy (name = "customer_info[Customer][FirstName]")
		private WebElement firstname;

		@FindBy (name = "customer_info[Customer][LastName]")
		private WebElement lastname;
		
		
		@FindBy(id="customer_info_Customer_Country")
		WebElement country;
		
		@FindBy(id="customer_info_Customer_State")
		WebElement state;

		@FindBy (name = "customer_info[Customer][ZipCode]")
		private WebElement zipcode;

		@FindBy (name = "customer_info[Customer][City]")
		private WebElement city;

		@FindBy (name = "customer_info[Customer][Streetline1]")
		private WebElement address1;

		@FindBy (name = "customer_info[Customer][Streetline2]")
		private WebElement address2;

		@FindBy (name = "customer_info[Customer][Phone]")
		private WebElement phone;

		@FindBy (xpath = "//input[@value='Register']")
		private WebElement registerButton;
		
		@FindBy (xpath = "//div[@class='myaccount_home']/div[@class='note note-success']")
		private WebElement verifysucess;
		
		@FindBy (xpath = "//div[@class='registration_form']/div[@class='note note-danger'][1]")
		private WebElement verifypwdfailure;
		
		@FindBy (xpath = "//div[@class='registration_form']/div[@class='note note-danger']")
		private WebElement verifyduplicateemail;
		
		@FindBy (xpath = "//div[@class='registration_form']/div[@class='note note-danger'][2]")
		private WebElement verifyemailfailure;
		
		//Initializing the Page Objects:
		public RegistrationPage()
				throws IOException 
		{
			super();
			PageFactory.initElements(driver, this);
			// TODO Auto-generated constructor stub
		}
		public void registration(String email1, String password1,String password2,String firstname1,
				 String lastname1,String zipcode1,String city1,String address3,String address4,String contact) throws InterruptedException
				 
				 {
			PageFactory.initElements(driver, this);
			System.out.println(email1+"....."+password1+"...."+email);
					 
					    email.clear();
						email.sendKeys(email1);
						
					   /* password =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='customer_info[Customer][Password]']")));
						password.sendKeys(password1);*/
						
						password.clear();
						password.sendKeys(password1);
					//	wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(password1);
						
						repassword.clear();
						//wait.until(ExpectedConditions.visibilityOf(repassword)).sendKeys(password2);
						(repassword).sendKeys(password2);
						
						firstname.clear();
						(firstname).sendKeys(firstname1);
						
						lastname.clear();
						(lastname).sendKeys(lastname1);
						
						//Select select=new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer_info[Customer][Country]"))));
						
						Select select=new Select(country);
						//wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer_info[Customer][Country]"))));
					    select.selectByVisibleText("India");
					    
					    //Select select1=new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer_info[Customer][State]"))));
					    Select select1=new Select(state);
						select1.selectByVisibleText("Maharashtra");
						
						zipcode.clear();
						(zipcode).sendKeys(zipcode1.toString());
						
						city.clear();
						(city).sendKeys(city1);
						
						address1.clear();
						(address1).sendKeys(address3);
						
						address2.clear();
						(address2).sendKeys(address4);
						
						
						phone.clear();
						(phone).sendKeys(contact.toString());
						
						
						registerButton.click();
				 }
		
		//Success assert
		public String validatesucessmsg(){
			
			String actualmsg=verifysucess.getText();
			return actualmsg;
			//assertEquals(actualmsg,expectedmsg);
		}
		
		//EmailFailure Assert
		public String validateinvalidemail()
		{
			
			String actualmsg=verifyemailfailure.getText();
			return actualmsg;
			//assertEquals(actualmsg,expectedmsg);
		}
		
		//Duplicateaccount Assert
		public String validateduplicateemail()
		{
				
				String actualmsg=verifyduplicateemail.getText();
				return actualmsg;
				//assertEquals(actualmsg,expectedmsg);
		}
			
		//Invalidpwd Assert
		public String validateinvalidpwd()
		{
						
		String actualmsg=verifypwdfailure.getText();
		return actualmsg;
		//assertEquals(actualmsg,expectedmsg);
		}
					
			
	/*public String validatefailuremsg()
	  {
		String message=null;
		
		
			wait.until(ExpectedConditions.visibilityOf(verifyemailfailure));
			if(verifyemailfailure.getText().contains("Invalid data in field 'E-mail'."))
			{
			String actualmsg1=verifyemailfailure.getText();
			message=actualmsg1;
			//System.out.println(actualmsg1);
			return message;
			}
			else if(verifyduplicateemail.getText().contains("This account name is already taken. Please choose a different account name."))
			{
			String actualmsg1=verifyduplicateemail.getText();
			message=actualmsg1;
			//System.out.println(actualmsg1);
			return message;
			}
			else if(verifypwdfailure.getText().contains("The password you entered is incorrect. Please enter the correct password."))
			{
			String actualmsg1=verifypwdfailure.getText();
			//System.out.println(actualmsg1);
			message=actualmsg1;
			return message;
			}
			else
			{
				System.out.println("No Error msg");
				return  message;
				
			}
		}*/
		public void clickbutton() throws InterruptedException{
			
			myacc.click();
			register.click();
//			wait.until(ExpectedConditions.visibilityOf(myacc)).click();
//			wait.until(ExpectedConditions.visibilityOf(register)).click();
		}



		
	}



