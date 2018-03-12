package utility;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
//import utility.Constant;

public class UseExcel {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	
	//METHOD TO SET THE FILE PATH AND TO OPEN EXCEL FILE
	public static void setExcelFile (String Path, String SheetName) throws Exception {
		FileInputStream ExcelFile = new FileInputStream(Path);
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
	}
	
	//METHOD TO GET ROW COUNT OF EXCEL FILE (LENGTH OF EXCEL)
	public static int excelLength () {
		int Length;
		Length = ExcelWSheet.getLastRowNum();
		return Length;
	}
	
	//METHOD TO READ CELL DATA
	public static String getCellData (int RowNum, int ColNum) throws Exception {
		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
		String CellData = Cell.getStringCellValue();
		return CellData;
	}

}
