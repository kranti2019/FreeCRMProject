package com.crm.qa.tests;


import java.io.IOException;
import java.util.List;
public class ReadSheetData {
public static void main(String[] args) throws IOException {
ReadExcelSheetData r = new ReadExcelSheetData();
List<String> val = r.getMapData("Testdata3");
System.out.println("Value of the keyword (search) is- "+val);
}
}