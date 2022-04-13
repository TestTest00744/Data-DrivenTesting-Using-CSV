package library;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConfigReader {

	XSSFWorkbook wb;
	XSSFSheet Sheet1;

	public ExcelConfigReader(String excelpath) {
		try {
			File src = new File("D:\\DataSheets\\Data.xlsx");
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		   } catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getData(int sheetnumber, int row, int column) {
		Sheet1 = wb.getSheetAt(0);
		String data = Sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	
	
	
	
	
	
	

	public int getRowCount(int sheetIndex) {
		int row = wb.getSheetAt(sheetIndex).getLastRowNum();
		row = row + 1;
		return row;
	}
}
