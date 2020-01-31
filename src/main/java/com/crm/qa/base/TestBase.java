package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.log4testng.Logger;

import com.crm.qa.util.TestUtil1;

public class TestBase 
{
	public static Properties prop;
	public static WebDriver driver;

	Logger log=Logger.getLogger(TestBase.class);
	public TestBase() throws IOException
	{
		
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/ue/javaworkspace/FreeCRMTestNew/"
				+ "src/main/java/com/crm/qa/config/config.properties");
			
			prop.load(ip);
	}
			//System.out.println(prop.getProperty("browser")+"..///");
			//System.out.println(prop.getProperty("url"));
	
			public static void initialization()
			{
			String browserName = prop.getProperty("browser");
			System.out.println(browserName+"..name");
			
			if(browserName.equals("chrome"))
		     {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\ue\\javaworkspace\\FreeCRMTestNew\\Resource\\chromedriver_win32\\chromedriver.exe");	
				driver = new ChromeDriver(); 
			 }
			
			else
			if(browserName.equals("FF"))
		    {
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\ue\\javaworkspace\\FreeCRMTestNew\\Resource\\geckodriver-64bit.exe");
					//System.setProperty("webdriver.gecko.driver", "C:\\Selenium_3.141.59\\resources\\geckodriver-64bit.exe");	
				driver = new FirefoxDriver();  
					System.out.println("2");
					//log.info("Launching Browser");
			}
			else
			
				System.out.println("No Browser Found");
		
		
           
//			log.info("URL has been launched");
//			driver.findElement(By.name("email")).sendKeys(prop.getProperty("username"));
//			driver.findElement(By.name("passwd")).sendKeys(prop.getProperty("password"));
           
			
	
			 driver.manage().window().maximize();
	            driver.manage().deleteAllCookies();
	            driver.manage().timeouts().pageLoadTimeout(TestUtil1.PAGE_lOAD_TIMEOUT, TimeUnit.SECONDS);
	            driver.manage().timeouts().implicitlyWait(TestUtil1.IMPLICIT_WAIT,TimeUnit.SECONDS);
	            driver.get(prop.getProperty("url"));
}
}