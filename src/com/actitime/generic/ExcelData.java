package com.actitime.generic;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData implements AutoConstants {
	public static String getData(String file_path, String sheetName, int rn, int cn) {
		try {
			FileInputStream fis = new FileInputStream(file_path);
			Workbook wb = WorkbookFactory.create(fis);
			String data = wb.getSheet(sheetName).getRow(rn).getCell(cn).getStringCellValue();
			return data;
		}
		catch (Exception e) {
			return " ";
		}
	}
	
	public static int getRowNum(String file_path, String sheetName) {
		try {
			FileInputStream fis = new FileInputStream(file_path);
			Workbook wb = WorkbookFactory.create(fis);
			int rc = wb.getSheet(sheetName).getLastRowNum();
			return rc;
		}
		catch (Exception e) {
			return -1;
		}
	}

}
