package com.actitime.utility;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.actitime.base.BaseClass;



public class ExcelClass extends BaseClass {
	
	
	public String getResultof(String testcase) throws EncryptedDocumentException, IOException
	{
		String pathofexcel=gv.excelprop.getProperty("path");
		gv.file=new FileInputStream(pathofexcel);
		gv.wbook = WorkbookFactory.create(gv.file);
		gv.sheet = gv.wbook.getSheet(gv.excelprop.getProperty("sheet"));
		String result="";
		for(int i=0; i<gv.sheet.getLastRowNum(); i++)
		{
			if((gv.sheet.getRow(i).getCell(0).getStringCellValue()).equals(testcase))
			{
				result=gv.sheet.getRow(i).getCell(1).getStringCellValue();
				break;
			}
		}
		return result;
		
	}
	
	public String getResultof(int rownumber, int columnnumber) throws EncryptedDocumentException, IOException
	{
		String pathofexcel=gv.excelprop.getProperty("path");
		gv.file=new FileInputStream(pathofexcel);
		gv.wbook = WorkbookFactory.create(gv.file);
		gv.sheet = gv.wbook.getSheet(gv.excelprop.getProperty("sheet"));
		String result=gv.sheet.getRow(rownumber).getCell(columnnumber).getStringCellValue();
		return result;
	}
}
