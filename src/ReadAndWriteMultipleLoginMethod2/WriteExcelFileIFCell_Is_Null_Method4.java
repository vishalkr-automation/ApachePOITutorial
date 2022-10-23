package ReadAndWriteMultipleLoginMethod2;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;



public class WriteExcelFileIFCell_Is_Null_Method4 {
	XSSFWorkbook wb;

	@Test(enabled = false)
	public void f() throws IOException {
		try{
		File src = new File(System.getProperty("user.dir") + "\\ExcelDataMukeshOtwani\\ExcelDataValue3.xlsx");
		FileInputStream fi = new FileInputStream(src);
		 wb = new XSSFWorkbook(fi);

		XSSFSheet sheet = wb.getSheetAt(0);

		FileOutputStream fout = new FileOutputStream(src);
       
		for(int i=0;i<=20;i++) {
		    Row row=sheet.createRow(i);
		    for(int m=0;m<=20;m++) {
		        Cell cell=row.createCell(m);

		        //cell.setCellType(cell.CELL_TYPE_STRING);
		        cell.setCellValue("good");
  
		    }
		}

		wb.write(fout);

		wb.close();
		}
		catch(Exception e){
			wb.close();
		}
	}
	
	
}
