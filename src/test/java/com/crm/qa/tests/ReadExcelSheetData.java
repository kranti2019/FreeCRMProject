package com.crm.qa.tests;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadExcelSheetData {
public static Map<String, Map<String, ArrayList<String>>> setMapData() throws IOException {
//String path = "F:/Shopping1.xlsx";
	String path= "C:\\Users\\ue\\Desktop\\Shopping.xlsx";
FileInputStream fis = new FileInputStream(path);
Workbook workbook = new XSSFWorkbook(fis);
Sheet sheet = workbook.getSheetAt(0);

int rowTotal = sheet.getLastRowNum();
int columnrow=sheet.getPhysicalNumberOfRows();

Map<String, Map<String,ArrayList<String>>> excelFileMap = new HashMap<String, Map<String,ArrayList<String>>>();
Map<String, ArrayList<String>> dataMap = new HashMap<String, ArrayList<String>>();
//Looping over entire row

//System.out.println("nu of rpws.."+rowTotal+"kkkkk"+columnrow);
for(int i=0; i<columnrow; i++){
	
Row row = sheet.getRow(i);
int col=row.getLastCellNum();

int k=0;
List<String>valuelist=new ArrayList<String>();
for(int j=1;j<col;j++)
{
	
	//1st Cell as Value
	Cell valueCell = row.getCell(j);
	//System.out.println(valueCell+"ppppppp");
	//0th Cell as Key
	Cell keyCell = row.getCell(k);
	String value = "";
	if(valueCell.getCellType()==Cell.CELL_TYPE_NUMERIC)
	{
		int a = (int) valueCell.getNumericCellValue();
		//System.out.println(a+"...uuuuuuuuuuu");
		value=String.valueOf(a);
	}
	else
	{
		value=valueCell.getStringCellValue();
	}
	
	
	String key = keyCell.getStringCellValue().trim();
	if(value!=null)
	{
		
	}
	else{
		value="";
	}
	valuelist.add(value);
	
	//Putting key & value in dataMap
	dataMap.put(key, (ArrayList<String>) valuelist);
}


//Putting dataMap to excelFileMap
excelFileMap.put("Shoppingcart", dataMap);

}

//Returning excelFileMap
return excelFileMap;
}
//Method to retrieve value
public static List<String> getMapData(String key) throws IOException{
	
Map<String, ArrayList<String>> m = setMapData().get("Shoppingcart");
ArrayList<String> value = m.get(key);
System.out.println(value.size());

return value;
}
}