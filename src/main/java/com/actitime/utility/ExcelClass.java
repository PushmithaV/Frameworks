package com.actitime.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.actitime.base.BaseClass;


public class ExcelClass extends BaseClass {
	
	
	public static String getResultof(String testcase) throws EncryptedDocumentException, IOException
	{
		String pathofexcel=excelprop.getProperty(userDir+"datapath");
		file=new FileInputStream(pathofexcel);
		wbook = WorkbookFactory.create(file);
		sheet = wbook.getSheet(excelprop.getProperty("sheet"));
		String result="";
		for(int i=0; i<sheet.getLastRowNum(); i++)
		{
			if((sheet.getRow(i).getCell(0).getStringCellValue()).equals(testcase))
			{
				result=sheet.getRow(i).getCell(1).getStringCellValue();
				break;
			}
		}
		return result;
		
	}
	
	public static String getResultof(int rownumber, int columnnumber) throws EncryptedDocumentException, IOException
	{
		String pathofexcel=excelprop.getProperty(userDir+"path");
		file=new FileInputStream(pathofexcel);
		wbook = WorkbookFactory.create(file);
		sheet = wbook.getSheet(excelprop.getProperty("sheet"));
		String result=sheet.getRow(rownumber).getCell(columnnumber).getStringCellValue();
		return result;
	}
	
	public static void writeResult(String Testcasename, String result) throws EncryptedDocumentException, IOException
	{
		String pathofexcel=excelprop.getProperty("testpath");
		file=new FileInputStream(userDir+pathofexcel);
		//System.out.println(userDir+pathofexcel);
		wbook = WorkbookFactory.create(file);
		sheet = wbook.getSheet(excelprop.getProperty("sheet"));
		sheet.createRow(0).createCell(0).setCellValue("Testcaseid");
		sheet.getRow(0).createCell(1).setCellValue("Results");
	
		for(int row=1; ; row++)
		{
			
			if(sheet.getRow(row)==null)
			{
				sheet.createRow(row).createCell(0).setCellValue(Testcasename);
				sheet.getRow(row).createCell(1).setCellValue(result);
				break;
			}
		}
		
		FileOutputStream fos= new FileOutputStream(userDir+pathofexcel);
		wbook.write(fos);
		//fos.flush();
		wbook.close();
		file.close();
		fos.close();
	}
}
