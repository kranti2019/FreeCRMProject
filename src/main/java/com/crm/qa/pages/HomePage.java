package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase
{

	//Page Factory
	
	@FindBy(xpath="//span[contains(.,'Welcome,vijay   Sign Out')])[3]")
	WebElement userNameLabel;
	 //Apparel
		@FindBy (xpath = "//a[contains(text(),'Apparel')]")
		private WebElement Apparel;
		
		//Computers
		@FindBy (xpath = "//a[contains(text(),'Computers')]")
		private WebElement Computers;
		
		
		@FindBy (xpath = "//a[contains(text(),'Notebooks')]")
		private WebElement Notepad;
		
		@FindBy (xpath = "//a[contains(text(),'Desktops')]")
		private WebElement Desktop;
		
		//DVD
		@FindBy (xpath = "//a[contains(.,'DVD')])[1]")
		private WebElement DVD;

		
		//Classic films
		@FindBy (xpath = "//a[contains(text(),'Classic Films')]")
		private WebElement Classicflims;
		
		//Kids Dvd
		@FindBy (xpath = "//a[contains(text(),'Kids DVDs')]")
		private WebElement KidsDvd;
		
		//Tvondvd
		@FindBy (xpath = "//a[contains(text(),'TV on DVD')]")
		private WebElement TvonDvd;
		
		//Furniture
		@FindBy (xpath = "//a[contains(text(),'Furniture')]")
		private WebElement Furniture;
		
		
		//Sport
		@FindBy (xpath = "//a[contains(text(),'Sport')]")
		private WebElement Sport;
		
		//Digital distribution
		@FindBy (xpath = "//a[contains(text(),'Digital Distribution')]")
	    private WebElement Digitaldistribution;
		
		//Initializing page objects
		
		public HomePage() throws IOException 
		{
			super();
			PageFactory.initElements(driver, this);
			
			// TODO Auto-generated constructor stub
		}

		//Actions
		public boolean validateHomepage()
		{
			return userNameLabel.isDisplayed();
			
			
		}
		
		public ReadExcelWithHashMap apparel()
		{
			Apparel.click();
			return new  ReadExcelWithHashMap();
		}
		
				
}
