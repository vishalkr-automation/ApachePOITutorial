package mukeshOtwani;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;



public class ReadDataFromExcel {
	
	@Test(priority=1, enabled=false)
	public void readExcelData() throws Exception{
		
		File src=new File(".\\ExcelDataMukeshOtwani\\ExcelDataValue.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		
		String data0=sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println("First Cell Vallue: "+ data0);
		
		String data1=sheet.getRow(0).getCell(1).getStringCellValue();
		System.out.println("First Cell Vallue: "+ data1);
		
		wb.close();
		
	}
	
	@Test(priority=1, enabled=false)
	public void readExcelData2() throws Exception{
		
		File src=new File(".\\ExcelDataMukeshOtwani\\ExcelDataValue.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		
		int rowCount=sheet.getLastRowNum();
		
		for(int i=1; i<=rowCount; i++){
			String data=sheet.getRow(i).getCell(0).getStringCellValue();
   		    System.out.println(data);
		}
		
		wb.close();
	}
	
	@Test(priority=1, enabled=true)
	public void readExcelData3() throws Exception{
		
		File src=new File(".\\ExcelDataMukeshOtwani\\ExcelDataValue.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		
		int rowCount=sheet.getLastRowNum();
		
		
		for(int i=1; i<=rowCount; i++){
			Row row = sheet.getRow(i);
			
			for(int j=0; j<row.getLastCellNum(); j++){
				String data=sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(data);
			}
		}
		
		wb.close();
	}
}