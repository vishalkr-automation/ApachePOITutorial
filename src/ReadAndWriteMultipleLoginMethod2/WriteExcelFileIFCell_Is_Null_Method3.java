package ReadAndWriteMultipleLoginMethod2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteExcelFileIFCell_Is_Null_Method3 {
	
	@Test(enabled = true)
	public void f1() throws IOException {
		
		File src = new File(System.getProperty("user.dir") + "\\ExcelDataMukeshOtwani\\ExcelDataValue3.xlsx");
		FileInputStream fi = new FileInputStream(src);
		 XSSFWorkbook wb = new XSSFWorkbook(fi);

		XSSFSheet sheet = wb.getSheetAt(0);

		FileOutputStream fout = new FileOutputStream(src);
       
		for(int i=0;i<=2;i++) {
		    Row row=sheet.createRow(i);
		    for(int m=0;m<=2;m++) {
		        Cell cell=row.createCell(m);
		        //cell.setCellType(cell.CELL_TYPE_STRING);
		        cell.setCellValue("good");
		        
		    }
		}

		wb.write(fout);

		wb.close();
		
	}

}
