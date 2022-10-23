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

public class WriteExcelFileIFCell_Is_Null_Method1 {
	XSSFWorkbook wb;

	@Test(enabled = true)
	public void f1() throws IOException {
		
		File src = new File(".\\ExcelDataMukeshOtwani\\ExcelData5.xlsx");
		FileInputStream fi = new FileInputStream(src);
		 wb = new XSSFWorkbook(fi);

		XSSFSheet sheet = wb.getSheet("Sheet1");

		FileOutputStream fout = new FileOutputStream(src);

		int rowcount = sheet.getLastRowNum();
		if(rowcount==0){
		  rowcount++;	
		}
		else{
			System.out.println("Row count is more than zero");
		}
		Cell c;
		for (int i = 1; i <=rowcount; i++) {
			Row r = sheet.createRow(i);
			//Cell c = r.getCell(column, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
			 c=r.getCell(i);

			if (c == null) {
				  c=r.createCell(0);
			        c.setCellValue("good");
			} else {
				sheet.getRow(i).createCell(0).setCellValue("data1");
			}

		}

		wb.write(fout);

		wb.close();
		
	}

}
