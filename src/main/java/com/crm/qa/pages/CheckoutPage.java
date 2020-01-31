package com.crm.qa.pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class CheckoutPage extends TestBase 
{
//Shipping Address Page Factory
	//Firstname
	@FindBy (xpath = "//input[@name='shippingInfo[Firstname]']")
	private WebElement ShipFN;
	//Lastname
	@FindBy (xpath = "//input[@name='shippingInfo[Lastname]']")
	private WebElement ShipLN;
	//Email
	@FindBy (xpath = "//input[@name='shippingInfo[Email]']")
	private WebElement ShipEmail;
	//Country dropdown
	@FindBy (xpath = "//select[@name='shippingInfo[Country]']")
	private WebElement ShipCountry;
    //ZIP Code
	@FindBy (xpath = "//input[@name='shippingInfo[Postcode]']")
	private WebElement ShipZIPcode;
    //State Dropdown
	@FindBy (xpath = "//select[@name='shippingInfo[Statemenu]']")
	private WebElement ShipState;
	//City
	@FindBy (xpath = "//input[@name='shippingInfo[City]']")
	private WebElement ShipCity;
    //Addrees1
	@FindBy (xpath = "//input[@name='shippingInfo[Streetline1]']")
	private WebElement ShipAdd1;
    //Addrees2
	@FindBy (xpath = "//input[@name='shippingInfo[Streetline2]']")
	private WebElement ShipAdd2;
    //Contact no.
	@FindBy (xpath = "//input[@name='shippingInfo[Phone]']")
	private WebElement ShipContact;
	//Checkbox1
	@FindBy (xpath = "//input[@name='checkbox_shipping_same_as_billing']")
	private WebElement ShipCheckbox3;
	//BillingAddVerify
	@FindBy (xpath = "(//label[@class='control-label col-lg-10'][contains(.,'vijay kaple')])[2]")
	private WebElement VerifyBillingAdd1;
	@FindBy (xpath =  "(//label[@class='control-label col-lg-10'][contains(.,'vijay.kaple@gmail.com')])[2]")
	private WebElement VerifyBillingAdd2;
	//ShippingAddVerify
	@FindBy (xpath = "(//label[@class='control-label col-lg-10'][contains(.,'vijay kaple')])[1]")
	private WebElement VerifyShippingAdd1;
	@FindBy (xpath =  "(//label[@class='control-label col-lg-10'][contains(.,'Maharashtra 411021')])[1]")
	private WebElement VerifyShippingAdd2;
	//SelectShippingOption
	@FindBy (xpath = "//input[@value='BCE5D24D-666C-43CA-94A0-D6F775903BE2_1']")
	private WebElement ShippingOption;
	//Continue2
	@FindBy (xpath = "//input[@onclick='submitStep(2);']")
	private WebElement Step2;
	public CheckoutPage() throws IOException 
	{
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickbutton1() throws Exception
	{
		String checkout="//a[@href='checkout.php'][contains(.,'Checkout')]";
		driver.findElement(By.xpath(checkout)).click();
		
		
				
      
	}
	public void clickbutton2() throws Exception
	{/*
		if(!ShipCheckbox3.isSelected())
		{
			ShipCheckbox3.click();
		}
		String checkbox2="//input[@name='subscriptionTopics[Topics][1]']";
		driver.findElement(By.xpath(checkbox2)).click();
		String continueshopping="//input[@onclick='submitStep(1);']";
		driver.findElement(By.xpath(continueshopping)).click();*/
		ShipCheckbox3.click();
		String continueshopping="//input[@onclick='submitStep(1);']";
		driver.findElement(By.xpath(continueshopping)).click();
		String isChecked=ShipCheckbox3.getAttribute("checked");
		System.out.println("+++++++++++++++++++++++++"+isChecked);
		
		if(isChecked=="true")
		{
			verifyBillingAdd();
		}
		else 
		{

		}
		
	}
	
	
	public void clickbutton3() throws Exception
	{
		Thread.sleep(1000);
		  ShippingOption.click();
			Step2.click();
	}
	
	//VerifyBillingAddress
	
	public String validateinvalidBillingadd()
	{
		
		String actualmsg=VerifyBillingAdd1.getText();
		System.out.println(")))))))))))))))))))))))))))))))))))))))))))))))))"+actualmsg);
		
		return actualmsg;
		//assertEquals(actualmsg,expectedmsg);
	}
	public String validateinvalidBillingadd1()
	{
		
		String actualmsg1=VerifyBillingAdd2.getText();
		System.out.println(")))))))))))))))))))))))))))))))))))))))))))))))))"+actualmsg1);
		return actualmsg1;
		//assertEquals(actualmsg,expectedmsg);
	}
	//VerifyShippingAddress
	
		public String validateinvalidShippingadd()
		{
			
			String actualmsg2=VerifyShippingAdd1.getText();
			System.out.println(")))))))))))))))))))))))))))))))))))))))))))))))))"+actualmsg2);
			
			return actualmsg2;
			//assertEquals(actualmsg,expectedmsg);
		}
		public String validateinvalidShippingadd1()
		{
			
			String actualmsg3=VerifyShippingAdd2.getText();
			System.out.println(")))))))))))))))))))))))))))))))))))))))))))))))))"+actualmsg3);
			return actualmsg3;
			//assertEquals(actualmsg,expectedmsg);
		}

	public void verifyBillingAdd() throws Exception
		{
			//FirstName
			String FN=driver.findElement(By.xpath("//input[@name='billingInfo[Firstname]']")).getAttribute("value");
		    System.out.println("Billing Address-FirstName: "+FN);
		    
		    String VShipFN=driver.findElement(By.xpath("//input[@name='shippingInfo[Firstname]']")).getAttribute("value");
			System.out.println("Shipping Address-FirstName: "+VShipFN);
		
			
			int valid=stringCompare(FN, VShipFN);
			
			if(valid!=0)
			{
				//Shipping Address
				//PageFactory.initElements(driver, this);
				//Firstname
				String ShipFN1="Arachana";
				ShipFN.clear();
				ShipFN.sendKeys(ShipFN1);
			}
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			//LastName
						
			String VShipLN=driver.findElement(By.xpath("//input[@name='shippingInfo[Lastname]']")).getAttribute("value");
			System.out.println("Shipping Address-LastName: "+VShipLN);
			
			String LN=driver.findElement(By.xpath("//input[@name='billingInfo[Lastname]']")).getAttribute("value");
		    System.out.println("Billing Address-LastName: "+LN);
		    
		   
		    int valid1=stringCompare(LN, VShipLN);
		    if(valid1!=0)
			{
				//Shipping Address
				//PageFactory.initElements(driver, this);
				//Lastname
				String ShipLN1="Pawashe";
				ShipLN.clear();
				ShipLN.sendKeys(ShipLN1);
			}
		    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		  //Email
	        String email=driver.findElement(By.xpath("//input[@name='billingInfo[Email]']")).getAttribute("value");
		    System.out.println("Billing Address-E-mail ID: "+email);
		  
			String VShipEmail=driver.findElement(By.xpath("//input[@name='shippingInfo[Email]']")).getAttribute("value");
			System.out.println("Shipping Address-Email: "+VShipEmail);

		    int valid2=stringCompare(email,VShipEmail);
		    if(valid2!=0)
			{
				//Shipping Address
				//PageFactory.initElements(driver, this);
				
				String Shipemail1="Pawashe.arachana@gmail.com";
				ShipEmail.clear();
				ShipEmail.sendKeys(Shipemail1);
			}
		    
		    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		    //Country dropdown
		    Select select = new Select(driver.findElement(By.xpath("//select[@name='billingInfo[Country]']")));
		    WebElement option = select.getFirstSelectedOption();
		    String country = option.getText();
	 	    System.out.println("Billing Address-Country: "+country );
		     //Country dropdown
			  Select select1= new Select(driver.findElement(By.xpath("//select[@name='shippingInfo[Country]']")));
			  WebElement option1 = select1.getFirstSelectedOption();
			  String Vcountry = option1.getText();
			  System.out.println("Shipping Address-Country: "+Vcountry);
			  int valid3=stringCompare(country,Vcountry);
			    if(valid3!=0)
				{
					//Shipping Address
				//PageFactory.initElements(driver, this);
					
					Select select2=new Select(ShipCountry);
				    select2.selectByVisibleText("Canada");
				    
				}
			    
			    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			  //ZIP Code
			    String zipcode=driver.findElement(By.xpath("//input[@name='billingInfo[Postcode]']")).getAttribute("value");
			    System.out.println("Billing Address-ZIP Code: "+zipcode);
			  //ZIP Code
				 String VShipZIPcode=driver.findElement(By.xpath("//input[@name='shippingInfo[Postcode]']")).getAttribute("value");
				 System.out.println("Shipping Address-Zip code: "+VShipZIPcode);
				  int valid4=stringCompare(zipcode,VShipZIPcode);
				    if(valid4!=0)
					{
						//Shipping Address
					//PageFactory.initElements(driver, this);
				    	String ShipZIPcode1="411042";
				    	ShipZIPcode.clear();
				    	ShipZIPcode.sendKeys(ShipZIPcode1);
					    
					}
				    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				    //State Dropdown
				    Select select2 = new Select(driver.findElement(By.xpath("//select[@name='billingInfo[Statemenu]']")));
				    WebElement option7 = select2.getFirstSelectedOption();
				    String state = option7.getText();
				    System.out.println("Billing Address-State: "+state );
				  //State Dropdown
					 Select select6 = new Select(driver.findElement(By.xpath("//select[@name='shippingInfo[Statemenu]']")));
					  WebElement option8 = select2.getFirstSelectedOption();
					  String Vstate = option8.getText();
					  System.out.println("Shipping Address-state: "+Vstate);
					  int valid5=stringCompare(state,Vstate);
					    if(valid5!=0)
						{
							//Shipping Address
						//PageFactory.initElements(driver, this);
							
					    	Select selec6=new Select(ShipState);
						    select6.selectByVisibleText("Alberta");
						    
						}
					    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
					    //City
					    String city=driver.findElement(By.xpath("//input[@name='billingInfo[City]']")).getAttribute("value");
					    System.out.println("Billing Address-City : "+city);
					  //City
						  String VShipCity=driver.findElement(By.xpath("//input[@name='shippingInfo[City]']")).getAttribute("value");
						  System.out.println("Shipping Address-City: "+VShipCity);
						  
						  int valid6=stringCompare(city,VShipCity);
						    if(valid6!=0)
							{
								//Shipping Address
							//PageFactory.initElements(driver, this);
						    	String ShipCity1="Atlanta";
						    	ShipCity.clear();
						    	ShipCity.sendKeys(ShipCity1);
							    
							}
						///////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
					    //Addrees1
					    String add1=driver.findElement(By.xpath("//input[@name='billingInfo[Streetline1]']")).getAttribute("value");
					    System.out.println("Billing Address-Address1 : "+add1);
					    String VShipAdd1=driver.findElement(By.xpath("//input[@name='shippingInfo[Streetline1]']")).getAttribute("value");
						System.out.println("Shipping Address-Address1:  "+VShipAdd1);
						 int valid7=stringCompare(add1,VShipAdd1);
						    if(valid7!=0)
							{
								//Shipping Address
							//PageFactory.initElements(driver, this);
						    	String ShipAdd3="Periwinkle Society,Baner";
						    	ShipAdd1.clear();
						    	ShipAdd1.sendKeys(ShipAdd3);
							    
							}
						    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
					    //Addrees2
					    String add2=driver.findElement(By.xpath("//input[@name='billingInfo[Streetline2]']")).getAttribute("value");
					    System.out.println("Billing Address-Address2 : "+add2);
					    //Addrees2
						  String VShipAdd2=driver.findElement(By.xpath("//input[@name='shippingInfo[Streetline2]']")).getAttribute("value");
						  System.out.println("Shipping Address-Address2:  "+VShipAdd2);
						  int valid8=stringCompare(add2,VShipAdd2);
						    if(valid8!=0)
							{
								//Shipping Address
							//PageFactory.initElements(driver, this);
						    	String ShipAdd4="Sus,Baner";
						    	ShipAdd2.clear();
						    	ShipAdd2.sendKeys(ShipAdd4);
							    
							}
						    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					    //Contact no.
						  String VShipContact=driver.findElement(By.xpath("//input[@name='shippingInfo[Phone]']")).getAttribute("value");
						  System.out.println("Shipping Address-Contact No. : "+VShipContact);
					    					    //Contact no.
					    String contact=driver.findElement(By.xpath("//input[@name='billingInfo[Phone]']")).getAttribute("value");
					    System.out.println("Billing Address-contactno. : "+contact);
					    int valid9=stringCompare(contact,VShipContact);
					    if(valid9!=0)
						{
							//Shipping Address
						//PageFactory.initElements(driver, this);
					    	String ShipContact1="942164771";
					    	ShipContact.clear();
					    	ShipContact.sendKeys(ShipContact1);
						    
						}
					    
					    
		    //LastName
	      /*  String LN=driver.findElement(By.xpath("//input[@name='billingInfo[Lastname]']")).getAttribute("value");
		    System.out.println("Billing Address-LastName: "+LN);
		    //Email
	        String email=driver.findElement(By.xpath("//input[@name='billingInfo[Email]']")).getAttribute("value");
		    System.out.println("Billing Address-E-mail ID: "+email);
		    //Country dropdown
		    Select select = new Select(driver.findElement(By.xpath("//select[@name='billingInfo[Country]']")));
		    WebElement option = select.getFirstSelectedOption();
		    String country = option.getText();
		    System.out.println("Billing Address-Country: "+country );
		    //ZIP Code
		    String zipcode=driver.findElement(By.xpath("//input[@name='billingInfo[Postcode]']")).getAttribute("value");
		    System.out.println("Billing Address-ZIP Code: "+zipcode);
		    //State Dropdown
		    Select select1 = new Select(driver.findElement(By.xpath("//select[@name='billingInfo[Statemenu]']")));
		    WebElement option1 = select1.getFirstSelectedOption();
		    String state = option1.getText();
		    System.out.println("Billing Address-State: "+state );
		    //City
		    String city=driver.findElement(By.xpath("//input[@name='billingInfo[City]']")).getAttribute("value");
		    System.out.println("Billing Address-City : "+city);
		    //Addrees1
		    String add1=driver.findElement(By.xpath("//input[@name='billingInfo[Streetline1]']")).getAttribute("value");
		    System.out.println("Billing Address-Address1 : "+add1);
		    //Addrees2
		    String add2=driver.findElement(By.xpath("//input[@name='billingInfo[Streetline2]']")).getAttribute("value");
		    System.out.println("Billing Address-Address2 : "+add2);
		    //Contact no.
		    String contact=driver.findElement(By.xpath("//input[@name='billingInfo[Phone]']")).getAttribute("value");
		    System.out.println("Billing Address-contactno. : "+contact);*/
					  
		}
	
	

	public  int stringCompare(String str1, String str2) 
    { 
  
        int l1 = str1.length(); 
        int l2 = str2.length(); 
        int lmin = Math.min(l1, l2); 
  
        for (int i = 0; i < lmin; i++) { 
            int str1_ch = (int)str1.charAt(i); 
            int str2_ch = (int)str2.charAt(i); 
  
            if (str1_ch != str2_ch) { 
                return str1_ch - str2_ch; 
            } 
        } 
  
        // Edge case for strings like 
        // String 1="Geeks" and String 2="Geeksforgeeks" 
        if (l1 != l2) { 
            return l1 - l2; 
        } 
  
        // If none of the above conditions is true, 
        // it implies both the strings are equal 
        else { 
            return 0; 
        } 
    } 
		/*public void verifyShippingAdd() throws Exception
		{
			//Firstname
			String VShipFN=driver.findElement(By.xpath("//input[@name='shippingInfo[Firstname]']")).getAttribute("value");
			System.out.println("Shipping Address-FirstName: "+VShipFN);
			//Lastname
			String VShipLN=driver.findElement(By.xpath("//input[@name='shippingInfo[Lastname]']")).getAttribute("value");
			System.out.println("Shipping Address-LastName: "+VShipLN);
			//Email
			String VShipEmail=driver.findElement(By.xpath("//input[@name='shippingInfo[Email]']")).getAttribute("value");
			System.out.println("Shipping Address-Email: "+VShipEmail);
			//Country dropdown
			  Select select = new Select(driver.findElement(By.xpath("//select[@name='shippingInfo[Country]']")));
			  WebElement option = select.getFirstSelectedOption();
			  String Vcountry = option.getText();
			  System.out.println("Shipping Address-Country: "+Vcountry);
			//ZIP Code
			 String VShipZIPcode=driver.findElement(By.xpath("//input[@name='shippingInfo[Postcode]']")).getAttribute("value");
			 System.out.println("Shipping Address-Zip code: "+VShipZIPcode);
			
			//State Dropdown
			 Select select1 = new Select(driver.findElement(By.xpath("//select[@name='shippingInfo[Statemenu]']")));
			  WebElement option1 = select1.getFirstSelectedOption();
			  String Vstate = option.getText();
			  System.out.println("Shipping Address-state: "+Vstate);
			//City
			  String VShipCity=driver.findElement(By.xpath("//input[@name='shippingInfo[City]']")).getAttribute("value");
			  System.out.println("Shipping Address-City: "+VShipCity);
			
		    //Addrees1
			  String VShipAdd1=driver.findElement(By.xpath("//input[@name='shippingInfo[Streetline1]']")).getAttribute("value");
			  System.out.println("Shipping Address-Address1:  "+VShipAdd1);
			
		    //Addrees2
			  String VShipAdd2=driver.findElement(By.xpath("//input[@name='shippingInfo[Streetline2]']")).getAttribute("value");
			  System.out.println("Shipping Address-Address2:  "+VShipAdd2);
			
		    //Contact no.
			  String VShipContact=driver.findElement(By.xpath("//input[@name='shippingInfo[Phone]']")).getAttribute("value");
			  System.out.println("Shipping Address-Contact No. : "+VShipContact);
				
		
		}
	*/
	
		/*public void ShipAddress(String ShipFN1, String ShipLN1,String ShipEmail1,String  ShipZIPcode1,
				 String ShipCity1,String ShipAdd3,String ShipAdd4,String ShipContact1) throws InterruptedException
				 
			{
			//Shipping Address
			PageFactory.initElements(driver, this);
			//Firstname
			ShipFN.clear();
			ShipFN.sendKeys(ShipFN1);
			
			//Lastname
			ShipLN.clear();
			ShipLN.sendKeys(ShipLN1);
			
			//Email
			ShipEmail.clear();
			ShipEmail.sendKeys(ShipEmail1);
			
			//Country dropdown
			Select select=new Select(ShipCountry);
		    select.selectByVisibleText("India");
		    
		    //ZIP Code
			ShipZIPcode.clear();
			ShipZIPcode.sendKeys(ShipZIPcode1);
			
		    //State Dropdown
			Select select1=new Select(ShipState);
		    select.selectByVisibleText("Maharashtra");
			
		    //City
		     ShipCity.clear();
		     ShipCity.sendKeys(ShipCity1);
			
		    //Addrees1
		     ShipAdd1.clear();
		     ShipAdd1.sendKeys(ShipAdd3);
			
		    //Addrees2
			ShipAdd2.clear();
			ShipAdd2.sendKeys(ShipAdd4);
			
		    //Contact no.
			 ShipContact.clear();
			 ShipContact.sendKeys(ShipContact1);
			
						    
						
						
				 }*/
	}	
	
	
	


