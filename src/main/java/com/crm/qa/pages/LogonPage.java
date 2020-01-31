package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.crm.qa.base.TestBase;

public class LogonPage extends TestBase
{
	//Page Factory
	
	@FindBy(xpath="//a[contains(text(),'Sign In')]")
	WebElement signInBtn;
	
	@FindBy (id = "account_sign_in_form_email_id")
	private WebElement email;
	
	@FindBy (id = "account_sign_in_form_passwd_id")
	private WebElement password;
	
	@FindBy (xpath = "//input[@type='submit']")
	private WebElement submit;
	
	@FindBy (xpath = "//h3[contains(.,'Manage Account and View Orders')]")
	private WebElement verifysucess;
	
	@FindBy (xpath = "(//a[contains(.,'Sign Out')])[2]")
	private WebElement verifylogout;
    	
	@FindBy (xpath = "//button[@class='btn btn-default']")
	private WebElement register;
	
	@FindBy (xpath = "//a[contains(@class,'site-logo')]")
	private WebElement Logo;
	
	//Initializing page objects
	
	public LogonPage() throws IOException 
	{
		super();
		PageFactory.initElements(driver, this);
		
		// TODO Auto-generated constructor stub
	}
	
	//Actions
	public String validateLoginpage()
	{
		return driver.getTitle();
		
		
	}
	
	public boolean validateAvacticsLogo()
	{
		return Logo.isDisplayed();
		
	}
	//Specifiying email and psswd
	 /*public HomePage Login (String UN,String PWD) throws IOException
	 {
		 
		 signInBtn.click();
		 email.sendKeys(UN);
		 password.sendKeys(PWD);
		 submit.click();
		 
		 return new HomePage();
	 }
	 */
	 public FinalCheckoutPage Login (String UN,String PWD) throws IOException
    {
		 
		 signInBtn.click();
		 email.sendKeys(UN);
		 password.sendKeys(PWD);
		 submit.click();
		 
		 return new FinalCheckoutPage();
	 }
	 
	
}
