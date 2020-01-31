package com.crm.qa.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.crm.qa.base.TestBase;
import com.crm.qa.tests.ReadExcelSheetData;

public class ShoppingCart extends TestBase
{
	public ShoppingCart() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	ReadExcelWithHashMap readexcel =new ReadExcelWithHashMap();
	public static final String  dynamicString="";
	public static final String dynamicString2 = null;
	String TempVAR;
	public void clickbutton() throws Exception
	{
		

	//	HashMap<String, String> map = ReadExcelWithHashMap.init("Shoppingcart");
		Map<String, Map<String, ArrayList<String>>> hashmap=ReadExcelSheetData.setMapData();
		
		ReadExcelSheetData r = new ReadExcelSheetData();
		Map<String,String>map1=new HashMap<String, String>();
	
		List<String> val = r.getMapData("Testdata");
		List<String> val1 = r.getMapData("Testdata1");
		List<String> val2 = r.getMapData("Testdata2");
		List<String> val3 = r.getMapData("Testdata3");
		List<String> val4 = r.getMapData("Testdata5");
		////////////////////////////////////////////////////////////////////////////////////////////////
		//Product1
		if(val!=null && val1!=null)
		{
			for(String a1:val)
			{
				for(String b1:val1)
				{
					if(map1.containsValue(b1))
					{
						
					}
					else
					{
						System.out.println(a1+";;;;"+b1);
						map1.put(a1, b1);
						break;
						
					}
				}
			}
			getproductsClicked(map1);
			
		/*	System.out.println("+++++++++++++++++++++++++++++++"+val1.get(2));
			String Product=val1.get(2);
			System.out.println("*************************"+Product);
			String Product_cart_page=driver.findElement(By.xpath("(//a[@href='http://localhost/avactis/product-info.php?Apple_MacBook_Air-pid8.html'][contains(.,'Apple MacBook Air')])[2]")).getText();
			System.out.println("Verify Product:::::::::::::::"+ Product_cart_page);
			Assert.assertEquals(Product, Product_cart_page);*/
		}
		////////////////////////////////////////////////////////////////////////////////////////////////
		//Product2
		if(val!=null && val2!=null)
		{
			map1.clear();
			for(String a1:val)
			{
				for(String b1:val2)
				{
					if(map1.containsValue(b1))
					{
						
					}
					else
					{
						System.out.println(a1+";;;;"+b1);
						map1.put(a1, b1);
						break;
						
					}
				}
				 
			}
			getproductsClicked(map1);
		
		
			
		}
		//////////////////////////////////////////////////////////////////////////////////////////////////////////
		//Product3	
		if(val!=null && val3!=null)
			{
				System.out.println("not null...");
				map1.clear();
				for(String a1:val)
				{
					for(String b4:val3)
					{
						if(map1.containsValue(b4))
						{
							
						}
						else
						{
							System.out.println(a1+";;;;"+b4);
							map1.put(a1, b4);
							break;
							
						}
					}
				}
				
				getproductsClicked(map1);

			
		}
   ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Product4
		if(val!=null && val4!=null)
	{
		System.out.println("not null...");
		map1.clear();
		for(String a1:val)
		{
			for(String b6:val4)
			{
				if(map1.containsValue(b6))
				{
					
				}
				else
				{
					System.out.println(a1+";;;;"+b6);
					map1.put(a1, b6);
					break;
					
				}
			}
		}
		
		getproductsClicked(map1);

		
		

}
		for (Map.Entry<String,String> entry : map1.entrySet())  
		{
            System.out.println("Key = " + entry.getKey() + 
                             ", Value = " + entry.getValue()); 
            if(entry.getKey().equals("Product1"))
            {
            	String Product3_cart_page=driver.findElement(By.xpath("(//a[contains(.,'"+entry.getValue()+"')])[2]")).getText();
        		System.out.println("Verify Product3:::::::  " + Product3_cart_page);
        		Assert.assertEquals(entry.getValue(), Product3_cart_page);
            }
		}
}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void getproductsClicked(Map<String, String> map1) {
		// TODO Auto-generated method stub
		System.out.println(map1.size()+"size..");
		String  TempVAR1=map1.get("SubCategory");	
		String  TempVAR2=map1.get("Products1");	
		String  TempVAR=map1.get("Category");	
		/*if(val1!=null)
		{
			for(String s:val1)
			{
				String xpathCatlink1 = "//a[text()='"+ s + "']";
				if(s.equals("Notebooks"))
					xpathCatlink1 ="(//a[contains(.,'"+ s + "')])[3]";
				
				System.out.println(xpathCatlink1);
				//new WebDriverWait(driver, 0100).until(ExpectedConditions.elementToBeClickable(By.xpath(xpathCatlink1))).click();
				
				
				driver.findElement(By.xpath(xpathCatlink1)).click();
			}
		}*/
		 	
		System.out.println(TempVAR);
		String xpathCatlink = "//a[text()='"+ TempVAR + "']";
		System.out.println(xpathCatlink);
		driver.findElement(By.xpath(xpathCatlink)).click();
//............................................................................................
		
		//wait= new WebDriverWait(driver,60,250);
		
		
		if(TempVAR1!=null && !TempVAR1.equals(""))
		{
			 System.out.println(TempVAR1+"llll");
				
	         String xpathCatlink1 ="(//a[contains(.,'"+ TempVAR1 + "')])[3]";
			
					System.out.println(xpathCatlink1);
					//new WebDriverWait(driver, 0100).until(ExpectedConditions.elementToBeClickable(By.xpath(xpathCatlink1))).click();
					
					driver.findElement(By.xpath(xpathCatlink1)).click();
		}
		else 
		{
			
			 System.out.println(TempVAR2);
			 //h3[contains(.,'Apple MacBook Air')])[1]
			  String xpathCatlink3 ="(//h3[contains(.,'"+ TempVAR2 + "')])";
					System.out.println(xpathCatlink3);
					//new WebDriverWait(driver, 0100).until(ExpectedConditions.elementToBeClickable(By.xpath(xpathCatlink1))).click();
					
					driver.findElement(By.xpath(xpathCatlink3)).click();
		}
		if((TempVAR1!=null &&!TempVAR1.equals("")) && (TempVAR2!=null&&!TempVAR2.equals("")))
		{
			  String xpathCatlink3 ="(//h3[contains(.,'"+ TempVAR2 + "')])[1]";	
			
				
				System.out.println(xpathCatlink3);
				//new WebDriverWait(driver, 0100).until(ExpectedConditions.elementToBeClickable(By.xpath(xpathCatlink1))).click();
				
				driver.findElement(By.xpath(xpathCatlink3)).click();
		}
//.............................................................................................
	
				
//.............................................................................................................		
		Select quantity = new Select(driver.findElement(By.name("quantity_in_cart")));
		//quantity.selectByVisibleText("Banana");
		//quantity.selectByIndex(0);
		quantity.selectByValue("1");
		
		String AddtoCart="(//input[contains(@value,'Add To Cart')])";
		driver.findElement(By.xpath(AddtoCart)).click();
//.....................................................................................................
		//product detail page
		//String P_page=driver.findElement(By.xpath("//span[@class='subtitle']")).getText();
		//cart page
		String Mycart="//a[contains(.,'My cart')]";
		driver.findElement(By.xpath(Mycart)).click();
		
		
	}

	}

