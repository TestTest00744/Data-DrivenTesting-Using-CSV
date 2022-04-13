package ExceldataReader;

import org.testng.annotations.Test;

import library.ExcelConfigReader;

public class ExcelDataRed {

	@Test
	public void RedDataExl()
	{
		ExcelConfigReader excel = new ExcelConfigReader("D:\\DataSheets\\Data.xlsx");
		
		System.out.println(excel.getData(0, 0, 0));
		System.out.println(excel.getData(0, 1, 0));
		System.out.println(excel.getData(0, 0, 1));
		System.out.println(excel.getData(0, 1, 1));
		
	}
}
