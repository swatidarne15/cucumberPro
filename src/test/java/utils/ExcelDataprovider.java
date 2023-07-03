package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.SheetBuilder;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataprovider {

	public static String getData(String sheetName,int row,int cell) 
			throws EncryptedDocumentException, InvalidFormatException, IOException
			{
			    FileInputStream file=new FileInputStream("C:\\Users\\A200232719\\eclipse-workspace\\CucumberFramework\\src\\test\\resources\\data.xlsx");
			   
			  Workbook wb= WorkbookFactory.create(file);					    
			  DataFormatter df= new DataFormatter();
			  String value=df.formatCellValue(wb.getSheet(sheetName).getRow(row).getCell(cell));
			  
			    return value;
			}
}
