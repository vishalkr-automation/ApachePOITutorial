package ReadWriteMultipleLoginMethod4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static File src;
	static FileOutputStream fout;
	
	public static void readExcelFile(String path) throws Exception{
		 src=new File(path);
		FileInputStream fis=new FileInputStream(src);
		 wb=new XSSFWorkbook(fis);
	}
	
	public static int getRowCount(String sheetName){
		sheet=wb.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		return rowCount;
	}
	
	public static String getData(String sheetName, int rowNum, int colNum){
		sheet = wb.getSheet(sheetName);
		String data=sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		return data;
	}
	
	public static void writeData(String sheetName, int rowNum, int colNum, String result) throws Exception{
		sheet=wb.getSheet(sheetName);
		sheet.getRow(rowNum).createCell(colNum).setCellValue(result);
		
		
	}

}
