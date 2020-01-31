package com.crm.qa.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.crm.qa.base.TestBase;
import com.crm.qa.tests.ReadExcelSheetData;

public class FinalCheckoutPage extends TestBase
{
	
	public FinalCheckoutPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	ReadExcelWithHashMap readexcel =new ReadExcelWithHashMap();
	public static final String  dynamicString="";
	public static final String dynamicString2 = null;
	String TempVAR;
	//SelectShippingOption
		@FindBy (xpath = "//input[@value='BCE5D24D-666C-43CA-94A0-D6F775903BE2_1']")
		private WebElement ShippingOption;
		//Continue2
		@FindBy (xpath = "//input[@onclick='submitStep(2);']")
		private WebElement Step2;
		@FindBy(xpath = "(//td[@class='product_quantity_selector'])[1]")
		private WebElement Qty1;
		@FindBy(xpath = "(//td[@class='product_quantity_selector'])[2]")
		private WebElement Qty2;
		@FindBy(xpath = "(//td[@class='product_quantity_selector'])[3]")
		private WebElement Qty3;
		@FindBy(xpath = "(//td[@class='product_quantity_selector'])[4]")
		private WebElement Qty4;
		@FindBy(xpath = "(//td[@class='product_quantity_selector'])[5]")
		private WebElement Qty5;
		@FindBy(xpath = "(//td[@class='product_sale_price'])[1]")
		private WebElement Price1;
		@FindBy(xpath = "(//td[@class='product_sale_price'])[2]")
		private WebElement Price2;
		@FindBy(xpath = "(//td[@class='product_sale_price'])[3]")
		private WebElement Price3;
		@FindBy(xpath = "(//td[@class='product_sale_price'])[4]")
		private WebElement Price4;
		@FindBy(xpath = "(//td[@class='product_sale_price'])[5]")
		private WebElement Price5;
//		@FindBy(xpath = "//input[contains(@value,'Place Order')]")
//		private WebElement PlaceOrder;
	public void VerifyProduct() throws Exception
	{
  
		
	}
		public String validateinvalidProduct() throws IOException, InterruptedException
		{
			
			PageFactory.initElements(driver, this);
			
			
			String checkout1="//a[@href='checkout.php'][contains(.,'Checkout')]";
			driver.findElement(By.xpath(checkout1)).click();
			String continueshopping="//input[@onclick='submitStep(1);']";
			driver.findElement(By.xpath(continueshopping)).click();
			Thread.sleep(10000);
			ShippingOption.click();
			Step2.click();
			 // System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+ Qty1.getText());
				//Product1
				//Integer  qty=Integer.valueOf(Qty1.getText().toString());
			
			String actualproduct="Apple MacBook Air";
			//System.out.println(")))))))))))))))))))))))))))))))))))))))))))))))))"+actualproduct);
		
			 ReadExcelSheetData r = new ReadExcelSheetData();
			Map<String, ArrayList<String>> m = ReadExcelSheetData.setMapData().get("Shoppingcart");
			 List<String> val1=null;
			  
			
			 for (Entry<String, ArrayList<String>> entry : m.entrySet())  
			 {
				 
		          if(!entry.getKey().equals("Testdata"))
		          {
		        	
		        	  System.out.println(entry.getKey()+"getkey,..."+entry.getValue());
		        	  
		        	  val1 = ReadExcelSheetData.getMapData(entry.getKey());
		        	 
		        
		        	  verifydata(actualproduct,val1);
		        	 // verifydataqty(Qty1, val1);
		        	
		        	  
		          }

		          
			 }
			
			 
			
			
			
			return actualproduct;
			//assertEquals(actualmsg,expectedmsg);
		}
		
		private void verifydata(String actualproduct, List<String> val1) throws InterruptedException 
		{
			String Qty=Qty1.getText();
			String price=Price1.getText();
			System.out.println(Qty);
		
			// TODO Auto-generated method stub
			for(String b1:val1)
			{
				// System.out.println(b1+"ooooooooooooooooooooooooooooooooooooooooooooooooooooo"+Qty1.getText());
				 
                    if(b1.equals(actualproduct))
                     {
                    	
                    	 Assert.assertEquals(b1,actualproduct);
                     }
                  
                     if(b1.equals(Qty))
                     {
                    	 
                    	 Thread.sleep(10000);	
                    
                    	 Assert.assertEquals(b1, Qty);
                    	 System.out.println("Expected Quantity::::"+ b1      +"Actual Quantity:::"+  Qty);
                    	 System.out.println("Quantities are equal for product1");
                     }
                   
                     
                    if(b1.equals(price))
                     {
                    
                    	 Thread.sleep(10000);	
                      
                    	Assert.assertEquals(b1, price);
                   	    System.out.println("Expected Price::::"+ b1  +"Actual Price:::"+    price);
                    	 System.out.println("Prices  of product1 are validated successfully");
                     }
			}
		}
		/*	private void verifydataqty(String qty1, List<String> val1) 
			{
				// TODO Auto-generated method stub
				for(String e1:val1)
				{
					System.out.println(e1+"lllmmmmmmmmmmm"+qty1);
	                     if(e1.equals(qty1.trim()))
	                     {
	                    		
	                    	 Assert.assertEquals(e1,qty1);
	                     }
	                     else
	                     {
	                    	 break;
	                     }
				}*/
		



