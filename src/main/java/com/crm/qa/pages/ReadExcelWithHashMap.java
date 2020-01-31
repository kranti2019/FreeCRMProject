package com.crm.qa.pages;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcelWithHashMap {
	public static HashMap<String, String> init(String ExcelSheetName) throws BiffException, IOException 
	{

		Workbook DataWorkBook =null;
		Sheet DataSheet = null;
		String DataFilePath= "C:\\Users\\ue\\Desktop\\Shopping.xls";

		File DataFile = new File(DataFilePath);
		DataWorkBook = Workbook.getWorkbook(DataFile);

		//DataSheet = DataWorkBook.getSheet("Registration");
		if(DataWorkBook!=null)
		{
			DataSheet = DataWorkBook.getSheet(ExcelSheetName);
			System.out.println("++++++++++++++++++++++++++"+DataSheet.getName());	
		}
		else
		{
			System.out.println("null..");
		}


		int varRowsCount = DataSheet.getRows();
		int varColumnsCount = DataSheet.getColumns();
		//String[] TestData = new String [varColumnsCount];

		int varRows =0;

		String getColumnName;
		String getTestData;
		String testCaseName;
		testCaseName="Testdata";
		String testCaseName1="Testdata1";
		String testCaseName2="Testdata2";
		

		//		testCaseName="VerifyMandatoryFieldFirstName1";

		//System.out.println("testCaseName" + testCaseName);
		//System.out.println("varColumnsCount" + varColumnsCount);
		//System.out.println("varRowsCount" + varRowsCount);


		HashMap<String, String> mapGetTestData = new HashMap<String,String>();

		for ( varRows = 0 ; varRows <=varRowsCount -1;	varRows ++)

		{
			int i=0;

			String getTCName=null;


			//getModuleName=TestData[varRows]=DataSheet.getCell (0,varRows).getContents();

			//getTCName=TestData[varRows]=DataSheet.getCell (1,varRows).getContents();


			//getTCName=DataSheet.getCell (1,varRows).getContents();

			getTCName=DataSheet.getCell (0,varRows).getContents();


			System.out.println(getTCName+"kkkkkkk"+testCaseName);

			//System.out.println(getTCName);
			if (getTCName.equalsIgnoreCase(testCaseName) )
			{
				for (int varColumns = 1; varColumns <=varColumnsCount -1 ; varColumns++)

				{

					// Get The Column Header as HashMap Keys
					getTestData	=DataSheet.getCell (varColumns,1).getContents();

					getColumnName=DataSheet.getCell (varColumns,varRows).getContents();

					//Get The TestDat as per Column Header for HashMap Keys

					//Adding TestData Column as Keys and Column Value as Test Data in HashMap
					System.out.println(getColumnName+";;;;;;;;;;"+getTestData);
					mapGetTestData.put(getColumnName, getTestData);

					if(getTestData.equalsIgnoreCase("END"))
					{
						break;
					}

					//System.out.println(getTestData);

				}//END OF INNER LOOP OF COLUMN varColumns



			}	
			

				if (getTCName.equalsIgnoreCase(testCaseName1) )
				{

					for (int varColumns = 1; varColumns <=varColumnsCount -1 ; varColumns++)

					{
						// Get The Column Header as HashMap Keys
						getTestData	=DataSheet.getCell (varColumns,2).getContents();

						getColumnName=DataSheet.getCell (varColumns,0).getContents();

						//Get The TestDat as per Column Header for HashMap Keys

						//Adding TestData Column as Keys and Column Value as Test Data in HashMap
						System.out.println(getColumnName+";;;;;;;;;;"+getTestData);
						mapGetTestData.put(getColumnName, getTestData);

						if(getTestData.equalsIgnoreCase("END"))
						{
							break;
						}

						//System.out.println(getTestData);

					}//END OF INNER LOOP OF COLUMN varColumns



				}	
				
					
					
				}


			// Declare the Hashmap

			// Put contents to our HashMap
		
		return mapGetTestData;

	}



}


