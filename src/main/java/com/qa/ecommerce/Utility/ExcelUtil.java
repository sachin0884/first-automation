package com.qa.ecommerce.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class ExcelUtil {
	
	private static final String TEST_DATA_SHEET_PATH ="./src/test/resources/TestData/EcommerceTestData.xlsx";
	private static Workbook book;
	private static Sheet sheet;
	
	
	public static Object[][] getTestData(String sheetName) {
		System.out.println("Reading the data sheet ::-" +sheetName);
		Object data [][] =null;
		
		
		try {
			FileInputStream ip= new FileInputStream(TEST_DATA_SHEET_PATH);
			try {
	
			book=WorkbookFactory.create(ip);
	    	sheet=book.getSheet(sheetName);
			data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for(int i=0; i<sheet.getLastRowNum(); i++) {
				for(int j=0; j<sheet.getRow(j).getLastCellNum(); j++) {
					data [i][j]=sheet.getRow(i+1).getCell(j).toString();
				}
			}
				
				
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}return data;
	}

}