		public String validateinvalidProduct2() throws IOException, InterruptedException
		{
			
		//Product2
			
        String actualproduct1="Forbidden Planet";
       // System.out.println(")))))))))))))))))))))))))))))))))))))))))))))))))"+actualproduct1);
		 ReadExcelSheetData r = new ReadExcelSheetData();
		Map<String, ArrayList<String>> m = ReadExcelSheetData.setMapData().get("Shoppingcart");
		 List<String> val2=null;
		// System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+ Qty2.getText());
		 for (Entry<String, ArrayList<String>> entry : m.entrySet())  
		 {
			 
	          if(!entry.getKey().equals("Testdata"))
	          {
	        	
	        	  //System.out.println(entry.getKey()+"getkey,...");
	        	  
	        	  val2 = ReadExcelSheetData.getMapData(entry.getKey());
	        	  verifydata1(actualproduct1,val2);
	        	  
	          }
	          
		 }
		

		
		return actualproduct1;
		//assertEquals(actualmsg,expectedmsg);
}
	private void verifydata1(String actualproduct1, List<String> val2) throws InterruptedException 
	{
		String Qty=Qty1.getText();
		String price=Price1.getText();
		System.out.println(Qty);
	
		// TODO Auto-generated method stub
		for(String b2:val2)
		{
                 if(b2.equals(actualproduct1))
                 {
                	 //System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+b2);
                	 Assert.assertEquals(b2,actualproduct1);
                 }
                 if(b2.equals(Qty))
                 {
                	 
                	
                	 //System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||"+b2);
                	 Assert.assertEquals(b2, Qty);
                	 System.out.println("Expected Quantity::::"+ b2      +"Actual Quantity:::"+  Qty);
                	 System.out.println("Quantities are equal for product2");
                 }
                 if(b2.equals(price))
                 {
                	 
                	Thread.sleep(10000);
                	 
                	 //System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||"+b2);
                	 //System.out.println("###############################"+Price2.getText());
                	 
                	 Assert.assertEquals(b2, Price2.getText());
                	 System.out.println("Expected Price::::"+b2    +"Actual Price:::"+price);
                	System.out.println("Prices of product2 are validated successfully");
                 }
		}
	}

	
	
//Product3
public String validateinvalidProduct3() throws IOException, InterruptedException
{

String actualproduct2="ARILD Chair";


//System.out.println(")))))))))))))))))))))))))))))))))))))))))))))))))"+actualproduct2);
 ReadExcelSheetData r = new ReadExcelSheetData();
Map<String, ArrayList<String>> m = ReadExcelSheetData.setMapData().get("Shoppingcart");
 List<String> val3=null;

 for (Entry<String, ArrayList<String>> entry : m.entrySet())  
 {
	 
      if(!entry.getKey().equals("Testdata"))
      {
    	
    	 // System.out.println(entry.getKey()+"getkey,...");
    	  
    	  val3 = ReadExcelSheetData.getMapData(entry.getKey());
    	  verifydata2(actualproduct2,val3);
    	  
      }
      
 }



return actualproduct2;
//assertEquals(actualmsg,expectedmsg);
}
private void verifydata2(String actualproduct2, List<String> val3) throws InterruptedException 
{
	String Qty=Qty3.getText();
	String price=Price3.getText();
	System.out.println(Qty3);
// TODO Auto-generated method stub
for(String b3:val3)
{
         if(b3.equals(actualproduct2))
         {
        	// System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+b3);
        	 Assert.assertEquals(b3,actualproduct2);
         }
         if(b3.equals(Qty))
         {
        	 
        		
        	//System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||"+b3);
        	 Assert.assertEquals(b3, Qty);
        	 System.out.println("Expected Quantity::::"+ b3      +"Actual Quantity:::"+  Qty);
        	 System.out.println("Quantities are equal for product3");
         }
         if(b3.equals(price))
         {
        	 
        	Thread.sleep(10000);
        	 //System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||"+b2);
        	 //System.out.println("###############################"+Price2.getText());
        	 Assert.assertEquals(b3, price);
        	 System.out.println("Expected Price::::"+b3    +"Actual Price:::"+price);
        	System.out.println("Prices of product3 are validated successfully");
         }
}
}

//Product4
public String validateinvalidProduct4() throws IOException, InterruptedException
{
	

String actualproduct3="Brunton Eclipse Compass";
//System.out.println(")))))))))))))))))))))))))))))))))))))))))))))))))"+actualproduct3);
ReadExcelSheetData r = new ReadExcelSheetData();
Map<String, ArrayList<String>> m = ReadExcelSheetData.setMapData().get("Shoppingcart");
List<String> val4=null;

for (Entry<String, ArrayList<String>> entry : m.entrySet())  
{
	 
    if(!entry.getKey().equals("Testdata"))
    {
  	
  	 // System.out.println(entry.getKey()+"getkey,...");
  	  
  	  val4 = ReadExcelSheetData.getMapData(entry.getKey());
  	  verifydata3(actualproduct3,val4);
  	  
    }
    
}



return actualproduct3;
//assertEquals(actualmsg,expectedmsg);
}
private void verifydata3(String actualproduct3, List<String> val4) throws InterruptedException 
{
	String Qty=Qty4.getText();
	String price=Price4.getText();
	System.out.println(Qty4);
//TODO Auto-generated method stub
for(String b4:val4)
{
       if(b4.equals(actualproduct3))
       {
      	// System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+b4);
      	 Assert.assertEquals(b4,actualproduct3);
       }
       if(b4.equals(Qty))
       {
      	 
      		
      	// System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||"+b4);
      	 Assert.assertEquals(b4, Qty);
      	System.out.println("Expected Quantity::::"+ b4      +"Actual Quantity:::"+  Qty);
      	System.out.println("Quantities are equal for product4");
       }
       if(b4.equals(price))
       {
      	 
      	Thread.sleep(10000);
      	 //System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||"+b2);
      	 //System.out.println("###############################"+Price2.getText());
      	 Assert.assertEquals(b4, price);
      	 System.out.println("Expected Price::::"+b4    +"Actual Price:::"+price);
      	System.out.println("Prices  of product4 are validated successfully");
       }
}
}


//Product5
public String validateinvalidProduct5() throws IOException, InterruptedException
{
	


String actualproduct4="Pure cotton T-Shirt";
//System.out.println(")))))))))))))))))))))))))))))))))))))))))))))))))"+actualproduct4);
ReadExcelSheetData r = new ReadExcelSheetData();
Map<String, ArrayList<String>> m = ReadExcelSheetData.setMapData().get("Shoppingcart");
List<String> val5=null;

for (Entry<String, ArrayList<String>> entry : m.entrySet())  
{
	 
  if(!entry.getKey().equals("Testdata"))
  {
	
	  System.out.println(entry.getKey()+"getkey,...");
	  
	  val5= ReadExcelSheetData.getMapData(entry.getKey());
	  verifydata4(actualproduct4,val5);
	  
  }
  
}



return actualproduct4;
//assertEquals(actualmsg,expectedmsg);
}
private void verifydata4(String actualproduct4, List<String> val5) throws InterruptedException 
{
	String Qty=Qty5.getText();
	String price=Price5.getText();
	System.out.println(Qty5);
//TODO Auto-generated method stub
for(String b5:val5)
{
     if(b5.equals(actualproduct4))
     {
    	 //System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+b5);
    	 Assert.assertEquals(b5,actualproduct4);
     }
     if(b5.equals(Qty))
     {
    	 
    		
    	// System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||"+b5);
    	 Assert.assertEquals(b5, Qty);
    	 System.out.println("Expected Quantity::::"+ b5      +"Actual Quantity:::"+  Qty);
    	 System.out.println("Quantities are equal for product");
     }
     if(b5.equals(price))
     {
    	 
    	Thread.sleep(10000);
    	 //System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||"+b2);
    	 //System.out.println("###############################"+Price2.getText());
    	 Assert.assertEquals(b5, price);
    	 System.out.println("Expected Price::::"+b5    +"Actual Price:::"+price);
    	System.out.println("Prices are validated successfully");
     }
    //s PlaceOrder.click();
}
}
public void validateinvalidProductbyValue(String value) {
	// TODO Auto-generated method stub
	String actualproduct="Apple MacBook Air";
        
        	  verifydataa(actualproduct,value);
        	 // verifydataqty(Qty1, val1);
        	
        	  
          

          
	 }
private void verifydataa(String actualproduct, String value) {
	// TODO Auto-generated method stub
	 Assert.assertEquals(value,actualproduct);
	
}
	
}

			