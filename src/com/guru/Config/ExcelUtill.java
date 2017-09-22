package com.guru.Config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;

public class ExcelUtill {

	public static XSSFCell cell;
	public static XSSFSheet sh;
	public static XSSFRow row;
	public static XSSFWorkbook wb;
	public static int rowNum;

	public static void setExcel(String path) throws Exception {
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);

	}

	public static String getCellData(int rowNum, int colNum, String sheetName) throws Exception {

		sh = wb.getSheet(sheetName);
		String cellData = sh.getRow(rowNum).getCell(colNum).getStringCellValue();
		return cellData;
	}

	public static int getRowNum(String sheetName) {
		sh = wb.getSheet(sheetName);
		rowNum = sh.getPhysicalNumberOfRows();

		return rowNum;

	}
	
	
	public static void setCallData(String sheetName,int rows,int col,String data) throws Exception
	{
		
		
		sh=wb.getSheet(sheetName);
		row=sh.getRow(rows);
		cell=row.getCell(col);
		
		if(cell==null)
		{
			cell=row.createCell(col);
			cell.setCellValue(data);
		}
		
		else
		{
			cell.setCellValue(data);
		}
		
		
		FileOutputStream fout=new FileOutputStream(Utill.path_TestData);
		wb.write(fout);
		
	}
	
	
	
	
	

}
