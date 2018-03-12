package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;

public class ExcelUtil {
	public static XSSFWorkbook ExcelWBook;
	public static XSSFSheet ExcelWSheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static void setExcelFile (String path, String SheetName)throws Exception{
		try {
			FileInputStream ExcelFile = new FileInputStream (path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
	
		}catch (Exception e) {
			throw(e);
		}
	}
	
	public static String getCellValue (int RowNum, int ColNum) throws Exception {
		try {
		cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
		String CellData = cell.getStringCellValue();
		return CellData;
		
		}
		catch(Exception e) {
			return "";
		}
	}
	
	
	public static void setCellValue (String result, int RowNum, int ColNum) throws Exception {
		try {
			row = ExcelWSheet.getRow(RowNum);
			cell = row.getCell(ColNum, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
			if (cell == null) {
				cell = row.createCell(ColNum);
				cell.setCellValue(result);
			}
			else {
				cell.setCellValue(result);
			}
			
		
		
		//////////////////////////
		FileOutputStream fileOut = new FileOutputStream(Constant.TestDate_Path + Constant.TestData_File);
		ExcelWBook.write(fileOut);
		fileOut.flush();
		fileOut.close();
		}
		catch (Exception e) {
			throw(e);
		}
		
	}
}
