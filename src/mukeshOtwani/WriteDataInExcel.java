package mukeshOtwani;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;



public class WriteDataInExcel {

	@Test(enabled=true)
	public void f() throws IOException{
		File src=new File(System.getProperty("user.dir")+ "\\ExcelDataMukeshOtwani\\ExcelDataValue2.xlsx");
		FileInputStream fi=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		
		XSSFSheet sheet=wb.getSheet("Sheet1");
		
		sheet.getRow(0).createCell(0).setCellValue("data1");
		FileOutputStream fout=new FileOutputStream(src);
		
		wb.write(fout);
		
		wb.close();	
		
	}
	
}
