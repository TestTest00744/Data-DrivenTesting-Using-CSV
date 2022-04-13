package ExceldataReader;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DataReader2 {

	@Test
	public void ReadTestData() throws Exception{
		File src = new File("D:\\DataSheets\\Data.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet Sheet1 = wb.getSheetAt(0);
		
		int rowcount = Sheet1.getLastRowNum();
		System.out.println("Total Rows is ...." + rowcount);
		
		for(int i=0;i<rowcount;i++){
			String data0 = Sheet1.getRow(i).getCell(0).getStringCellValue();
			System.out.println("Data From Excel Sheet1 is..    "    +  i  +  "  is  " +  data0);
		
			String data1 = Sheet1.getRow(i).getCell(1).getStringCellValue();
			System.out.println("Data From Excel Sheet1 is..    "    +  i  +  "  is  " +  data1);
		}
		
		wb.close();
					
	}
}














/*

String data1 = Sheet1.getRow(0).getCell(1).getStringCellValue();
System.out.println("Data From Excel Sheet is.." + data1);
	*/	