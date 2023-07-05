package containerBCapp.ExcelRead;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import containerBCapp.Baseclass.CommonUtilities;

public class ExcelRead extends CommonUtilities {

	public String LoginCredentials = "LoginCredentials";
	public String validEmailID;
	public String validpassword;
	public String inValidEmailID;
	public String inValidpassword;
	public String inValidEmailFormat;
	
	public String readExcelFile(int rownum, int cellnum, String SheetName) throws Throwable {
		File FileLocation = new File(ExcelFile);
		FileInputStream FI = new FileInputStream(FileLocation);
		XSSFWorkbook Workbook = new XSSFWorkbook(FI);
		XSSFSheet Sheet = Workbook.getSheet(SheetName);
		Row row = Sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String Data = cell.toString();
		return Data;
	}
	
	public void testData ( ) throws Throwable {
		
	 validEmailID =	readExcelFile(1, 0, LoginCredentials);
	 validpassword =	readExcelFile(1, 1, LoginCredentials);
	 inValidEmailID =	readExcelFile(1, 2, LoginCredentials);
	 inValidpassword =	readExcelFile(1, 3, LoginCredentials);
	 inValidEmailFormat =	readExcelFile(1, 4, LoginCredentials);
	 
	}

}
