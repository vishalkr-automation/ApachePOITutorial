package mukeshOtwani;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
public ExcelDataConfig(String filePath){
	File src=new File(filePath);
	try {
		FileInputStream fis=new FileInputStream(src);
		 wb=new XSSFWorkbook(fis);
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	
}

public  String getData(int sheetNo, int rowNum, int colNum){
	 sheet=wb.getSheetAt(sheetNo);
	String data=sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
	return data;
}

}
